package com.kh.phoenix.board;

import java.util.HashMap;
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
@RequestMapping("/board/*")
public class BoardRestController {
	Logger logger = LogManager.getLogger(BoardRestController.class);

	@Autowired
	private BoardLogic boardLogic = null;
	@PostMapping("fileInsert")
	public int fileInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("fileInsert 호출");
		int result = 0;
		result = boardLogic.fileInsert(pMap);
		return result;
	}
	
	@GetMapping("masterList")
	public String masterList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		logger.info("masterList 호출");
		list = boardLogic.masterList(pMap);

		if(list!=null && pMap.get("master_bno")!=null) { //조회수 증가
			boardLogic.masterHitUpdate(pMap);
		}
		String result = null;
		Gson g = new Gson();
		result = g.toJson(list);
		return result;
	}

	@PostMapping("masterInsert")
	public int masterInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("masterInsert 호출");
		int result = 0;
		result = boardLogic.masterInsert(pMap);

		return result;
	}
	
	@PostMapping("masterUpdate")
	public int masterUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("masterUpdate 호출");
		int result = 0;
		result = boardLogic.masterUpdate(pMap);
		return result;
	}
	
	@PostMapping("masterDelete")
	public int masterDelete(@RequestParam Map<String, Object> pMap) {
		logger.info("masterDelete 호출");
		int result = 0;
		result = boardLogic.masterDelete(pMap);
		return result;
	}	
	
	@GetMapping("qnaList")
	public String qnaList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		logger.info("qnaList 호출");
		list = boardLogic.qnaList(pMap);
		
		if(list!=null && pMap.get("qna_bno")!=null) { //조회수 증가
			boardLogic.qnaHitUpdate(pMap);
		}
		String result = null;
		Gson g = new Gson();
		result = g.toJson(list);
		return result;
	}
	
	@PostMapping("qnaInsert")
	public int qnaInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("qnaInsert 호출");
		int result = 0;
		result = boardLogic.qnaInsert(pMap);
		
		return result;
	}
	
	@PostMapping("qnaUpdate")
	public int qnaUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("qnaUpdate 호출");
		int result = 0;
		result = boardLogic.qnaUpdate(pMap);
		return result;
	}
	
	@PostMapping("qnaDelete")
	public int qnaDelete(@RequestParam Map<String, Object> pMap) {
		logger.info("qnaDelete 호출");
		int result = 0;
		result = boardLogic.qnaDelete(pMap);
		return result;
	}	
	
	@GetMapping("qcList")
	public String qcList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		logger.info("qcList 호출");
		list = boardLogic.qcList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(list);
		return result;
	}
	
	@PostMapping("qcInsert")
	public int qcInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("qcInsert 호출");
		int result = 0;
		result = boardLogic.qcInsert(pMap);		
		return result;
	}
	
	@PostMapping("qcUpdate")
	public int qcUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("qcUpdate 호출");
		int result = 0;
		result = boardLogic.qcUpdate(pMap);
		return result;
	}
	
	@PostMapping("qcDelete")
	public int qcDelete(@RequestParam Map<String, Object> pMap) {
		logger.info("qcDelete 호출");
		int result = 0;
		result = boardLogic.qcDelete(pMap);
		return result;
	}	
	
	@GetMapping("reviewList")
	public String reviewList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		logger.info("reviewList 호출");
		list = boardLogic.reviewList(pMap);
		
		if(list!=null && pMap.get("review_bno")!=null) { //조회수 증가
			boardLogic.reviewHitUpdate(pMap);
		}
		String result = null;
		Gson g = new Gson();
		result = g.toJson(list);
		return result;
	}
	
	@PostMapping("reviewInsert")
	public int reviewInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("reviewInsert 호출");
		int result = 0;
		result = boardLogic.reviewInsert(pMap);		
		return result;
	}
	
	@PostMapping("reviewUpdate")
	public int reviewUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("reviewUpdate 호출");
		int result = 0;
		result = boardLogic.reviewUpdate(pMap);
		return result;
	}
	
	@PostMapping("reviewDelete")
	public int reviewDelete(@RequestParam Map<String, Object> pMap) {
		logger.info("reviewDelete 호출");
		int result = 0;
		result = boardLogic.reviewDelete(pMap);
		return result;
	}	
	
	@GetMapping("rcList")
	public String rcList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		logger.info("rcList 호출");
		list = boardLogic.rcList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(list);
		return result;
	}
	
	@PostMapping("rcInsert")
	public int rcInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("rcInsert 호출");
		int result = 0;
		result = boardLogic.rcInsert(pMap);		
		return result;
	}
	
	@PostMapping("rcUpdate")
	public int rcUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("rcUpdate 호출");
		int result = 0;
		result = boardLogic.rcUpdate(pMap);
		return result;
	}
	
	@PostMapping("rcDelete")
	public int rcDelete(@RequestParam Map<String, Object> pMap) {
		logger.info("rcDelete 호출");
		int result = 0;
		result = boardLogic.rcDelete(pMap);
		return result;
	}	
	
	
	@GetMapping("transBList")
	public String transBList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		logger.info("transBList 호출");
		list = boardLogic.transBList(pMap);
		
		if(list!=null && pMap.get("transb_bno")!=null) { //조회수 증가
			boardLogic.transferHitUpdate(pMap);
		}
		String result = null;
		Gson g = new Gson();
		result = g.toJson(list);
		return result;
	}
	
	@PostMapping("transBInsert")
	public int transBInsert(@RequestParam Map<String, Object> pMap) {

		logger.info("transBInsert 호출");
		int result = 0;
		result = boardLogic.transBInsert(pMap);

		return result;
	}
	
	@PostMapping("transBUpdate")
	public int transBUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("transBUpdate 호출");
		int result = 0;
		result = boardLogic.transBUpdate(pMap);
		return result;
	}
	
	@PostMapping("transBDelete")
	public int transBDelete(@RequestParam Map<String, Object> pMap) {
		logger.info("transBDelete 호출");
		int result = 0;
		result = boardLogic.transBDelete(pMap);
		return result;
	}
	
	@GetMapping("tcList")
	public String tcList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		logger.info("rcList 호출");
		list = boardLogic.tcList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(list);
		return result;
	}
	
	@PostMapping("tcInsert")
	public int tcInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("tcInsert 호출");
		int result = 0;
		result = boardLogic.tcInsert(pMap);

		return result;
	}
	
	@PostMapping("tcUpdate")
	public int tcUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("tcUpdate 호출");
		int result = 0;
		result = boardLogic.tcUpdate(pMap);
		return result;
	}
	
	@PostMapping("tcDelete")
	public int tcDelete(@RequestParam Map<String, Object> pMap) {
		logger.info("tcDelete 호출");
		int result = 0;
		result = boardLogic.tcDelete(pMap);
		return result;
	}
	
	@PostMapping("commentersList")
	public String commentersList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		logger.info("commentersList 호출");
		list = boardLogic.commentersList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(list);
		return result;
	}
	
	@PostMapping("transferInsert")
	public int trasferInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("transferInsert 호출");
		int result = 0;
		result = boardLogic.transferInsert(pMap);

		return result;
	}
	
	@PostMapping("myBoardList")
	public String myBoardList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> boardList = null;
		logger.info("boardList 호출");
		boardList = boardLogic.myBoardList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(boardList);
		return result;
	}
	
	@PostMapping("transferHitUpdate")
	public int transferHitUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("transferHitUpdate 호출");
		int result = 0;
		result = boardLogic.transferHitUpdate(pMap);

		return result;
	}
	@PostMapping("masterHitUpdate")
	public int masterHitUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("masterHitUpdate 호출");
		int result = 0;
		result = boardLogic.masterHitUpdate(pMap);
		
		return result;
	}
	@PostMapping("reviewHitUpdate")
	public int reviewHitUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("reviewHitUpdate 호출");
		int result = 0;
		result = boardLogic.reviewHitUpdate(pMap);
		
		return result;
	}
	@PostMapping("qnaHitUpdate")
	public int qnaHitUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("qnaHitUpdate 호출");
		int result = 0;
		result = boardLogic.qnaHitUpdate(pMap);
		
		return result;
	}
	


}
