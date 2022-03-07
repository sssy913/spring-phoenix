package com.kh.phoenix.classes;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassLogic {
	
	Logger logger = LogManager.getLogger(ClassLogic.class);
	
	@Autowired
	private ClassDao classDao = null;
	


	public List<Map<String, Object>> classList(Map<String, Object> pMap) {
		
		List<Map<String, Object>> list = null;
		list = classDao.classList(pMap);
		return list;
		
	}



	public int classInsert(Map<String, Object> pMap) {
		
		int result = 0;
		result = classDao.classInsert(pMap);
		return result;
		
	}

	

}
