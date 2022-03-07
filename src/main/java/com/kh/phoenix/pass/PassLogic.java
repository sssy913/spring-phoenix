package com.kh.phoenix.pass;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassLogic {
	
	Logger logger = LogManager.getLogger(PassLogic.class);
	
	@Autowired
	private PassDao passDao = null;
	


	public List<Map<String, Object>> passList(Map<String, Object> pMap) {
		
		List<Map<String, Object>> list = null;
		list = passDao.passList(pMap);
		return list;
		
	}



	public int passInsert(Map<String, Object> pMap) {
		
		int result = 0;
		result = passDao.passInsert(pMap);
		return result;
		
	}

	

}
