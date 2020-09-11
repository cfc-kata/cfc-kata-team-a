package com.cfckata.cont.response;

import lombok.Data;

@Data
public class CreatContResponse {
	
	/**
	 * 返回码
	 */
	private String code;
	
	/**
	 * 返回描述
	 */
	private String message;
	
	
	/**
	 * 合同号
	 */
	private String contNo;
	

}
