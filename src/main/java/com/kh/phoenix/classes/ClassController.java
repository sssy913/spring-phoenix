package com.kh.phoenix.classes;

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
@RequestMapping("/class/*")
public class ClassController {

	Logger logger = LogManager.getLogger(ClassController.class);

	@Autowired
	private ClassLogic classLogic = null;

	@GetMapping("classList")
	public String classList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> classList = null;
		logger.info("classList 호출");
		classList = classLogic.classList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(classList);
		return result;
	}

	@PostMapping("PassInsert")
	public int classInsert(@RequestParam Map<String, Object> pMap) {

		logger.info("ordersInsert 호출");
		int result = 0;
		result = classLogic.classInsert(pMap);

		return result;
	}

}
