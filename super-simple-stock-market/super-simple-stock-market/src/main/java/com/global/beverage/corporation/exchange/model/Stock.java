package com.global.beverage.corporation.exchange.model;

public class Stock {

	private int stockID;
	private String stockName;
	private String type;
	private int lastDividend;
	private int fixedDividend;
	private int parValue;

	public Stock(int stockID, String stock, String type, int lastDividend, int fixedDividend, int parValue) {
		this.stockID = stockID;
		this.stockName = stock;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	public int getStockID() {
		return stockID;
	}

	public void setStockID(int stockID) {
		this.stockID = stockID;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(int lastDividend) {
		this.lastDividend = lastDividend;
	}

	public int getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(int fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public int getParValue() {
		return parValue;
	}

	public void setParValue(int parValue) {
		this.parValue = parValue;
	}

}
