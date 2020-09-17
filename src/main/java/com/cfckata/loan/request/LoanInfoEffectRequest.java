/**
 * @title LoanInfoEffectRequest.java
 * @author ZhangYb
 * @date 2020年9月11日 下午2;35;36
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.loan.request;

import java.math.BigDecimal;

/**
 * @Description <描述>
 * @author ZhangYb
 * @date 2020年9月11日 下午2;35;36
 */
public class LoanInfoEffectRequest {

	private String contractId;
	private BigDecimal applyAmount;
	private Integer totalMonth;
	private BigDecimal interestRate;
	private String withdrawBankAccount;
	private String repaymentBankAccount;
	private String repaymentType;
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
	public Integer getTotalMonth() {
		return totalMonth;
	}
	public void setTotalMonth(Integer totalMonth) {
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
	@Override
	public String toString() {
		return "LoanInfoEffectRequest [contractId=" + contractId + ", applyAmount=" + applyAmount + ", totalMonth="
				+ totalMonth + ", interestRate=" + interestRate + ", withdrawBankAccount=" + withdrawBankAccount
				+ ", repaymentBankAccount=" + repaymentBankAccount + ", repaymentType=" + repaymentType + "]";
	}
	public LoanInfoEffectRequest(String contractId, BigDecimal applyAmount, Integer totalMonth, BigDecimal interestRate,
			String withdrawBankAccount, String repaymentBankAccount, String repaymentType) {
		super();
		this.contractId = contractId;
		this.applyAmount = applyAmount;
		this.totalMonth = totalMonth;
		this.interestRate = interestRate;
		this.withdrawBankAccount = withdrawBankAccount;
		this.repaymentBankAccount = repaymentBankAccount;
		this.repaymentType = repaymentType;
	}
	
	
}
