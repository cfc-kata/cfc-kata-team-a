package com.cfckata.response;

import lombok.Data;

@Data
public class RepayByIdResponse {

	String iouId;
	
	String createdTime;
	
	String contractId;
	
	String repaymentPlanId;
	
	String amount;
	
	String repaymentBankAccount;
}
