/**
 * @title CreateContractResponse.java
 * @author wuming
 * @date 2020年9月11日 上午11:14:33
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.contract.response;

import java.math.BigDecimal;

import com.cfckata.contract.common.CustomerDto;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 上午11:14:33
 */
public class ContractInfoResponse {

    private CustomerDto customer;
    
    private BigDecimal interestRate;
    private String repaymentType;
    private String maturityDate;
    private BigDecimal commitment;
    private String status;
    private String contractId;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getContractId() {
        return contractId;
    }
    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
    
}
