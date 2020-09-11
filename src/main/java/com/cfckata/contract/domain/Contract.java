/**
 * @title Contract.java
 * @author wuming
 * @date 2020年9月11日 下午2:22:11
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.contract.domain;

import java.math.BigDecimal;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 下午2:22:11
 */
public class Contract {
    
    private String contractId;
    private Customer customer;
    
    private BigDecimal interestRate;
    private String repaymentType;
    private String maturityDate;
    private BigDecimal commitment;
    private String status;
    
      
    
    /**
     * 新合同检查
     * 有一下规则：年龄应该达到18岁，年利率不得超过36%，期限是不得超过2年
     * <描述>
     * @author wuming
     * @date 2020年9月11日 下午2:34:25
     */
    public void validateNewContract() {
        //年龄检查
        int age = this.customer.getAge();
        if(age <18 || age>70 ) {
            throw new CreateContractException("年龄不符合18-70限制");
        }
        
        //利率检查
        if(interestRate.compareTo(new BigDecimal("36"))>0) {
            throw new CreateContractException("利率不符合36限制");
        }
        
        //日期检查
        
        
    }
  
    
    
    
   
}
