package com.kh.phoenix.orders;

import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("myPayList")
	public String myPayList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> payList = null;
		logger.info("myPayList 호출");
		payList = ordersLogic.myPayList(pMap);
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

	@PostMapping("getTransInfo")
	public String getEday(@RequestParam Map<String, Object> pMap) {
		Map<String, Object> map = null;
		logger.info("getTransInfo 호출");
		map = ordersLogic.getTransInfo(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(map);
		return result;
	}

	@PostMapping("payReady") // 카카오 페이 결제 버튼 클릭 시
	public String payReady(@RequestBody List<Map<String, Object>> list) {

		logger.info("payReady 호출");
		logger.info(list); // 파라미터로 넘어온 list를 보여줌(mem_no, prod_no)

		Map<String, Object> orMap = new HashMap<String, Object>();
		Map<String, Object> kaMap = null;
		List<Map<String, Object>> ordersList = null;
		List<Map<String, Object>> prlist = null;
		int pay_no = 0;

		prlist = ordersLogic.prodList(list); // 상품 조회

		if (prlist.size() != list.size()) {
			return "상품번호 조회오류";
		}

		pay_no = ordersLogic.payNo(); // 결제 번호를 미리 받아오기
		if (pay_no == -99) {
			return "결제번호 증가오류";
		}

		kaMap = ordersLogic.kakaoPayReady(list, prlist, pay_no); // 카카오 쪽에 정보 넘겨주기

		if (kaMap == null) {
			return "카카오페이 준비오류";
		}

		for (int i = 0; i < list.size(); i++) { // 결제 후 승인 시 tid가 필요함
			list.get(i).put("tid", kaMap.get("tid"));
		}

		int ordersInsert = ordersLogic.ordersInsert(list); // orders에 기록 남기기

		if (ordersInsert == -99 || ordersInsert != list.size()) {
			return "주문 기록오류";
		}

		ordersList = ordersLogic.ordersList(list.get(0)); // orderList 한 번 더 불러오기 -> 주문 번호를 가져오기 위해서

		if (ordersList == null || ordersList.size() != list.size()) {
			return "주문번호 조회오류";
		}

		orMap.put("order_no", ordersList.get(0).get("ORDER_NO"));
		orMap.put("pay_no", pay_no);
		orMap.put("next_redirect_pc_url", kaMap.get("next_redirect_pc_url"));

		logger.info(orMap);

		Gson g = new Gson();
		String result = g.toJson(orMap);
		return result;
	}

	@Transactional
	@PostMapping("paySuccess") // 결제 승인을 기다리는 상태
	public String paySuccess(@RequestBody Map<String, Object> map) {

		logger.info("paySuccess 호출");
		List<Map<String, Object>> ordersProdList = null;
		Map<String, Object> kaMap = null;

		ordersProdList = ordersLogic.ordersProdList(map);

		if (ordersProdList == null) {
			return "상품 조회 오류";
		}

		map.put("tid", ordersProdList.get(0).get("ORDER_TID")); // tid를 추가

		kaMap = ordersLogic.kakaoPayInfo(map);

		if (kaMap == null) {
			return "카카오페이 결제오류";
		}

		for (Map<String, Object> tMap : ordersProdList) {
			tMap.put("pay_no", map.get("pay_no"));
			tMap.put("pay_type", kaMap.get("pay_type"));
			tMap.put("pass_status", 0);
			if ((tMap.get("PROD_TYPE").toString()).equals("0")) {
				tMap.put("pass_sday", map.get("pass_sday"));
				tMap.put("pass_eday", ordersLogic.addDate(map.get("pass_sday").toString(), 0,
						Integer.parseInt(tMap.get("PROD_AMOUNT").toString()), 0));
			} else if ((tMap.get("PROD_TYPE").toString()).equals("1")) {
				tMap.put("pass_sday", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				tMap.put("pass_eday", ordersLogic.addDate(map.get("pass_sday").toString(), 0,
						1 + (Integer.parseInt(tMap.get("PROD_AMOUNT").toString()) / 10), 0));
			} else if ((tMap.get("PROD_TYPE").toString()).equals("2")) {
				tMap.put("MEM_NO", map.get("upd_mem_no"));
				tMap.put("pass_status", 2);
				tMap.put("pass_sday", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

				Map<String, Object> rMap = ordersLogic.getTransInfo(map);
				tMap.put("pass_eday", rMap.get("PASS_EDAY").toString());
				tMap.put("PROD_AMOUNT", Integer.parseInt(rMap.get("PASS_CNT").toString()));
				tMap.put("PROD_TYPE", Integer.parseInt(rMap.get("PASS_TYPE").toString()));
			}
		}

		logger.info(ordersProdList);
		int payInsert = ordersLogic.payInsert(ordersProdList);

		if (payInsert == -99 || payInsert != ordersProdList.size()) {
			return "결제 기록오류";
		}

		int ordersUpdate = ordersLogic.ordersUpdate(kaMap);

		if (ordersUpdate == -99) {
			return "주문 업데이트오류";
		}

		int passInsert = ordersLogic.passInsert(ordersProdList);

		if (passInsert == -99) {
			return "이용권 기록오류";
		}

		Gson g = new Gson();
		String result = g.toJson(map);
		return result;
	}

	@GetMapping("payList")
	public String payList(@RequestParam Map<String, Object> map) {
		logger.info("payList 호출");
		List<Map<String, Object>> payList = null;
		payList = ordersLogic.payList(map);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(payList);
		return result;
	}

	 @PostMapping("transfer") 
	 public int transfer(@RequestBody Map<String,Object> pMap) { 
		logger.info("transfer 호출"); 
		logger.info(pMap); //파라미터로 넘어온 map을 보여줌(pass_no, org_mem, upd_mem)
	 
		int transferInsert = 0;
		transferInsert = ordersLogic.transferInsert(pMap);	

		return transferInsert;
	}
}
