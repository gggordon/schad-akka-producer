package com.ggordon.schad.akka_producer.transformers;

import java.io.IOException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggordon.schad.akka_producer.domain.ClickStreamRecord;

import akka.util.ByteString;

public class ClickStreamRecordTextTransformer {
	
	private static ObjectMapper jsonMapper = new ObjectMapper();
	private static Logger logger = LogManager.getLogger(ClickStreamRecordTextTransformer.class);
	
	public static ClickStreamRecord convertToRecord(ByteString line) {
		if(line == null)return null;
		String converted = line.utf8String().trim();
		try {
			return jsonMapper.readValue(converted, ClickStreamRecord.class);
		} catch (JsonParseException | JsonMappingException  e) {
			logger.error(String.format("Error when parsing json line - '%s'",line),e);
		} catch (IOException e) {
			logger.error(String.format("Error when parsing json line - '%s'",line),e);
		}
		return null;
		
	}
	

	
	public static String convertToProducerRecordData(ClickStreamRecord record){
		if(record == null) {
			return null;
		}
		return transform(record);
	}
	
	public static ProducerRecord<String, String> convertToProducerRecord(String line, String topic){
		if(line == null || topic == null) {
			return null;
		}
		return new ProducerRecord<String, String>(topic, line);
	}
	
	
	
	public static String transform(ClickStreamRecord record) {
		
		return String.format("%d|%d|%d|%.3f|%.3f|%s",
				record.getCustomerId(),
				record.getProductId(),
				record.getZipCode(),
				record.getBrowser_x_position(),
				record.getBrowser_y_position(),
				record.getDate_time()
				);
	}

}
