package com.kh.phoenix.board;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardLogic {

	Logger logger = LogManager.getLogger(BoardLogic.class);

	@Autowired
	private BoardDao boardDao = null;

	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {

		List<Map<String, Object>> list = null;
		list = boardDao.boardList(pMap);
		return list;

	}

	public int boardInsert(Map<String, Object> pMap) {

		int result = 0;
		result = boardDao.boardInsert(pMap);
		return result;

	}

}
