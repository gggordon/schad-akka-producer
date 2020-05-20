package com.ggordon.schad.akka_producer.transformers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

import com.ggordon.schad.akka_producer.domain.ClickStreamRecord;

import akka.util.ByteString;

public class ClickStreamRecordTextTransformerTest {
	
	 
	
	@Test
	public void testConvertToRecord() {
		ByteString line = ByteString.fromString(Stub.json);
		ClickStreamRecord result = ClickStreamRecordTextTransformer.convertToRecord(line);
		assertNotNull(result);
		assertEquals(result.getBrowser_x_position(),470.66043,4);
		assertEquals(result.getBrowser_y_position(),1649.9222,4);
		assertEquals(result.getCustomerId(),7271,0);
		assertEquals(result.getProductId(),4,0);
		assertEquals(result.getDate_time(),"2020/05/20 00:10:07");
		assertEquals(result.getZipCode(),11464,0);
		
		
	}
	

	@Test
	public void testConvertToProducerRecordData(){
		String expected="1|2|3|4.000|5.000|6";
		ClickStreamRecord record = new ClickStreamRecord(1, 2, 3, 4.0f, 5.0f, "6");
		assertEquals(expected,ClickStreamRecordTextTransformer.convertToProducerRecordData(record));
	}
	
	@Test
	public void convertToProducerRecord(){
		String line="line", topic="topic";
		ProducerRecord<String, String> result = ClickStreamRecordTextTransformer.convertToProducerRecord(line, topic);
		assertNotNull(result);
		assertEquals(line,result.value());
		assertEquals(topic,result.topic());
	}
	
	
	@Test
	public void testTransform() {
		
		String expected="1|2|3|4.000|5.000|6";
		ClickStreamRecord record = new ClickStreamRecord(1, 2, 3, 4.0f, 5.0f, "6");
		assertEquals(expected,ClickStreamRecordTextTransformer.transform(record));
	}
	
	final static class Stub{
		public static String json ="{\"customerId\":7271,\"browser_y_position\":1649.9222,\"zipCode\":11464,\"browser_x_position\":470.66043,\"productId\":4,\"date_time\":\"2020/05/20 00:10:07\"}";
	}

}
