/**
 * @title ContractController.java
 * @author wuming
 * @date 2020年9月11日 上午11:55:56
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.contract;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cfckata.contract.reqeust.CreateContractRequest;
import com.cfckata.contract.response.ContractInfoResponse;
import com.cfckata.contract.response.CreateContractResponse;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 上午11:55:56
 */
@RestController
@RequestMapping("/contracts")
public class ContractController {

    /**
     * 创建合同
     * <描述>
     * @author wuming
     * @date 2020年9月11日 下午1:31:45 
     * @param request
     * @return 返回合同id
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CreateContractResponse createContract(@RequestBody CreateContractRequest request) {
        
        return new CreateContractResponse("123123");
    }
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ContractInfoResponse queryContract(@PathVariable String id) {
        ContractInfoResponse response = new ContractInfoResponse();
        
        response.setContractId("test");
        return response;
    }
}
