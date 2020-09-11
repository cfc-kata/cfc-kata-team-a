/**
 * @title ContractController.java
 * @author wuming
 * @date 2020年9月11日 上午11:55:56
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cfckata.reqeust.CreateContractRequest;
import com.cfckata.response.CreateContractResponse;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 上午11:55:56
 */
@RestController
@RequestMapping("/contract")
public class ContractController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateContractResponse createContract(@RequestBody CreateContractRequest request) {
        
        return new CreateContractResponse("123123");
    }
}
