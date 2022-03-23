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

	public List<Map<String, Object>> myPassList(Map<String, Object> pMap) {
		
		List<Map<String, Object>> list = null;
		list = passDao.myPassList(pMap);
		return list;
		
	}

	public int passInsert(Map<String, Object> pMap) {
		int result = 0;
		result = passDao.passInsert(pMap);
		return result;
	}
	
	public int passUpdate(Map<String, Object> pMap) {
		int result = 0;
		result = passDao.passUpdate(pMap);
		return result;
	}
	
	public List<Map<String, Object>> appointmentList(Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		list = passDao.appointmentList(pMap);
		return list;
	}

	public int appointmentInsert(Map<String, Object> pMap) {
		
		int result = 0;
		result = passDao.appointmentInsert(pMap);
		return result;
		
	}

	public int appointmentCancel(Map<String, Object> pMap) {
		int result = 0;
		result = passDao.appointmentCancel(pMap);
		return result;
	}

	public int attendInsert(Map<String, Object> pMap) {
		int result = 0;
		result = passDao.attendInsert(pMap);
		return result;
	}

	public List<Map<String, Object>> attendList(Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		list = passDao.attendList(pMap);
		return list;
	}

	public List<Map<String, Object>> searchPass(Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		list = passDao.searchPass(pMap);
		return list;
	}


}
