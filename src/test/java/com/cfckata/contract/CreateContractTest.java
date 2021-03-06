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
import com.cfckata.contract.common.CustomerDto;
import com.cfckata.contract.reqeust.CreateContractRequest;
import com.cfckata.contract.response.ContractInfoResponse;
import com.cfckata.contract.response.CreateContractResponse;

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
        CustomerDto customer = new CustomerDto(id, name, idnumber, mobilePhone);
        
        BigDecimal interestRate = new BigDecimal("0.01");
        String repaymentType = "DEBX";
        String maturityDate = "2020-09-10";
        BigDecimal commitment = new BigDecimal("9000");

       CreateContractRequest request = new CreateContractRequest(customer, interestRate, repaymentType, maturityDate, commitment);
       //ResponseEntity<CreateContractResponse> responseEntity = .postForEntity(baseUrl + "/contract",request);
       ResponseEntity<CreateContractResponse> responseEntity =   this.restTemplate.postForEntity(baseUrl + "/contracts", request, CreateContractResponse.class);
       assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
             
       assertThat(responseEntity.getBody().getContractId()).isNotNull();
    }
    
    @Test
    public void should_query_success_contract() {
        String contractId="1231";
        ResponseEntity<ContractInfoResponse> responseEntity = this.restTemplate.getForEntity(baseUrl + "/contracts/"+contractId, ContractInfoResponse.class);
     
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
            
        assertThat(responseEntity.getBody().getCustomer().getName()).isNotNull();
    }
}
