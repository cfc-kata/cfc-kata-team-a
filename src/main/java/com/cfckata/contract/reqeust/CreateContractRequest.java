/**
 * @title CreateContract.java
 * @author wuming
 * @date 2020年9月11日 上午11:05:09
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.contract.reqeust;

import java.math.BigDecimal;

import com.cfckata.contract.common.CustomerDto;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 上午11:05:09
 */
public class CreateContractRequest {
    
    
    private CustomerDto customer;
    private BigDecimal interestRate;
    private String repaymentType;
    private String maturityDate;
    private BigDecimal commitment;
    
    public CreateContractRequest() {};
    public CreateContractRequest(CustomerDto customer, BigDecimal interestRate, String repaymentType, String maturityDate,
        BigDecimal commitment) {
        super();
        this.customer = customer;
        this.interestRate = interestRate;
        this.repaymentType = repaymentType;
        this.maturityDate = maturityDate;
        this.commitment = commitment;
    }
    public CustomerDto getCustomer() {
        return customer;
    }
    public void setCustomer(CustomerDto customer) {
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
    
    
}
