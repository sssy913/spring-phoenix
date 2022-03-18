package com.kh.phoenix.orders;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersLogic {
	Logger logger = LogManager.getLogger(OrdersLogic.class);	
	@Autowired
	private OrdersDao ordersDao = null;	

	public List<Map<String, Object>> productList(Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		list = ordersDao.productList(pMap);
		return list;
	}
	
	public int productInsert(Map<String, Object> pMap) {
		int result = 0;
		result = ordersDao.productInsert(pMap);
		return result;
	}
	
	public int productUpdate(Map<String, Object> pMap) {
		int result = 0;
		result = ordersDao.productUpdate(pMap);
		return 0;
	}
	
	public int productDelete(Map<String, Object> pMap) {
		int result = 0;
		result = ordersDao.productDelete(pMap);
		return 0;
	}
	
	public List<Map<String, Object>> payList(Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		list = ordersDao.payList(pMap);
		return list;
	}
	
	public int payInsert(Map<String, Object> pMap) {
		int result = 0;
		result = ordersDao.payInsert(pMap);
		return result;
	}

	public List<Map<String, Object>> myOrderList(Map<String, Object> pMap) {
		
		List<Map<String, Object>> list = null;
		list = ordersDao.myOrderList(pMap);
		return list;
		
	}

	public int ordersInsert(Map<String, Object> pMap) {
		
		int result = 0;
		result = ordersDao.ordersInsert(pMap);
		return result;
		
	}

	public int ordersCancel(Map<String, Object> pMap) {
		int result = 0;
		result = ordersDao.ordersCancel(pMap);
		return result;
	}

}
