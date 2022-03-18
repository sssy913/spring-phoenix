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
	
	@GetMapping("productList")
	public String productList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> productList = null;
		logger.info("productList 호출");
		productList = ordersLogic.productList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(productList);
		return result;
	}
	
	@PostMapping("productInsert")
	public int productInsert(@RequestParam Map<String, Object> pMap) {
		
		logger.info("productInsert 호출");
		int result = 0;
		result = ordersLogic.productInsert(pMap);
		return result;
	}
	
	@PostMapping("productUpdate")
	public int productUpdate(@RequestParam Map<String, Object> pMap) {
		
		logger.info("productUpdate 호출");
		int result = 0;
		result = ordersLogic.productUpdate(pMap);
		return result;
	}
	
	@PostMapping("productDelete")
	public int productDelete(@RequestParam Map<String, Object> pMap) {
		
		logger.info("productDelete 호출");
		int result = 0;
		result = ordersLogic.productDelete(pMap);
		return result;
	}
	
	@GetMapping("payList")
	public String payList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> payList = null;
		logger.info("productList 호출");
		payList = ordersLogic.payList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(payList);
		return result;
	}
	
	@PostMapping("payInsert")
	public int payInsert(@RequestParam Map<String, Object> pMap) {
		
		logger.info("payInsert 호출");
		int result = 0;
		result = ordersLogic.payInsert(pMap);
		return result;
	}
	
	@GetMapping("myOrderList")
	public String myOrderList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> myOrderList = null;
		logger.info("myOrderList 호출");
		myOrderList = ordersLogic.myOrderList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(myOrderList);
		return result;
	}

	@PostMapping("ordersInsert")
	public int ordersInsert(@RequestParam Map<String, Object> pMap) {

		logger.info("ordersInsert 호출");
		int result = 0;
		result = ordersLogic.ordersInsert(pMap);
		return result;
	}
	
	@PostMapping("ordersCancel")
	public int ordersCancel(@RequestParam Map<String, Object> pMap) {
		
		logger.info("ordersCancel 호출");
		int result = 0;
		result = ordersLogic.ordersCancel(pMap);
		return result;
	}
	
}
