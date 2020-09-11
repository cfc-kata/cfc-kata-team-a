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
     * 
     * <描述>
     * @author wuming
     * @date 2020年9月11日 下午3:31:42
     */
    public void drawingCheck() {
        
    }
    
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
        
//        if(interestRate.compareTo(new BigDecimal("36"))>0) {
//            throw new CreateContractException("利率不符合36限制");
//        }
        //校验合同
        contUtil.checkCont(customer.getIdnumber(), interestRate, maturityDate, commitment);
       
        
        
    }



    public String getContractId() {
        return contractId;
    }



    public void setContractId(String contractId) {
        this.contractId = contractId;
    }



    public Customer getCustomer() {
        return customer;
    }



    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public BigDecimal getInterestRate() {
        return interestRate;
    }



    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }



    public String getRepaymentType() {
        return repaymentType;
    }



    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType;
    }



    public String getMaturityDate() {
        return maturityDate;
    }



    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }



    public BigDecimal getCommitment() {
        return commitment;
    }



    public void setCommitment(BigDecimal commitment) {
        this.commitment = commitment;
    }



    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }
  
    
    
    
   
}
