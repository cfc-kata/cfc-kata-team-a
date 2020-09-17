package com.cfckata.loan.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.cfckata.loan.common.RepayTypeEnum;
import com.cfckata.loan.dto.LoanInfoDto;
import com.cfckata.loan.dto.RepaymentPlans;
import com.cfckata.loan.utils.AveCapRepayPlan;
import com.cfckata.loan.utils.Context;


/**
 * @category 业务逻辑校验
 * @author zyb
 */
public class LoanDomain implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	
	public String checkLoan(LoanInfoDto loanInfoDto) {
		// 各产品不同的业务参数校验
		return "123";
		
	}
	
	/**
	 * @param loanInfoDto 放款
	 * @return
	 */
	public String dirLoanAmt(LoanInfoDto loanInfoDto) {
		
		return "123";
	}
	
	/**
	 * @author zyb 生成还款计划
	 * @param loanInfoDto
	 * @return
	 */
	public List<RepaymentPlans> genRepayPlan(LoanInfoDto loanInfoDto) {
		Context con = null ;
		// 等额本金
		if(RepayTypeEnum.DEBJ.getCode().equals(loanInfoDto.getRepaymentType())) {
			 con = new Context(new AveCapRepayPlan());
		}
		BigDecimal loanAmt = loanInfoDto.getApplyAmount();
		BigDecimal intRate = loanInfoDto.getInterestRate();
		int loanTerm = Integer.valueOf(loanInfoDto.getTotalMonth());
		Map<Integer, BigDecimal> mapRepayPlan = con.executeStrategy(loanAmt, intRate, loanTerm);
		List<RepaymentPlans> repayPlanList = new ArrayList<RepaymentPlans>(mapRepayPlan.size());
		Iterator<Map.Entry<Integer, BigDecimal>> it = mapRepayPlan.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, BigDecimal> entry = it.next();
			RepaymentPlans pl = new RepaymentPlans();
			pl.setPeriodNo(entry.getKey().toString());
			pl.setPayableAmount(entry.getValue());
			pl.setPlanId(UUID.randomUUID().toString());
			pl.setStatus("N");
			repayPlanList.add(pl);
		}
		return repayPlanList;
	}
	
	
	
	
}
