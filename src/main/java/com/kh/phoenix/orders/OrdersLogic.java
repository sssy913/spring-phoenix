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
	


	public List<Map<String, Object>> ordersList(Map<String, Object> pMap) {
		
		List<Map<String, Object>> list = null;
		list = ordersDao.ordersList(pMap);
		return list;
		
	}



	public int ordersInsert(Map<String, Object> pMap) {
		
		int result = 0;
		result = ordersDao.ordersInsert(pMap);
		return result;
		
	}

	

}
