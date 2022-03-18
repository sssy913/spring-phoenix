package com.kh.phoenix.orders;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDao {
	Logger logger = LogManager.getLogger(OrdersDao.class);	
	private static final String NAMESPACE = "com.kh.phoenix.orders.";
	@Autowired
	private SqlSession sqlSession = null;

	public List<Map<String, Object>> productList(Map<String, Object> pMap) {
		logger.info("productList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"productList",pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return list;
	}
	
	public int productInsert(Map<String, Object> pMap) {
		logger.info("productInsert 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.insert(NAMESPACE+"productInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public int productUpdate(Map<String, Object> pMap) {
		logger.info("productUpdate 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.update(NAMESPACE+"productUpdate", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public int productDelete(Map<String, Object> pMap) {
		logger.info("productDelete 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.delete(NAMESPACE+"productDelete", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public List<Map<String, Object>> payList(Map<String, Object> pMap) {
		logger.info("payList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"payList",pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return list;
	}
	
	public int payInsert(Map<String, Object> pMap) {
		logger.info("payInsert 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.insert(NAMESPACE+"payInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public List<Map<String, Object>> myOrderList(Map<String, Object> pMap) {
		
		logger.info("myOrderList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"myOrderList",pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return list;
	}

	public int ordersInsert(Map<String, Object> pMap) {
		
		logger.info("memberInsert 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.insert(NAMESPACE+"ordersInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}

	public int ordersCancel(Map<String, Object> pMap) {
		logger.info("ordersCancel 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.update(NAMESPACE+"ordersCancel", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}

}
