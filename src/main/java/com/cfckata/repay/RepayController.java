package com.cfckata.repay;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cfckata.response.RepayByIdResponse;
@RestController
@RequestMapping("/repay")
public class RepayController {

	@GetMapping("/repayById/{repaymentPlanId}")
    @ResponseStatus(HttpStatus.CREATED)
    public RepayByIdResponse repayByPlanId(@PathVariable String repaymentPlanId) {
		if (repaymentPlanId == null ) {
            throw new IllegalArgumentException("id should not empty");
        }
		
		
		return null;
    }
}
