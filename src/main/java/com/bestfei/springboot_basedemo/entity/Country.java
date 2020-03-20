package com.bestfei.springboot_basedemo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Country)实体类
 *
 * @author makejava
 * @since 2020-03-20 11:57:57
 */
public class Country implements Serializable {
    private static final long serialVersionUID = 158162108054025057L;
    
    private Integer id;
    
    private String countryame;
    
    private Date createdat;
    
    private Date updatedat;
    
    private String currency;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryame() {
        return countryame;
    }

    public void setCountryame(String countryame) {
        this.countryame = countryame;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}