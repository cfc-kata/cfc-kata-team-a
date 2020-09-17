package com.cfckata.loan.common;

public enum RepayTypeEnum {

	
	DEBJ("1","等额本金");
	
	private final String code;
	private final String des;
	public String getCode() {
		return code;
	}
	public String getDes() {
		return des;
	}
	private RepayTypeEnum(String code, String des) {
		this.code = code;
		this.des = des;
	}
}
