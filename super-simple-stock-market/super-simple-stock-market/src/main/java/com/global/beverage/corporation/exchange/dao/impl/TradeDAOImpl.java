package com.global.beverage.corporation.exchange.dao.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.global.beverage.corporation.exchange.dao.TradeDAO;
import com.global.beverage.corporation.exchange.model.Trade;

public class TradeDAOImpl implements TradeDAO {

	HashMap<String, Trade> tradeMap;

	public TradeDAOImpl() {
		tradeMap = new HashMap<>();
	}

	@Override
	public HashMap<String, Trade> recordTrade(int stockID, int quanity, int type, double price) {
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		String key = stockID + "_" + currentTimeStamp;
		Trade trade = new Trade(currentTimeStamp, quanity, type, price);
		tradeMap.put(key, trade);
		return tradeMap;
	}

	public List<Trade> getVolumeWeightedStockPrice(int stockID, int mins) {
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		Timestamp oldTimestamp = new Timestamp(currentTimeStamp.getTime() - (mins * 60 * 1000));
		List<Trade> trade = new ArrayList<>();
		String[] keyArray;
		Set<String> keySet = tradeMap.keySet();
		if (keySet.isEmpty()) {
			return trade;
		}
		for (String key : keySet) {
			keyArray = key.split("_");
			Timestamp timestamp;
			try {
				if (Integer.parseInt(keyArray[0]) == stockID) {
					if (mins == 0) {
						trade.add(tradeMap.get(key));
					} else {
						timestamp = new Timestamp(
								new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(keyArray[1]).getTime());
						if (timestamp.before(currentTimeStamp) && timestamp.after(oldTimestamp)) {
							trade.add(tradeMap.get(key));
						}
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return trade;
	}

	@Override
	public HashMap<String, Trade> getAllTrades() {
		return tradeMap;
	}
}
