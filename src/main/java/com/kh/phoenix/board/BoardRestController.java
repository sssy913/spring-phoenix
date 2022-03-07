package com.kh.phoenix.board;

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

	@GetMapping("boardList")
	public String boardList(@RequestParam Map<String, Object> pMap) {
		List<Map<String, Object>> boardList = null;
		logger.info("boardList 호출");
		boardList = boardLogic.boardList(pMap);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(boardList);
		return result;
	}

	@PostMapping("boardInsert")
	public int boardInsert(@RequestParam Map<String, Object> pMap) {

		logger.info("boardInsert 호출");
		int result = 0;
		result = boardLogic.boardInsert(pMap);

		return result;
	}

}
