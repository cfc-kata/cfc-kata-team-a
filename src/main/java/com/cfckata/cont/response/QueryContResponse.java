package com.cfckata.cont.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class QueryContResponse {

	/**
	 * 合同编号
	 */
	private String contNo;

	/**
	 * 证件类型
	 */
	private String idType;

	/**
	 * 证件号码
	 */
	private String idNo;

	/**
	 * 客户名称
	 */
	private String custName;

	/**
	 * 放款类型
	 */
	private String loanType;

	/**
	 * 合同金额
	 */
	private BigDecimal contAmt;

	/**
	 * 合同期限
	 */
	private String contTerm;

	/**
	 * 还款方式
	 */
	private String repayModeCode;

	/**
	 * 单笔提款期限
	 */
	private String singleLoanTerm;

	/**
	 * 执行利率
	 */
	private BigDecimal intRate;

	/**
	 * 还款日
	 */
	private String repayDt;

	/**
	 * 签订日期
	 */
	private String signDt;

	/**
	 * 失效日期
	 */
	private String endDt;

	/**
	 * 状态 100待生效 200生效 300 已作废 400失效 500 已结清 600 冻结
	 */
	private String sts;

	/***
	 * 创建时间
	 */
	private String creatTime;

	/***
	 * 更新时间
	 */
	private String updateTime;

}
