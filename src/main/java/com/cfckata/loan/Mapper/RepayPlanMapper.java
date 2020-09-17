package com.cfckata.loan.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.cfckata.loan.dto.RepaymentPlans;

@Mapper
@Repository
public interface RepayPlanMapper {

	int addBatch(List<RepaymentPlans> recordList);
	
	List<RepaymentPlans> selectByLoanId(String loanId);
}
