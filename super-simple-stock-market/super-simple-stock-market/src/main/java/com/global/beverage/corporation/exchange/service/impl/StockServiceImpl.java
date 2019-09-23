package com.global.beverage.corporation.exchange.service.impl;

import java.text.DecimalFormat;
import java.util.List;

import com.global.beverage.corporation.exchange.StockMarketConstants;
import com.global.beverage.corporation.exchange.dao.StockDAO;
import com.global.beverage.corporation.exchange.dao.impl.StockDAOImpl;
import com.global.beverage.corporation.exchange.model.Stock;
import com.global.beverage.corporation.exchange.service.StockService;

public class StockServiceImpl implements StockService {

	private StockDAO stockDAO = new StockDAOImpl();
	DecimalFormat df = new DecimalFormat("0.00");

	@Override
	public List<Stock> getAllStocks() {
		return stockDAO.getAllStocks();
	}

	public Stock getStockByID(int stockID) {
		return stockDAO.getStockByID(stockID);
	}

	@Override
	public String calculateDividentYield(int stockID, double price) {
		Stock stock = getStockByID(stockID);
		double dividendYield;
		if (stock.getType().equalsIgnoreCase(StockMarketConstants.COMMON)) {
			dividendYield = stock.getLastDividend() / price;
		} else {
			dividendYield = (stock.getFixedDividend() * stock.getParValue()) / price;
		}
		return df.format(dividendYield);
	}

	public String calculatePERatio(int stockID, double price) {
		Stock stock = getStockByID(stockID);
		double peRatio = price / stock.getLastDividend();
		if (Double.isInfinite(peRatio)) {
			System.out.println(StockMarketConstants.DIVIDE_BY_ZERO_ERROR);
			peRatio = 0.0;
		}
		return df.format(peRatio);
	}

}
