package com.cfckata.dz;


import com.cfckata.common.ApiTest;
import com.cfckata.dz.request.DzRequest;
import com.cfckata.dz.response.DzResponse;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class TkContollerTest extends ApiTest {

    
    @Test
   // @Sql(scripts = "classpath:sql/order-test-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    //@Sql(scripts = "classpath:sql/order-test-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void should_support_create_dz() {
        //Given
        String customerId = "TEST_USER_ID";

        DzRequest dzReq=new DzRequest();


        //When
        ResponseEntity<DzResponse> responseEntity = this.restTemplate.postForEntity(baseUrl + "/loan/creater", dzReq, DzResponse.class);

        //Then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        DzResponse body = responseEntity.getBody();
        System.out.println(body.getLoanId());
        assertThat(body.getLoanId()).isNotNull();

    }

    

}
