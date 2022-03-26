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

	@GetMapping("myPassList")
	public String myPassList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> myPassList = null;
		logger.info("myPassList 호출");
		myPassList = passLogic.myPassList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(myPassList);
		return result;
	}
	
	@PostMapping("passInsert")
	public int passInsert(@RequestParam Map<String, Object> pMap) {
		
		logger.info("passInsert 호출");
		int result = 0;
		result = passLogic.passInsert(pMap);
		
		return result;
	}
	
	@PostMapping("passUpdate")
	public int passUpdate(@RequestParam Map<String, Object> pMap) {
		
		logger.info("passUpdate 호출");
		int result = 0;
		result = passLogic.passUpdate(pMap);
		
		return result;
	}
	
	@GetMapping("appointmentList")
	public String appointmentList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> appointmentList = null;
		logger.info("appointmentList 호출");
		appointmentList = passLogic.appointmentList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(appointmentList);
		return result;
	}
	
	@PostMapping("appointmentInsert")
	public int appointmentInsert(@RequestParam Map<String, Object> pMap) {

		logger.info("appointmentInsert 호출");
		int result = 0;
		result = passLogic.appointmentInsert(pMap);

		return result;
	}
	
	@PostMapping("appointmentCancel")
	public int appointmentCancel(@RequestParam Map<String, Object> pMap) {
		
		logger.info("appointmentCancel 호출");
		int result = 0;
		result = passLogic.appointmentCancel(pMap);
		
		return result;
	}
	
	@PostMapping("attendInsert")
	public int attendInsert(@RequestParam Map<String, Object> pMap) {
		
		logger.info("attendInsert 호출");
		int result = 0;
		result = passLogic.attendInsert(pMap);
		
		return result;
	}
	
	@GetMapping("attendList")
	public String attendList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> attendList = null;
		logger.info("attendList 호출");
		attendList = passLogic.attendList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(attendList);
		return result;
	}

	@PostMapping("searchPass")
	public String searchPass(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		logger.info("attendList 호출");
		list = passLogic.searchPass(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(list);
		return result;
	}
	

}
