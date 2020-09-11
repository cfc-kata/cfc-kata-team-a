/**
 * @title ContractController.java
 * @author wuming
 * @date 2020年9月11日 上午11:55:56
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.contract;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cfckata.contract.common.CustomerDto;
import com.cfckata.contract.domain.Contract;
import com.cfckata.contract.reqeust.CreateContractRequest;
import com.cfckata.contract.response.ContractInfoResponse;
import com.cfckata.contract.response.CreateContractResponse;
import com.cfckata.contract.service.ContractService;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 上午11:55:56
 */
@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService service;
    /**
     * 创建合同
     * <描述>
     * @author wuming
     * @date 2020年9月11日 下午1:31:45 
     * @param request
     * @return 返回合同id
     * @throws Exception 
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CreateContractResponse createContract(@RequestBody CreateContractRequest request) throws Exception {
        
        Contract contract = service.createContract(request);
        
        CreateContractResponse response = new CreateContractResponse();
       
        
        BeanUtils.copyProperties(contract, response);
        
        
        
        return response;
    }
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ContractInfoResponse queryContract(@PathVariable String id) {
        
        Contract contract =  service.getContract(id);
        
        ContractInfoResponse response = new ContractInfoResponse();
        
        BeanUtils.copyProperties(contract, response);
        
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(contract.getCustomer().getId());
        customerDto.setIdnumber(contract.getCustomer().getIdnumber());
        customerDto.setMobilePhone(contract.getCustomer().getMobilePhone());
        customerDto.setName(contract.getCustomer().getName());
        
        
        response.setCustomer(customerDto);
        response.setContractId(contract.getContractId());
        return response;
    }
}
