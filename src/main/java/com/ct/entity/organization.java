package com.ct.entity;

import java.io.Serializable;

public class organization implements Serializable {
    //组织编号
    private Integer org_id;

    //公司名
    //private String org_company;

    //部门名
    private String org_department;

    //部门/终端所在地址
    private String org_address;

//    private Integer area_id;

    public Integer getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
    }

//    public String getOrg_company() {
//        return org_company;
//    }
//
//    public void setOrg_company(String org_company) {
//        this.org_company = org_company;
//    }

    public String getOrg_department() {
        return org_department;
    }

    public void setOrg_department(String org_department) {
        this.org_department = org_department;
    }

    public String getOrg_address() {
        return org_address;
    }

    public void setOrg_address(String org_address) {
        this.org_address = org_address;
    }

//    public Integer getArea_id() {
//        return area_id;
//    }
//
//    public void setArea_id(Integer area_id) {
//        this.area_id = area_id;
//    }
}
