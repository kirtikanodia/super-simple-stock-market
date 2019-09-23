package com.global.beverage.corporation.exchange.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.global.beverage.corporation.exchange.model.Trade;

import junit.framework.Assert;

public class TradeDOAImplTest {

	TradeDAOImpl tradeDAO = new TradeDAOImpl();
	List<Trade> tradeList = new ArrayList<>();
	HashMap<String, Trade> tradeMap = new HashMap<>();
	TradeDAOImpl mockDao = Mockito.mock(TradeDAOImpl.class);

	@Before
	public void setUp() throws Exception {
		tradeMap = tradeDAO.recordTrade(1, 3, 2, 3.4);
		tradeMap = tradeDAO.recordTrade(3, 3, 2, 13.4);
		tradeMap = tradeDAO.recordTrade(5, 2, 1, 8.6);
		Mockito.when(mockDao.getAllTrades()).thenReturn(tradeMap);
	}

	@Test
	public void testGetAllTrades() {
		HashMap<String, Trade> tradeMapTest = mockDao.getAllTrades();
		Assert.assertNotNull(tradeMapTest);
		Assert.assertEquals(3, tradeMapTest.size());

	}

	@Test
	public void testRecordTrade() {
		Assert.assertEquals(3, tradeMap.size());
	}

	@Test
	public void testVolumetricMean() {

		try {
			tradeMap = tradeDAO.recordTrade(1, 3, 2, 3.4);
			Thread.sleep(200);
			tradeMap = tradeDAO.recordTrade(4, 3, 2, 13.4);
			Thread.sleep(200);
			tradeMap = tradeDAO.recordTrade(5, 2, 1, 8.6);
			Thread.sleep(200);
			tradeMap = tradeDAO.recordTrade(2, 25, 1, 348.6);
			Thread.sleep(200);
			List<Trade> trade = tradeDAO.getVolumeWeightedStockPrice(1, 5);
			Assert.assertEquals(1, trade.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
