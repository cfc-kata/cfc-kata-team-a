package com.cfckata.repay;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.cfckata.common.ApiTest;
import com.cfckata.response.RepayByIdResponse;

public class RepayControllerTest extends ApiTest{
	
	//根据还款计划ID扣款-余额不足扣款失败场景
	@Test
	public void repay_by_id_amt_lack() {
        String repayId = "TEST_ORDER";

        ResponseEntity<RepayByIdResponse> response = this.restTemplate.getForEntity(baseUrl + "/repay/repayById/" + repayId,RepayByIdResponse.class);
        
        
        
	}
	
	//根据还款计划ID扣款-成功场景
	
	
	
	//批量扣款
	
}
