/**
 * @title LoanAndRepayPlanDto.java
 * @author ZhangYb
 * @date 2020年9月11日 下午3:42:35
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.loan.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description <描述>
 * @author ZhangYb
 * @date 2020年9月11日 下午3:42:35
 */
public class LoanAndRepayPlanDto {

	private String loanId;
	private String contractId;
	private BigDecimal applyAmount;
	private String totalMonth;
	private BigDecimal interestRate;
	private String withdrawBankAccount;
	private String repaymentBankAccount;
	private String repaymentType;
	private List<RepaymentPlans> repaymentPlans;
	
	public LoanAndRepayPlanDto() {
		super();
	}
	


	public LoanAndRepayPlanDto(String loanId, String contractId, BigDecimal applyAmount, String totalMonth,
			BigDecimal interestRate, String withdrawBankAccount, String repaymentBankAccount, String repaymentType,
			List<RepaymentPlans> repaymentPlans) {
		super();
		this.loanId = loanId;
		this.contractId = contractId;
		this.applyAmount = applyAmount;
		this.totalMonth = totalMonth;
		this.interestRate = interestRate;
		this.withdrawBankAccount = withdrawBankAccount;
		this.repaymentBankAccount = repaymentBankAccount;
		this.repaymentType = repaymentType;
		this.repaymentPlans = repaymentPlans;
	}




	@Override
	public String toString() {
		return "LoanAndRepayPlanDto [loanId=" + loanId + ", contractId=" + contractId + ", applyAmount=" + applyAmount
				+ ", totalMonth=" + totalMonth + ", interestRate=" + interestRate + ", withdrawBankAccount="
				+ withdrawBankAccount + ", repaymentBankAccount=" + repaymentBankAccount + ", repaymentType="
				+ repaymentType + ", repaymentPlans=" + repaymentPlans + "]";
	}





	public String getLoanId() {
		return loanId;
	}



	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}



	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public BigDecimal getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(BigDecimal applyAmount) {
		this.applyAmount = applyAmount;
	}

	public String getTotalMonth() {
		return totalMonth;
	}

	public void setTotalMonth(String totalMonth) {
		this.totalMonth = totalMonth;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public String getWithdrawBankAccount() {
		return withdrawBankAccount;
	}

	public void setWithdrawBankAccount(String withdrawBankAccount) {
		this.withdrawBankAccount = withdrawBankAccount;
	}

	public String getRepaymentBankAccount() {
		return repaymentBankAccount;
	}

	public void setRepaymentBankAccount(String repaymentBankAccount) {
		this.repaymentBankAccount = repaymentBankAccount;
	}

	public String getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
	}




	public List<RepaymentPlans> getRepaymentPlans() {
		return repaymentPlans;
	}

	public void setRepaymentPlans(List<RepaymentPlans> repaymentPlans) {
		this.repaymentPlans = repaymentPlans;
	}

	
}
