package com.global.beverage.corporation.exchange.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.global.beverage.corporation.exchange.StockMarketConstants;
import com.global.beverage.corporation.exchange.dao.StockDAO;
import com.global.beverage.corporation.exchange.model.Stock;

public class StockDAOImpl implements StockDAO {

	private List<Stock> stocks;

	public StockDAOImpl() {
		stocks = new ArrayList<>();
		stocks.add(new Stock(1, "TEA", StockMarketConstants.COMMON, 0, 0, 100));
		stocks.add(new Stock(2, "POP", StockMarketConstants.COMMON, 8, 0, 100));
		stocks.add(new Stock(3, "ALE", StockMarketConstants.COMMON, 23, 0, 60));
		stocks.add(new Stock(4, "GIN", StockMarketConstants.PREFERRED, 8, 2, 100));
		stocks.add(new Stock(5, "JOE", StockMarketConstants.COMMON, 13, 0, 250));
	}

	@Override
	public List<Stock> getAllStocks() {
		return stocks;
	}

	@Override
	public Stock getStockByID(int stockID) {
		for (Stock stockObj : stocks) {
			if (stockObj.getStockID() == stockID) {
				return stockObj;
			}
		}
		return null;
	}
}
