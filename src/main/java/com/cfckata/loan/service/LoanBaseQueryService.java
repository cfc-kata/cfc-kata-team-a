/**
 * @title LoanBaseQueryService.java
 * @author ZhangYb
 * @date 2020年9月11日 下午3:41:16
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.loan.service;

import org.springframework.stereotype.Service;

import com.cfckata.loan.dto.LoanAndRepayPlanDto;

/**
 * @Description <描述>
 * @author ZhangYb
 * @date 2020年9月11日 下午3:41:16
 */
@Service
public class LoanBaseQueryService {
	
	public LoanAndRepayPlanDto findLoanAndRepayPlan(String loanId) {
		LoanAndRepayPlanDto infoDto = new LoanAndRepayPlanDto();
		return infoDto;
	}

}
