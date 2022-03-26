package com.kh.phoenix.orders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@PropertySource("classpath:/application.properties")
@Service
public class OrdersLogic {
	Logger logger = LogManager.getLogger(OrdersLogic.class);	
	@Autowired
	private OrdersDao ordersDao = null;	
	
	/* @Value("${spring.kakao.adminkey}") */
	private String adminkey;

	public List<Map<String, Object>> productList(Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		list = ordersDao.productList(pMap);
		return list;
	}
	
	public int productInsert(Map<String, Object> pMap) {
		int result = 0;
		result = ordersDao.productInsert(pMap);
		return result;
	}
	
	public int productUpdate(Map<String, Object> pMap) {
		int result = 0;
		result = ordersDao.productUpdate(pMap);
		return 0;
	}
	
	public int productDelete(Map<String, Object> pMap) {
		int result = 0;
		result = ordersDao.productDelete(pMap);
		return 0;
	}
	
	public List<Map<String, Object>> myPayList(Map<String, Object> pMap) {
		List<Map<String, Object>> list = null;
		list = ordersDao.myPayList(pMap);
		return list;
	}
	
	public int payInsert(Map<String, Object> pMap) {
		int result = 0;
		result = ordersDao.payInsert(pMap);
		return result;
	}

	public List<Map<String, Object>> myOrderList(Map<String, Object> pMap) {
		
		List<Map<String, Object>> list = null;
		list = ordersDao.myOrderList(pMap);
		return list;
		
	}

	public int ordersInsert(Map<String, Object> pMap) {
		
		int result = 0;
		result = ordersDao.ordersInsert(pMap);
		return result;
		
	}

	public int ordersCancel(Map<String, Object> pMap) {
		int result = 0;
		result = ordersDao.ordersCancel(pMap);
		return result;
	}

	public String addDate(String dt, int y, int m, int d) { 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar cal = Calendar.getInstance(); 
		Date date;
		try {
			date = format.parse(dt);
			cal.setTime(date); 
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		cal.add(Calendar.YEAR, y); 
		cal.add(Calendar.MONTH, m); 
		cal.add(Calendar.DATE, d); 

		return format.format(cal.getTime()); 
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> kakaoPayReady(List<Map<String, Object>> list, List<Map<String, Object>> prlist, int pay_no) {

		RestTemplate restTemplate = new RestTemplate(); //통신 템플릿 만들기
		Map<String, Object> kMap = new HashMap<String, Object>(); //값을 받을 MAP
		StringBuffer totalName = new StringBuffer();
		String mem_no = list.get(0).get("mem_no").toString();
		int totalPrice = 0; //상품의 총 값
		int totalCnt = prlist.size(); //상품의 총 갯수

		for (int i = 0; i < prlist.size(); i++) {
			if (totalName.length() != 0) { 
				totalName.append(", ");
			}
			totalName.append(prlist.get(i).get("PROD_NAME").toString()); // 상품 이름들 합쳐주기
			totalPrice += (Integer.parseInt(prlist.get(i).get("PROD_PRICE").toString())); // 상품 가격들 합쳐주기
		}

		logger.info(pay_no + "/" + mem_no + "/" + totalName + "/" + totalCnt + "/" + totalPrice);

		// 서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + adminkey);
		// headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// 서버로 요청할 Body
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		
		params.add("cid", "TC0ONETIME"); //가맹점 번호
		params.add("partner_order_id", pay_no);
		params.add("partner_user_id", mem_no);
		params.add("item_name", totalName);
		params.add("quantity", totalCnt);
		params.add("total_amount", totalPrice);
		params.add("tax_free_amount", 0); //부가세
		params.add("approval_url", "http://localhost:3000/pay/success"); // 결제 성공시
		params.add("fail_url", "http://localhost:3000/pay/fail"); // 결제 실패 시
		params.add("cancel_url", "http://localhost:3000/pay/cancel"); //결제 취소 시
		
		try {
			HttpEntity<MultiValueMap<String, Object>> body = new HttpEntity<MultiValueMap<String, Object>>(params, headers);
			// 담은 정보를 보내기
			kMap = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/ready", body, Map.class);
			logger.info(kMap);
			
			return kMap;
			
		} catch (RestClientException e) {
			logger.info(e);
        } catch (Exception e) {
			logger.info(e);
		} 
		
		return null; //실패시 null 반환
	}
	
	
    @SuppressWarnings("unchecked")
	public Map<String, Object> kakaoPayInfo(Map<String, Object> map) {
    	
    	Map<String, Object> kaMap = new HashMap<String, Object>();
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + adminkey);
		// headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
 
        // 서버로 요청할 Body
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", map.get("tid"));
        params.add("partner_order_id", map.get("pay_no"));
        params.add("partner_user_id", map.get("mem_no"));
        params.add("pg_token", map.get("pg_token"));
        
        HttpEntity<MultiValueMap<String, Object>> body = new HttpEntity<MultiValueMap<String, Object>>(params, headers);
        
        try {
        	kaMap = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/approve", body, Map.class);
            logger.info(kaMap);
            
    		String type = kaMap.get("payment_method_type").toString();
    		if(type.equals("MONEY")) {
    			kaMap.put("pay_type", 0);
    		}else if(type.equals("CARD")) {
    			kaMap.put("pay_type", 1);
    		}
          
            return kaMap;
        
        } catch (RestClientException e) {
            logger.info(e);
        } catch (Exception e) {
        	logger.info(e);
        }
        
        return null;
    }
    
	public List<Map<String, Object>> ordersList(Map<String, Object> pMap) {
		return ordersDao.ordersList(pMap);
	}

	public List<Map<String, Object>> prodList(List<Map<String, Object>> list) {
		return ordersDao.prodList(list);
	}

	public int ordersInsert(List<Map<String, Object>> list) {
		return ordersDao.ordersInsert(list);
	}
	

	public int payNo() {
		return ordersDao.payNo();
	}
	
	public Map<String, Object> getTransInfo(Map<String, Object> pMap) {
		Map<String, Object> map = null;
		map = ordersDao.getTransInfo(pMap);
		return map;
	}


	public int payInsert(List<Map<String, Object>> ordersProdList) {
		return ordersDao.payInsert(ordersProdList);
	}

	public int ordersUpdate(Map<String, Object> kaMap) {
		return ordersDao.ordersUpdate(kaMap);
	}

	public int passInsert(List<Map<String, Object>> ordersProdList) {
		return ordersDao.passInsert(ordersProdList);
	}

	public List<Map<String, Object>> ordersProdList(Map<String, Object> map) {
		return ordersDao.ordersProdList(map);
	}


	public List<Map<String, Object>> payList(Map<String, Object> map) {
		return ordersDao.payList(map);
	}
		
	@Transactional
	public int transferInsert(Map<String, Object> pMap) {
		int result = 0;
		result = ordersDao.transferInsert(pMap);
		result = ordersDao.endOfPass(pMap);
		return result;
	}

	public int endOfPass(Map<String, Object> map) {
		int result = 0;
		result = ordersDao.endOfPass(map);
		return result;
	}

}
