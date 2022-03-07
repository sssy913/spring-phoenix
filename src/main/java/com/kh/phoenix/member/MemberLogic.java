package com.kh.phoenix.member;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLogic {
	
	Logger logger = LogManager.getLogger(MemberLogic.class);
	
	@Autowired
	private MemberDao memberDao = null;
	


	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		
		List<Map<String, Object>> list = null;
		list = memberDao.memberList(pMap);
		return list;
		
	}



	public int memberInsert(Map<String, Object> pMap) {
		
		int result = 0;
		result = memberDao.memberInsert(pMap);
		return result;
		
	}

	

}
