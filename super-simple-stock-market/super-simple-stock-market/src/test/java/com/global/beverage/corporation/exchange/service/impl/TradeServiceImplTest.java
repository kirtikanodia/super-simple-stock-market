package com.global.beverage.corporation.exchange.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.global.beverage.corporation.exchange.dao.impl.TradeDAOImpl;
import com.global.beverage.corporation.exchange.model.Trade;

public class TradeServiceImplTest {

	TradeServiceImpl tradeService = new TradeServiceImpl();
	List<Trade> tradeList = new ArrayList<>();
	TradeDAOImpl mockDao = Mockito.mock(TradeDAOImpl.class);

	@Before
	public void setUp() throws Exception {
		tradeList.add(new Trade(new Timestamp(System.currentTimeMillis()), 5, 1, 1.2));
		tradeList.add(new Trade(new Timestamp(System.currentTimeMillis()), 15, 2, 12.2));
		tradeList.add(new Trade(new Timestamp(System.currentTimeMillis()), 25, 2, 45.0));
		Mockito.when(mockDao.getVolumeWeightedStockPrice(4, 5)).thenReturn(tradeList);
	}

	@Test
	public void testCalculateGBCEIndex() {
		double result = tradeService.calculateGBCE(new ArrayList<>());
		Assert.assertNotNull(result);
		Assert.assertEquals(0.0, result, 0.1);
	}

	@Test
	public void testVolumeWeightedStockPrice() {
		double result = tradeService.getVolumeWeightedStockPrice(4, 5);
		Assert.assertNotNull(result);
		Assert.assertEquals(0.0, result, 0.1);
	}

}
