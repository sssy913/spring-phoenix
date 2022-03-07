package com.kh.phoenix.classes;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClassDao {

	Logger logger = LogManager.getLogger(ClassDao.class);
	
	private static final String NAMESPACE = "com.kh.phoenix.class.";
	@Autowired
	private SqlSession sqlSession = null;
	
	
	public List<Map<String, Object>> classList(Map<String, Object> pMap) {
		
		logger.info("classList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"classList",pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return list;
	}

	
	
	public int classInsert(Map<String, Object> pMap) {
		
		logger.info("classInsert 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.insert(NAMESPACE+"classInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}

	
}
