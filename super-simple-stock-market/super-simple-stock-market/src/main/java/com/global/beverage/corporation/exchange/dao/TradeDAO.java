package com.global.beverage.corporation.exchange.dao;

import java.util.HashMap;
import java.util.List;

import com.global.beverage.corporation.exchange.model.Trade;

public interface TradeDAO {

	public HashMap<String, Trade> recordTrade(int stockID, int quanity, int type, double price);

	public List<Trade> getVolumeWeightedStockPrice(int stockID, int mins);

	public HashMap<String, Trade> getAllTrades();

}
