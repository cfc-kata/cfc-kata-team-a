package com.cfckata.loan.Mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.cfckata.loan.dto.LoanInfoDto;

@Mapper
@Repository
public interface LoanInfoMapper {

	int add(LoanInfoDto loanInfoDto);
	
	LoanInfoDto selectByLoanId(String loanId);
}
