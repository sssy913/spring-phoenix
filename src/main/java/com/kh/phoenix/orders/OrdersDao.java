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
	
	
	public List<Map<String, Object>> ordersList(Map<String, Object> pMap) {
		
		logger.info("ordersList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"ordersList",pMap);
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

	
}
