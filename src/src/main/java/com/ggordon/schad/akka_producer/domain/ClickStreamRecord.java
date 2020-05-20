package com.ggordon.schad.akka_producer.domain;

/**
 * Represents a Click Stream Record
 * 
 * {
 * "customerId":3141,
 * "browser_y_position":1521.6713,
 * "zipCode":4774,
 * "browser_x_position":1226.6307,
 * "productId":458,
 * "date_time":"2020/05/18 19:13:12"
 * }
 * */
public class ClickStreamRecord {
	private int customerId;
	private int productId;
	private int zipCode;
	private float browser_x_position;
	private float browser_y_position;
	private String date_time;
	
	public ClickStreamRecord() {
		super();
	}

	public ClickStreamRecord(int customerId, int productId, int zipCode, float browser_x_position,
			float browser_y_position, String date_time) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.zipCode = zipCode;
		this.browser_x_position = browser_x_position;
		this.browser_y_position = browser_y_position;
		this.date_time = date_time;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	

	public float getBrowser_x_position() {
		return browser_x_position;
	}

	public void setBrowser_x_position(float browser_x_position) {
		this.browser_x_position = browser_x_position;
	}

	public float getBrowser_y_position() {
		return browser_y_position;
	}

	public void setBrowser_y_position(float browser_y_position) {
		this.browser_y_position = browser_y_position;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	@Override
	public String toString() {
		return "ClickStreamRecord [customerId=" + customerId + ", productId=" + productId + ", zipCode=" + zipCode
				+ ", browser_x_position=" + browser_x_position + ", browser_y_position=" + browser_y_position
				+ ", date_time=" + date_time + "]";
	}
	
	
	
	
	

}
