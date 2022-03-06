package com.kh.phoenix.pass;

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
@RequestMapping("/pass/*")
public class PassController {

	Logger logger = LogManager.getLogger(PassController.class);

	@Autowired
	private PassLogic passLogic = null;

	@GetMapping("passList")
	public String ordersList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> passList = null;
		logger.info("ordersList 호출");
		passList = passLogic.passList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(passList);
		return result;
	}

	@PostMapping("PassInsert")
	public int passInsert(@RequestParam Map<String, Object> pMap) {

		logger.info("ordersInsert 호출");
		int result = 0;
		result = passLogic.passInsert(pMap);

		return result;
	}

}
