package com.cfckata.loan;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.assertj.core.data.Offset;
import org.junit.Test;
import com.cfckata.loan.common.RepayTypeEnum;
import com.cfckata.loan.domain.LoanDomain;
import com.cfckata.loan.dto.LoanInfoDto;
import com.cfckata.loan.dto.RepaymentPlans;


public class LoanDomainTest {

	@Test
	public void should_calculate_repayment_plan() {
		LoanInfoDto loanInfoDto = new LoanInfoDto();
		loanInfoDto.setContractId("HT-001");
		loanInfoDto.setApplyAmount(new BigDecimal("10000"));
		loanInfoDto.setInterestRate(new BigDecimal("0.01"));
		loanInfoDto.setRepaymentBankAccount("AAA");
		loanInfoDto.setRepaymentType(RepayTypeEnum.DEBJ.getCode());
		loanInfoDto.setTotalMonth(4);
		loanInfoDto.setWithdrawBankAccount("BBB");

		LoanDomain loan = new LoanDomain();
		List<RepaymentPlans> repaymentPlans = loan.genRepayPlan(loanInfoDto);
		
		assertThat(repaymentPlans.size()).isEqualTo(4);

		RepaymentPlans firstMonth = repaymentPlans.get(0);
		assertThat(firstMonth.getPayableAmount()).isCloseTo(new BigDecimal("2600"),
				Offset.offset(new BigDecimal("0.01")));

		RepaymentPlans lastMonth = repaymentPlans.get(3);
		assertThat(lastMonth.getPayableAmount()).isCloseTo(new BigDecimal("2525"),
				Offset.offset(new BigDecimal("0.01")));

		BigDecimal totalAmt = BigDecimal.ZERO;
		for (RepaymentPlans repaymentPlan : repaymentPlans) {
			totalAmt = totalAmt.add(repaymentPlan.getPayableAmount());
		}
		assertThat(totalAmt).isCloseTo(new BigDecimal("10250"), Offset.offset(new BigDecimal("0.001")));
	}

}
