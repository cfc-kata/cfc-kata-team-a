package com.cfckata.dz;

import com.cfckata.dz.request.DzRequest;
import com.cfckata.dz.response.DzResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class DzLoanController {

   

    @PostMapping("/creater")
    @ResponseStatus(HttpStatus.CREATED)
    public DzResponse createOrder(@RequestBody DzRequest request) {
        //SalesOrder salesOrder = orderService.createOrder(request);
    	DzResponse DzResponse=new DzResponse();
    	DzResponse.setLoanId("1232455");
        return DzResponse;
    }
}
