package com.kh.phoenix.orders;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/orders/*")
public class OrdersController {

	Logger logger = LogManager.getLogger(OrdersController.class);

	@Autowired
	private OrdersLogic ordersLogic = null;

	@GetMapping("ordersList")
	public String ordersList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> ordersList = null;
		logger.info("ordersList 호출");
		ordersList = ordersLogic.ordersList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(ordersList);
		return result;
	}

	@PostMapping("ordersInsert")
	public int ordersInsert(@RequestParam Map<String, Object> pMap) {

		logger.info("ordersInsert 호출");
		int result = 0;
		result = ordersLogic.ordersInsert(pMap);

		return result;
	}

}
