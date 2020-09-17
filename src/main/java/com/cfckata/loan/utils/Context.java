package com.cfckata.loan.utils;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author zyb
 * @category 策略
 */
public class Context {

	
	private RepayPlanBase repayPlanBase;
	 
	   public Context(RepayPlanBase repayPlanBase){
	      this.repayPlanBase = repayPlanBase;
	   }
	 
	   public Map<Integer, BigDecimal> executeStrategy(BigDecimal loanAmt, BigDecimal intRate ,Integer loanTerm){
	      return repayPlanBase.doRepayPlan(loanAmt, intRate,loanTerm);
	   }
}
