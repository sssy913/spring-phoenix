package com.kh.phoenix.member;

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
@RequestMapping("/member/*")
public class MemberController {

	Logger logger = LogManager.getLogger(MemberController.class);

	@Autowired
	private MemberLogic memberLogic = null;

	@GetMapping("memberList")
	public String memberList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> memberList = null;
		logger.info("memberList 호출");
		memberList = memberLogic.memberList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(memberList);
		return result;
	}
	
	@GetMapping("memberLogin")
	public String memberLogin(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> memberLogin = null;
		logger.info("memberLogin 호출");
		memberLogin = memberLogic.memberLogin(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(memberLogin);
		return result;
	}
	
	@GetMapping("memberDetail")
	public String memberDetail(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> memberDetail = null;
		logger.info("memberDetail 호출");
		memberDetail = memberLogic.memberDetail(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(memberDetail);
		return result;
	}

	@PostMapping("memberInsert")
	public int memberInsert(@RequestParam Map<String, Object> pMap) {

		logger.info("memberInsert 호출");
		int result = 0;
		result = memberLogic.memberInsert(pMap);
		return result;
	}
	
	@PostMapping("memberUpdate")
	public int memberUpdate(@RequestParam Map<String, Object> pMap) {
		
		logger.info("memberUpdate 호출");
		int result = 0;
		result = memberLogic.memberUpdate(pMap);	
		return result;
	}
	
	@PostMapping("memberDelete")
	public int memberDelete(@RequestParam Map<String, Object> pMap) {	
		logger.info("memberDelete 호출");
		int result = 0;
		result = memberLogic.memberDelete(pMap);
		return result;
	}
}
