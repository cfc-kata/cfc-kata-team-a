/**
 * @title LoanEffectService.java
 * @author ZhangYb
 * @date 2020年9月11日 下午2:49:41
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.loan.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.dto.LoanAndRepayPlanDto;
import com.cfckata.loan.dto.LoanInfoDto;
import com.cfckata.loan.dto.RepaymentPlans;

/**
 * @Description <描述>
 * @author ZhangYb
 * @date 2020年9月11日 下午2:49:41
 */
@Service
public class LoanEffectService {

	
	/**
	 * @param loanInfoDto
	 * @return
	 */
	public String createLoan(LoanInfoDto loanInfoDto){
		LoanDomain loanDomain = new LoanDomain();
		LoanAndRepayPlanDto loanInfo = new LoanAndRepayPlanDto();
		// 校验
		// 借据信息
		String loanId = loanDomain.checkLoan(loanInfoDto);
		// 还款列表
		List<RepaymentPlans> repaymentPlans = loanDomain.genRepayPlan(loanInfoDto);
		loanInfo.setLoanId(loanId);
		loanInfo.setApplyAmount(loanInfoDto.getApplyAmount());
		loanInfo.setRepaymentPlans(repaymentPlans);
		return loanInfo.getLoanId();
	}
	
	
}
