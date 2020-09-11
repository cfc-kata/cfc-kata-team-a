/**
 * @title Customer.java
 * @author wuming
 * @date 2020年9月11日 上午11:07:10
 * @copyright 2020 中原消费金融有限公司版权所有
 */
package com.cfckata.reqeust;

/**
 * @Description <描述>
 * @author wuming
 * @date 2020年9月11日 上午11:07:10
 */
public class Customer {
    private String id;
    private String name;
    private String idnumber;
    private String mobilePhone;

    
    public Customer(String id, String name, String idnumber, String mobilePhone) {
        super();
        this.id = id;
        this.name = name;
        this.idnumber = idnumber;
        this.mobilePhone = mobilePhone;
    }
    public Customer() {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

}
