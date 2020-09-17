package com.cfckata.loan.utils;

import java.math.BigDecimal;
import java.util.Map;

public interface RepayPlanBase {

	public Map<Integer, BigDecimal> doRepayPlan(BigDecimal loanAmt, BigDecimal intRate ,Integer loanTerm);
}
