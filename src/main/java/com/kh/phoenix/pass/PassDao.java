package com.kh.phoenix.pass;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PassDao {

	Logger logger = LogManager.getLogger(PassDao.class);
	
	private static final String NAMESPACE = "com.kh.phoenix.pass.";
	@Autowired
	private SqlSession sqlSession = null;
	
	
	public List<Map<String, Object>> passList(Map<String, Object> pMap) {
		
		logger.info("passList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"passList",pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return list;
	}

	
	
	public int passInsert(Map<String, Object> pMap) {
		
		logger.info("passInsert 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.insert(NAMESPACE+"passInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}

	
}
