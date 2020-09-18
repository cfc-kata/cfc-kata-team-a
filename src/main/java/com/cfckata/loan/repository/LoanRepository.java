package com.cfckata.loan.repository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cfckata.loan.Mapper.LoanInfoMapper;
import com.cfckata.loan.Mapper.RepayPlanMapper;
import com.cfckata.loan.dto.LoanInfoDto;

@Repository
public class LoanRepository {

	@Autowired
	private LoanInfoMapper loanInfoMapper;

	@Autowired
	private RepayPlanMapper repayPlanMapper;

	public void save(LoanInfoDto loanInfoDto) {
		loanInfoDto.setId("123");
		loanInfoMapper.add(loanInfoDto);

	}

	public LoanInfoDto findById(String loanId) {
		return loanInfoMapper.selectByLoanId(loanId);
	}
}
