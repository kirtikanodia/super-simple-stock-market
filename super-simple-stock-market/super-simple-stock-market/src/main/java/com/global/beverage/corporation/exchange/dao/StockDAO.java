package com.global.beverage.corporation.exchange.dao;

import java.util.List;

import com.global.beverage.corporation.exchange.model.Stock;

public interface StockDAO {

	public List<Stock> getAllStocks();

	public Stock getStockByID(int stockID);

}
