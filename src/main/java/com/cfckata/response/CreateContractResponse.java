/**
 * @title CreateContractResponse.java
 * @author wuming
 * @date 2020年9月11日 上午11:14:33
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.response;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 上午11:14:33
 */
public class CreateContractResponse {

    private String contractId;

    public CreateContractResponse() {
        
    }
    public CreateContractResponse(String contractId) {
        super();
        this.contractId = contractId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
    
}
