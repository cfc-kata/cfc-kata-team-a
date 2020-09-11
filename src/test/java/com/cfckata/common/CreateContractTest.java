/**
 * @title CreateContractTest.java
 * @author wuming
 * @date 2020年9月11日 上午11:22:43
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.cfckata.reqeust.CreateContractRequest;
import com.cfckata.reqeust.Customer;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 上午11:22:43
 */
public class CreateContractTest extends SpringServiceTest{

    
    @Before
    public void setUp() throws Exception {
        /*orderRepository = mock(OrderRepository.class);
        payProxy = mock(PayProxy.class);
        orderId = "orderid";
        totalPrice = new BigDecimal("1000");
        testOrder = createNormalTestOrder(orderId, totalPrice);

        service = new OrderService(orderRepository, null, payProxy);

        when(orderRepository.findById(same(orderId))).thenReturn(AggregateFactory.createAggregate(testOrder));
        doNothing().when(orderRepository).save(any());
        */
    }

    @Test
    public void should_create_success_contract() {
        
        String id = "BJ001";
        String name = "张三";
        String idnumber =  "411327198609043116";
        String mobilePhone="18537118170";
        Customer customer = new Customer(id, name, idnumber, mobilePhone);
        //Given
        
        BigDecimal interestRate = new BigDecimal("9.9");
        String repaymentType = "DEBX";
        String maturityDate = "2020-09-10";
        BigDecimal commitment = new BigDecimal("9000");

       CreateContractRequest request = new CreateContractRequest(customer, interestRate, repaymentType, maturityDate, commitment);
       
       
        //Then
        assertThat(request.getInterestRate()).isLessThan(new BigDecimal("36"));
      
       
    }
    
}
