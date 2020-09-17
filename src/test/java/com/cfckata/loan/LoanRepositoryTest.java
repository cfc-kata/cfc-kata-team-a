package com.cfckata.loan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.cfckata.common.RepositoryTest;
import com.cfckata.loan.dto.LoanInfoDto;
import com.cfckata.loan.repository.LoanRepository;

public class LoanRepositoryTest extends RepositoryTest{

	@Autowired
	private LoanRepository loanRepository;

	
    @Test
    @Sql(scripts = "classpath:sql/loan-test-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void should_selctLoanId_version() {
        String contractId = "111";
        LoanInfoDto loanInfoDto = loanRepository.findById(contractId);
        String loanId = loanInfoDto.getLoanId();
        assertThat(loanId).isEqualTo("111");
    }
}
