package com.ggordon.schad.akka_producer;

import java.time.Duration;
import org.apache.kafka.common.serialization.StringSerializer;

import com.ggordon.schad.akka_producer.cli.CliArguments;
import com.ggordon.schad.akka_producer.transformers.ClickStreamRecordTextTransformer;
import com.sampullara.cli.Args;

import akka.actor.ActorSystem;
import akka.kafka.ProducerSettings;
import akka.kafka.scaladsl.Producer;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.Source;
import akka.stream.javadsl.Tcp;



public class Driver {
	
	public static void main(String[] rawArgs) {
		Args.parseOrExit(CliArguments.class,rawArgs);
		
		final ActorSystem system = ActorSystem.create("SCHAD-Akka-Producer");
		
		
		ProducerSettings<String, String> kafkaProducerSettings = ProducerSettings
				.create(system, new StringSerializer(), new StringSerializer())
				.withBootstrapServers(
						String.join(",", CliArguments.kafkaBootstrapServers)
				);
		
		Tcp.get(system)
				.outgoingConnection(
						CliArguments.clickStreamServerAddress,
						CliArguments.clickStreamServerPort
                )
				.throttle(1, Duration.ofNanos(300))
				.map(ClickStreamRecordTextTransformer::convertToRecord)
				.map(ClickStreamRecordTextTransformer::convertToProducerRecordData)
				.map(
						line -> 
						   ClickStreamRecordTextTransformer
						         .convertToProducerRecord(line,
						        		 CliArguments.kafkaTopic
						        )
				)
				.toMat(
						Producer.plainSink(kafkaProducerSettings), 
						Keep.right()
				)
				.runWith(Source.empty(), system)
				;

		;
		
		
	}

}
