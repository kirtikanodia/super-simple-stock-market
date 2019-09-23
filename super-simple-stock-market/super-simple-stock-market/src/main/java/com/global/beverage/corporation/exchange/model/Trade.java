package com.global.beverage.corporation.exchange.model;

import java.sql.Timestamp;

public class Trade {

	private Timestamp timestamp;
	private int quantity;
	private String transactionType;
	private double price;

	public Trade(Timestamp timestamp, int quantity, int transactionType, double price) {
		this.timestamp = timestamp;
		this.quantity = quantity;
		this.price = price;
		if (transactionType == 1) {
			this.transactionType = "BUY";
		} else {
			this.transactionType = "SELL";
		}
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Trade [ timestamp=" + timestamp + ", quantity=" + quantity + ", transactionType=" + transactionType
				+ ", price=" + price + "]";
	}
}
