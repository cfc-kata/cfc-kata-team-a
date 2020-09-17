package com.cfckata.loan;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cfckata.common.SpringServiceTest;
import com.cfckata.loan.common.RepayTypeEnum;
import com.cfckata.loan.dto.LoanInfoDto;
import com.cfckata.loan.service.LoanEffectService;

public class LoanServiceTest extends SpringServiceTest {

	@Autowired
	LoanEffectService loanEffectService;

	@Test
	public void should_create_loan() throws Exception {
		LoanInfoDto loanInfoDto = new LoanInfoDto();
		loanInfoDto.setContractId("HT-001");
		loanInfoDto.setApplyAmount(new BigDecimal("10000"));
		loanInfoDto.setInterestRate(new BigDecimal("0.01"));
		loanInfoDto.setRepaymentBankAccount("AAA");
		loanInfoDto.setRepaymentType(RepayTypeEnum.DEBJ.getCode());
		loanInfoDto.setTotalMonth(4);
		loanInfoDto.setWithdrawBankAccount("BBB");
		// 放款支付
//		doNothing().when(unionPayProxy).pay(anyString(), any(), anyString());
//		when(contractService.preserveCommitment(anyString(), anyString(), any())).thenReturn(true);

		String loanId = loanEffectService.createLoan(loanInfoDto);

		assertThat(loanId).isNotNull();
	}
}
