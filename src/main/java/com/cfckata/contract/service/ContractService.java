/**
 * @title ContractService.java
 * @author wuming
 * @date 2020年9月11日 下午3:03:46
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.contract.service;

import org.springframework.beans.BeanUtils;

import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.domain.Customer;
import com.cfckata.contract.reqeust.CreateContractRequest;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 下午3:03:46
 */
public class ContractService {

    
    public Contract createContract(CreateContractRequest request) {
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
}
