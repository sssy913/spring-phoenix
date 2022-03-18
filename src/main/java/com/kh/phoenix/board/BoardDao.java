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

	private static final String NAMESPACE = "com.kh.phoenix.board.";
	@Autowired
	private SqlSession sqlSession = null;
	public List<Map<String, Object>> masterList(Map<String, Object> pMap) {
		logger.info("masterList 호출성공");

		List<Map<String, Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "masterList", pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return list;
	}
	
	public int masterInsert(Map<String, Object> pMap) {
		logger.info("masterInsert 호출성공");
		int result = -99;

		try {
			result = sqlSession.insert(NAMESPACE + "masterInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return result;
	}
	
	public int masterUpdate(Map<String, Object> pMap) {
		logger.info("masterUpdate 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"masterUpdate", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public int masterDelete(Map<String, Object> pMap) {
		logger.info("masterUpdate 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"masterDelete", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public List<Map<String, Object>> qnaList(Map<String, Object> pMap) {
		logger.info("qnaList 호출성공");
		
		List<Map<String, Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "qnaList", pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return list;
	}
	
	public int qnaInsert(Map<String, Object> pMap) {
		logger.info("masterInsert 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.insert(NAMESPACE + "qnaInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return result;
	}
	
	public int qnaUpdate(Map<String, Object> pMap) {
		logger.info("masterUpdate 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"qnaUpdate", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public int qnaDelete(Map<String, Object> pMap) {
		logger.info("masterUpdate 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"qnaDelete", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public List<Map<String, Object>> qcList(Map<String, Object> pMap) {
		logger.info("qcList 호출성공");
		
		List<Map<String, Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "qcList", pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return list;
	}
	
	public int qcInsert(Map<String, Object> pMap) {
		logger.info("qcInsert 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.insert(NAMESPACE + "qcInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return result;
	}
	
	public int qcUpdate(Map<String, Object> pMap) {
		logger.info("qcUpdate 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"qcUpdate", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public int qcDelete(Map<String, Object> pMap) {
		logger.info("qcDelete 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"qcDelete", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public List<Map<String, Object>> reviewList(Map<String, Object> pMap) {
		logger.info("reviewList 호출성공");
		
		List<Map<String, Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "reviewList", pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return list;
	}
	
	public int reviewInsert(Map<String, Object> pMap) {
		logger.info("reviewInsert 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.insert(NAMESPACE + "reviewInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return result;
	}
	
	public int reviewUpdate(Map<String, Object> pMap) {
		logger.info("reviewUpdate 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"reviewUpdate", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public int reviewDelete(Map<String, Object> pMap) {
		logger.info("reviewDelete 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"reviewDelete", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	public List<Map<String, Object>> rcList(Map<String, Object> pMap) {
		logger.info("rcList 호출성공");
		
		List<Map<String, Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "rcList", pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return list;
	}
	
	public int rcInsert(Map<String, Object> pMap) {
		logger.info("rcInsert 호출성공");
		int result = -99;
		
		try {
			result = sqlSession.insert(NAMESPACE + "rcInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return result;
	}
	
	public int rcUpdate(Map<String, Object> pMap) {
		logger.info("rcUpdate 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"rcUpdate", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	public int rcDelete(Map<String, Object> pMap) {
		logger.info("rcDelete 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"rcDelete", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}
	
	
	public List<Map<String, Object>> transBList(Map<String, Object> pMap) {
		logger.info("transBList 호출성공");

		List<Map<String, Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "transBList", pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return list;
	}

	public List<Map<String, Object>> myBoardList(Map<String, Object> pMap) {
		logger.info("myBoardList 호출성공");
		List<Map<String, Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "myBoardList", pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return list;
	}

	public int transBInsert(Map<String, Object> pMap) {
		logger.info("transBInsert 호출성공");
		int result = -99;

		try {
			result = sqlSession.insert(NAMESPACE + "transBInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return result;
	}

	public int transBUpdate(Map<String, Object> pMap) {
		logger.info("transBUpdate 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"transBUpdate", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}

	public int transBDelete(Map<String, Object> pMap) {
		logger.info("transBDelete 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"transBDelete", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}

	public List<Map<String, Object>> tcList(Map<String, Object> pMap) {
		logger.info("tcList 호출성공");

		List<Map<String, Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "tcList", pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return list;
	}


	public int tcInsert(Map<String, Object> pMap) {
		logger.info("tcInsert 호출성공");
		int result = -99;

		try {
			result = sqlSession.insert(NAMESPACE + "tcInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return result;
	}

	public int tcUpdate(Map<String, Object> pMap) {
		logger.info("tcUpdate 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"tcUpdate", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}

	public int tcDelete(Map<String, Object> pMap) {
		logger.info("tcDelete 호출성공");
		int result = -99;
		try {
			result = sqlSession.update(NAMESPACE+"tcDelete", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => "+ e.toString());
		}
		return result;
	}

	public List<Map<String, Object>> commentersList(Map<String, Object> pMap) {
		logger.info("commentersList 호출성공");
		List<Map<String, Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "commentersList", pMap);
			logger.info(list);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return list;
	}

	public int transferInsert(Map<String, Object> pMap) {
		logger.info("trasferInsert 호출성공");
		int result = -99;

		try {
			result = sqlSession.insert(NAMESPACE + "transferInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return result;
	}

	public int fileInsert(Map<String, Object> pMap) {
		logger.info("Dao fileInsert 호출성공");
		int result = 0;
		
		try {
			result = sqlSession.insert(NAMESPACE + "fileInsert", pMap);
			logger.info(result);
		} catch (Exception e) {
			logger.info("Exection => " + e.toString());
		}
		return result;
	}

}
