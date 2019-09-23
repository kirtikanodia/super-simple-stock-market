package com.global.beverage.corporation.exchange.service;

import java.util.List;

import com.global.beverage.corporation.exchange.model.Stock;

public interface StockService {

	public List<Stock> getAllStocks();

	public Stock getStockByID(int stockID);

	public String calculateDividentYield(int stockID, double price);

	public String calculatePERatio(int stockID, double price);

}
