/**
 * @title LoanBaseTest.java
 * @author ZhangYb
 * @date 2020年9月11日 下午2:51:24
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.loan;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cfckata.common.ApiTest;
import com.cfckata.loan.request.LoanInfoEffectRequest;
import com.cfckata.loan.response.LoanBaseInfoResponse;

/**
 * @Description <描述>
 * @author ZhangYb
 * @date 2020年9月11日 下午2:51:24
 */
public class LoanBaseTest extends ApiTest {

	@Test
	public void should_create_success_contract() {

		 String contractId = "11";
		 BigDecimal applyAmount = new BigDecimal("3000");
		 String totalMonth = "12";
		 BigDecimal interestRate = new BigDecimal("0.1");
		 String withdrawBankAccount = "1111";
		 String repaymentBankAccount = "2222";
		 String repaymentType = "DEBJ";

		LoanInfoEffectRequest request = new LoanInfoEffectRequest(contractId,applyAmount,totalMonth,interestRate
				,withdrawBankAccount,repaymentBankAccount,repaymentType);
	
		ResponseEntity<LoanBaseInfoResponse> responseEntity = this.restTemplate.postForEntity(baseUrl + "/loans",
				request, LoanBaseInfoResponse.class);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

	}

	@Test
	public void should_query_success_loan() {
		String loanId = "1111";
		ResponseEntity<LoanInfoEffectRequest> responseEntity = this.restTemplate
				.getForEntity(baseUrl + "/loans/" + loanId, LoanInfoEffectRequest.class);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
