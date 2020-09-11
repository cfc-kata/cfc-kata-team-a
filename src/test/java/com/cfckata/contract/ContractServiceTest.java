/**
 * @title ContractServiceTest.java
 * @author wuming
 * @date 2020年9月11日 下午3:20:09
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.contract;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.cfckata.common.SpringServiceTest;
import com.cfckata.contract.common.CustomerDto;
import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.reqeust.CreateContractRequest;
import com.cfckata.contract.service.ContractService;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 下午3:20:09
 */
public class ContractServiceTest extends SpringServiceTest{

    private ContractService service;
    
    @Before
    public void setUp() throws Exception {
        service = new ContractService();
    }
    
    @Test
    public void should_create_success_contract() throws Exception {
        //Given
     //   doNothing().when(payProxy).pay(anyString(), any());

        String id = "BJ001";
        String name = "张三";
        String idnumber =  "411327198609043116";
        String mobilePhone="18537118170";
        CustomerDto customer = new CustomerDto(id, name, idnumber, mobilePhone);
        
        BigDecimal interestRate = new BigDecimal("9.9");
        String repaymentType = "DEBX";
        String maturityDate = "2020-09-10";
        BigDecimal commitment = new BigDecimal("9000");

       CreateContractRequest request = new CreateContractRequest(customer, interestRate, repaymentType, maturityDate, commitment);
    
       Contract contract = service.createContract(request);

       assertThat(contract.getContractId()).isNotNull();
       
    }
    
    
    @Test
    public void should_success_when_contractId() {
        //Given
     //   doNothing().when(payProxy).pay(anyString(), any());

       String contractId = "123";
       Contract contract = service.getContract(contractId);

       assertThat(contract.getContractId()).isNotNull();
       assertThat(contract.getCustomer().getName()).isNotNull();
    }
}
