package com.ct.entity;

import java.io.Serializable;

public class employee implements Serializable {

    //员工编号
    private Integer e_id;

    //员工编号
    private String e_name;

    //岗位名称
    private String e_title;

    //组织编号
    private Integer org_id;

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_title() {
        return e_title;
    }

    public void setE_title(String e_title) {
        this.e_title = e_title;
    }

    public Integer getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
    }
}
