/**
 * @title CreateContractException.java
 * @author wuming
 * @date 2020年9月11日 下午2:46:45
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.contract.domain;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 下午2:46:45
 */
public class CreateContractException extends RuntimeException{

    public CreateContractException(String message) {
        super(message);
    }
}
