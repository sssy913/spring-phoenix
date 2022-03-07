package com.kh.phoenix.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

	Logger logger = LogManager.getLogger(BoardDao.class);

	private static final String NAMESPACE = "com.kh.phoenix.";
	@Autowired
	private SqlSession sqlSession = null;

	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {

		logger.info("boardList 호출성공");

		List<Map<String, Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "boardList", pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return list;
	}

	public int boardInsert(Map<String, Object> pMap) {

		logger.info("boardInsert 호출성공");
		int result = -99;

		try {
			result = sqlSession.insert(NAMESPACE + "boardInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return result;
	}

}
