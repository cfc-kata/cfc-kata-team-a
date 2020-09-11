/**
 * @title RepaymentPlans.java
 * @author ZhangYb
 * @date 2020年9月11日 下午3:31:03
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.loan.dto;

import java.math.BigDecimal;

/**
 * @Description <描述>
 * @author ZhangYb
 * @date 2020年9月11日 下午3:31:03
 */
public class RepaymentPlans {
	private String planId;
	private String periodNo;
	private String payableDate;
	private BigDecimal payableAmount;
	private BigDecimal payableInterest;
	private BigDecimal payableCapital;
	private String status;
	
	public RepaymentPlans() {
		super();
	}
	public RepaymentPlans(String planId, String periodNo, String payableDate, BigDecimal payableAmount,
			BigDecimal payableInterest, BigDecimal payableCapital, String status) {
		super();
		this.planId = planId;
		this.periodNo = periodNo;
		this.payableDate = payableDate;
		this.payableAmount = payableAmount;
		this.payableInterest = payableInterest;
		this.payableCapital = payableCapital;
		this.status = status;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(String periodNo) {
		this.periodNo = periodNo;
	}
	public String getPayableDate() {
		return payableDate;
	}
	public void setPayableDate(String payableDate) {
		this.payableDate = payableDate;
	}
	public BigDecimal getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}
	public BigDecimal getPayableInterest() {
		return payableInterest;
	}
	public void setPayableInterest(BigDecimal payableInterest) {
		this.payableInterest = payableInterest;
	}
	public BigDecimal getPayableCapital() {
		return payableCapital;
	}
	public void setPayableCapital(BigDecimal payableCapital) {
		this.payableCapital = payableCapital;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
