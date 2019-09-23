package com.global.beverage.corporation.exchange.service.impl;

import java.util.HashMap;
import java.util.List;

import com.global.beverage.corporation.exchange.dao.TradeDAO;
import com.global.beverage.corporation.exchange.dao.impl.TradeDAOImpl;
import com.global.beverage.corporation.exchange.model.Stock;
import com.global.beverage.corporation.exchange.model.Trade;
import com.global.beverage.corporation.exchange.service.TradeService;

public class TradeServiceImpl implements TradeService {

	TradeDAO tradeDAO = new TradeDAOImpl();

	@Override
	public void recordTrade(int stockID, int quanity, int type, double price) {
		tradeDAO.recordTrade(stockID, quanity, type, price);
	}

	public double getVolumeWeightedStockPrice(int stockID, int mins) {
		double amount = 0.0;
		int quantity = 0;
		List<Trade> tradeList = tradeDAO.getVolumeWeightedStockPrice(stockID, mins);
		if (tradeList.isEmpty()) {
			return 0.0;
		}
		for (Trade trade : tradeList) {
			amount = amount + (trade.getQuantity() * trade.getPrice());
			quantity = quantity + trade.getQuantity();
		}
		double volumeWeightedPrice = amount / quantity;
		return volumeWeightedPrice;
	}

	public double calculateGBCE(List<Stock> stocks) {
		HashMap<String, Trade> tradeMap = tradeDAO.getAllTrades();
		int recordedTrades = 0;
		double volumeWeightedPrice = 1.0;
		if (tradeMap.isEmpty()) {
			return 0.0;
		}
		for (Stock stockObj : stocks) {
			double volumePriceForEachStock = getVolumeWeightedStockPrice(stockObj.getStockID(), 0);
			if (volumePriceForEachStock != 0.0) {
				volumeWeightedPrice = volumeWeightedPrice * volumePriceForEachStock;
				recordedTrades = recordedTrades + 1;
			}
		}
		double geometricMean = Math.pow(volumeWeightedPrice, (double) 1 / recordedTrades);
		return geometricMean;
	}

}
