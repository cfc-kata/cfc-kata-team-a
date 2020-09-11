/**
 * @title LoanBaseInfoResponse.java
 * @author ZhangYb
 * @date 2020年9月11日 下午3:03:34
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.loan.request;

/**
 * @Description <描述>
 * @author ZhangYb
 * @date 2020年9月11日 下午3:03:34
 */
public class LoanBaseInfoRequest {

	private String loanId;

	public LoanBaseInfoRequest() {

	}

	public LoanBaseInfoRequest(String loanId) {
		super();
		this.loanId = loanId;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

}
