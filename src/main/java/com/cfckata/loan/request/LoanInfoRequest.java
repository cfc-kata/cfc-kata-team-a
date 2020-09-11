/**
 * @title LoanInfoRequest.java
 * @author ZhangYb
 * @date 2020年9月11日 下午2:42:49
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.loan.request;

import java.math.BigDecimal;

/**
 * @Description <描述>
 * @author ZhangYb
 * @date 2020年9月11日 下午2:42:49
 */
public class LoanInfoRequest {
	
	/**
	 *  年利率
	 */
	private BigDecimal interestRate;
	
	/**
	 *  还款方式
	 */
	private String repaymentType;
	
	/**
	 * 到期日
	 */
	private String maturityDate;
	
	
	/**
	 * 放款金额
	 */
	private BigDecimal commitment;


	public LoanInfoRequest(BigDecimal interestRate, String repaymentType, String maturityDate, BigDecimal commitment) {
		super();
		this.interestRate = interestRate;
		this.repaymentType = repaymentType;
		this.maturityDate = maturityDate;
		this.commitment = commitment;
	}


	public BigDecimal getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}


	public String getRepaymentType() {
		return repaymentType;
	}


	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
	}


	public String getMaturityDate() {
		return maturityDate;
	}


	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}


	public BigDecimal getCommitment() {
		return commitment;
	}


	public void setCommitment(BigDecimal commitment) {
		this.commitment = commitment;
	}
}
