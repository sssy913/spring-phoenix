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
	
	public List<Map<String, Object>> myPayList(Map<String, Object> pMap) {
		logger.info("myPayList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"myPayList",pMap);
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




	public List<Map<String, Object>> prodList(List<Map<String, Object>> list) {
		
		logger.info("prodList 호출성공");

		List<Map<String,Object>> prlist = null;
		try {
			prlist = sqlSession.selectList(NAMESPACE+"prodList", list);
			
			logger.info(prlist);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return prlist;
	}

	
	
	public int ordersInsert(List<Map<String, Object>> list) {
		
		logger.info("ordersInsert 호출성공");
		int result = -99;
		try {
			result = sqlSession.insert(NAMESPACE+"ordersInsert", list);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}


	public int payNo() {
		logger.info("payNo 호출성공");
		int pay_no = -99;
		try {
			pay_no = sqlSession.selectOne(NAMESPACE+"payNo");
			logger.info(pay_no);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return pay_no;
	}




	public int payInsert(List<Map<String, Object>> ordersProdList) {
		logger.info("payInsert 호출성공");
		int result = -99;
		try {
			result = sqlSession.insert(NAMESPACE+"payInsert",ordersProdList);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}




	public List<Map<String, Object>> ordersProdList(Map<String, Object> map) {
		logger.info("ordersProdList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"ordersProdList",map);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return list;
	}

	
	

	public int ordersUpdate(Map<String, Object> kaMap) {
		logger.info("ordersProdList 호출성공");

		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"ordersUpdate",kaMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}




	public int passInsert(List<Map<String, Object>> ordersProdList) {
		logger.info("passInsert 호출성공");
		int result = -99;
		try {
			result = sqlSession.insert(NAMESPACE+"passInsert", ordersProdList);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}




	public List<Map<String, Object>> payList(Map<String, Object> map) {
		logger.info("payList 호출성공");

		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"payList",map);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return list;
	}

	public int transferInsert(Map<String, Object> pMap) {
		logger.info("transferInsert 호출성공");
		int result = -99;
		result = sqlSession.insert(NAMESPACE+"transferInsert", pMap);
		return result;
	}
	
	public Map<String, Object> getTransInfo(Map<String, Object> pMap) {
		logger.info("getTransInfo 호출성공");

		Map<String,Object> map = null;
		try {
			map = sqlSession.selectOne(NAMESPACE+"getTransInfo",pMap);
			logger.info(map);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return map;
	}

	public int endOfPass(Map<String, Object> pMap) {
		logger.info("endOfPass 호출성공");
		int result = -99;
		result = sqlSession.update(NAMESPACE+"endOfPass", pMap);
		return result;
	}
	
}
