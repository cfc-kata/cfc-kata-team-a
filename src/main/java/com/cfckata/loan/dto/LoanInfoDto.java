/**
 * @title LoanInfoDto.java
 * @author ZhangYb
 * @date 2020年9月11日 下午3:12:27
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.loan.dto;

import java.math.BigDecimal;

/**
 * @Description <描述>
 * @author ZhangYb
 * @date 2020年9月11日 下午3:12:27
 */
public class LoanInfoDto {
	
	private String id;
	private String loanId;
	private String contractId;
	private BigDecimal applyAmount;
	private Integer totalMonth;
	private BigDecimal interestRate;
	private String withdrawBankAccount;
	private String repaymentBankAccount;
	private String repaymentType;
	
	
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
		return "LoanInfoDto [loanId=" + loanId + ", contractId=" + contractId + ", applyAmount=" + applyAmount
				+ ", totalMonth=" + totalMonth + ", interestRate=" + interestRate + ", withdrawBankAccount="
				+ withdrawBankAccount + ", repaymentBankAccount=" + repaymentBankAccount + ", repaymentType="
				+ repaymentType + "]";
	}
	public LoanInfoDto(String loanId, String contractId, BigDecimal applyAmount, Integer totalMonth,
			BigDecimal interestRate, String withdrawBankAccount, String repaymentBankAccount, String repaymentType) {
		super();
		this.loanId = loanId;
		this.contractId = contractId;
		this.applyAmount = applyAmount;
		this.totalMonth = totalMonth;
		this.interestRate = interestRate;
		this.withdrawBankAccount = withdrawBankAccount;
		this.repaymentBankAccount = repaymentBankAccount;
		this.repaymentType = repaymentType;
	}
	
	public LoanInfoDto(String contractId, BigDecimal applyAmount, Integer totalMonth,
			BigDecimal interestRate, String withdrawBankAccount, String repaymentBankAccount, String repaymentType) {
		super();
		this.contractId = contractId;
		this.applyAmount = applyAmount;
		this.totalMonth = totalMonth;
		this.interestRate = interestRate;
		this.withdrawBankAccount = withdrawBankAccount;
		this.repaymentBankAccount = repaymentBankAccount;
		this.repaymentType = repaymentType;
	}
	public LoanInfoDto() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
