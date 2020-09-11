/**
 * @title LoanEffectResponse.java
 * @author ZhangYb
 * @date 2020年9月11日 下午2:47:31
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.loan.response;

/**
 * @Description <描述>
 * @author ZhangYb
 * @date 2020年9月11日 下午2:47:31
 */
public class LoanEffectResponse {

	private String loanId;

	public LoanEffectResponse(String loanId) {
		this.loanId = loanId;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

}
