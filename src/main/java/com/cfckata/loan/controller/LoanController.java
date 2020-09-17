/**
 * @title LoanController.java
 * @author ZhangYb
 * @date 2020年9月11日 下午2:58:42
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.loan.controller;

import java.math.BigDecimal;

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

import com.cfckata.loan.dto.LoanAndRepayPlanDto;
import com.cfckata.loan.dto.LoanInfoDto;
import com.cfckata.loan.request.LoanInfoEffectRequest;
import com.cfckata.loan.response.LoanBaseInfoResponse;
import com.cfckata.loan.response.LoanEffectResponse;
import com.cfckata.loan.service.LoanBaseQueryService;
import com.cfckata.loan.service.LoanEffectService;

/**
 * @Description <描述>
 * @author ZhangYb
 * @date 2020年9月11日 下午2:58:42
 */
@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	LoanEffectService loanEffectService;
	
	@Autowired
	LoanBaseQueryService loanBaseQueryService;
	
    /**
     * <放款>
     * @author ZhangYb
     * @date 2020年9月11日 下午2:59:15 
     * @param request
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public LoanEffectResponse createLoan(@RequestBody LoanInfoEffectRequest request) {
    	if(null == request) {
    		// TODO
    	}
	   	 String contractId = request.getContractId();
		 BigDecimal applyAmount = request.getApplyAmount();
		 Integer totalMonth = request.getTotalMonth();
		 BigDecimal interestRate = request.getInterestRate();
		 String withdrawBankAccount = request.getWithdrawBankAccount();
		 String repaymentBankAccount = request.getRepaymentBankAccount();
		 String repaymentType = request.getRepaymentType();
		 
		 //必输参数校验，参数合合法性校验
		 
		LoanInfoDto info = new LoanInfoDto(contractId, applyAmount, totalMonth, interestRate, withdrawBankAccount,
				repaymentBankAccount, repaymentType);
    	String loanId = loanEffectService.createLoan(info);
        return new LoanEffectResponse(loanId);
    }
    
    /**
     * <查询借据信息>
     * @author ZhangYb
     * @date 2020年9月11日 下午2:59:23 
     * @param id
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public LoanBaseInfoResponse findLoanInfo(@PathVariable String id) {
    	if(null == id) {
    		return null;
    	}
    	LoanBaseInfoResponse response = new LoanBaseInfoResponse();
    	LoanAndRepayPlanDto infoDto = loanBaseQueryService.findLoanAndRepayPlan(id);
    	response.setContractId(infoDto.getContractId());
    	response.setApplyAmount(response.getApplyAmount());
    	response.setTotalMonth(infoDto.getTotalMonth());
    	response.setInterestRate(infoDto.getInterestRate());
    	response.setRepaymentBankAccount(infoDto.getRepaymentBankAccount());
    	response.setWithdrawBankAccount(infoDto.getWithdrawBankAccount());
    	response.setRepaymentType(infoDto.getRepaymentType());
    	response.setRepaymentPlans(infoDto.getRepaymentPlans());
        return response;
    }


}
