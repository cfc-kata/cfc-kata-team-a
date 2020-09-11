/**
 * @title ContractService.java
 * @author wuming
 * @date 2020年9月11日 下午3:03:46
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.contract.service;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.domain.Customer;
import com.cfckata.contract.reqeust.CreateContractRequest;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 下午3:03:46
 */
@Service
public class ContractService {

    
    /**
     * 
     * 创建新合同
     * @author wuming
     * @date 2020年9月11日 下午3:32:47 
     * @param request
     * @return
     * @throws Exception 
     */
    public Contract createContract(CreateContractRequest request) throws Exception {
        /**
         * 构造合同domain
         */
        Contract contract = new Contract();
        Customer customer = new Customer();
        BeanUtils.copyProperties(request.getCustomer(), customer);
        contract.setCustomer(customer);
        contract.setCommitment(request.getCommitment());
        contract.setInterestRate(request.getInterestRate());
        contract.setMaturityDate(request.getMaturityDate());
        contract.setRepaymentType(request.getRepaymentType());
        
        
        contract.validateNewContract();
        
        /**
         * @TODO 保存 返回ID
         */
        contract.setContractId("123");
        
        
        return contract;
    }
    
    
    /**
     * 获取合同信息
     * @author wuming
     * @date 2020年9月11日 下午3:33:39 
     * @param contractId
     * @return
     */
    public Contract getContract(String contractId) {
        
        /**
         * @TODO根据合同号 查询合同信息
         */
        
        Customer customer = new Customer();
        
        customer.setId("xxxx");
        customer.setIdnumber("411327198609043112");
        customer.setMobilePhone("18527118172");
        customer.setName("牛二");
        
        Contract contract = new Contract();
        contract.setCustomer(customer);
        contract.setCommitment(new BigDecimal("9000"));
        contract.setContractId("niubi123");
        contract.setInterestRate(new BigDecimal("9.9"));
        contract.setMaturityDate("2020-09-30");
        contract.setRepaymentType("DEBX");
        contract.setStatus("ACTIVE");
        
        
        return contract;
    }
}
