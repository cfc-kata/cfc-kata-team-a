/**
 * @title CreateContractTest.java
 * @author wuming
 * @date 2020年9月11日 上午11:22:43
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.contract;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cfckata.common.ApiTest;
import com.cfckata.reqeust.CreateContractRequest;
import com.cfckata.reqeust.Customer;
import com.cfckata.response.CreateContractResponse;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 上午11:22:43
 */
public class CreateContractTest extends ApiTest{

    
   

    @Test
    public void should_create_success_contract() {
        
        String id = "BJ001";
        String name = "张三";
        String idnumber =  "411327198609043116";
        String mobilePhone="18537118170";
        Customer customer = new Customer(id, name, idnumber, mobilePhone);
        //Given
        
        BigDecimal interestRate = new BigDecimal("9.9");
        String repaymentType = "DEBX";
        String maturityDate = "2020-09-10";
        BigDecimal commitment = new BigDecimal("9000");

       CreateContractRequest request = new CreateContractRequest(customer, interestRate, repaymentType, maturityDate, commitment);
       System.err.println(baseUrl + "/contract");
       //ResponseEntity<CreateContractResponse> responseEntity = .postForEntity(baseUrl + "/contract",request);
       ResponseEntity<CreateContractResponse> responseEntity =   this.restTemplate.postForEntity(baseUrl + "/contract", request, CreateContractResponse.class);

       assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
              
       
    }
    
}
