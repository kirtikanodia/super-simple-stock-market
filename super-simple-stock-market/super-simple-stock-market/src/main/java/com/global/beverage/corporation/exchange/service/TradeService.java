package com.global.beverage.corporation.exchange.service;

import java.util.List;

import com.global.beverage.corporation.exchange.model.Stock;

public interface TradeService {

	public void recordTrade(int stockID, int quanity, int type, double price);

	public double getVolumeWeightedStockPrice(int stockID, int mins);

	public double calculateGBCE(List<Stock> stock);
}
