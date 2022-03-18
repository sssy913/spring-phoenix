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
	
	public List<Map<String, Object>> myPassList(Map<String, Object> pMap) {
		
		logger.info("myPassList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"myPassList",pMap);
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
	
	public int passUpdate(Map<String, Object> pMap) {
		logger.info("passUpdate 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.update(NAMESPACE+"passUpdate", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public List<Map<String, Object>> appointmentList(Map<String, Object> pMap) {
		logger.info("appointmentList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"appointmentList",pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return list;
	}
	
	public int appointmentInsert(Map<String, Object> pMap) {
		
		logger.info("appointmentInsert 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.insert(NAMESPACE+"appointmentInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}

	public int appointmentCancel(Map<String, Object> pMap) {
		logger.info("appointmentCancel 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.update(NAMESPACE+"appointmentCancel", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}

	public int attendInsert(Map<String, Object> pMap) {
		logger.info("attendInsert 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.insert(NAMESPACE+"attendInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public List<Map<String, Object>> attendList(Map<String, Object> pMap) {
		logger.info("attendList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"attendList",pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return list;
	}

	
}
