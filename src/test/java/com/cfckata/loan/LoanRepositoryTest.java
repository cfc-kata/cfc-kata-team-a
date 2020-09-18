package com.cfckata.loan;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.cfckata.common.RepositoryTest;
import com.cfckata.loan.common.RepayTypeEnum;
import com.cfckata.loan.dto.LoanInfoDto;
import com.cfckata.loan.repository.LoanRepository;

public class LoanRepositoryTest extends RepositoryTest{

	@Autowired
	private LoanRepository loanRepository;

	
    @Test
//    @Sql(scripts = "classpath:sql/loan-test-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void should_selctLoanId_version() {
    	LoanInfoDto loanInfoDto = new LoanInfoDto();
		loanInfoDto.setContractId("HT-001");
		loanInfoDto.setLoanId("1111");
		loanInfoDto.setApplyAmount(new BigDecimal("10000"));
		loanInfoDto.setInterestRate(new BigDecimal("0.01"));
		loanInfoDto.setRepaymentBankAccount("AAA");
		loanInfoDto.setRepaymentType(RepayTypeEnum.DEBJ.getCode());
		loanInfoDto.setTotalMonth(4);
		loanInfoDto.setWithdrawBankAccount("BBB");
        loanRepository.save(loanInfoDto);
        LoanInfoDto loanInfoDto1 = loanRepository.findById("1111");
        String loanId = loanInfoDto1.getLoanId();
        assertThat(loanId).isEqualTo("1111");
    }
}
