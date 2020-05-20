package com.ggordon.schad.akka_producer.cli;

import com.sampullara.cli.Argument;

public class CliArguments {
	// -- Click stream Service Arguments
	@Argument(alias="csa",description="Click Stream Server Address",required = true,prefix = "--")
	public static String clickStreamServerAddress;
	
	@Argument(alias="csp",description="Click Stream Server Port",required = true,prefix = "--")
	public static Integer clickStreamServerPort;
	
	
	// -- KAFKA Arguments
	
	@Argument(alias="topic",description="Kafka Topic to Publish To",required=true,prefix = "--")
	public static String kafkaTopic;
	
	@Argument(alias="bootstrap",description="Kafka Bootstrap Server",required=true,prefix = "--")
	public static String kafkaBootstrapServers[];// = new String[] {"192.168.1.7:9092"};
	
	
//	String zookeeperMaster = "localhost:2181";

}
