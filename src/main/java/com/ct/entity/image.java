package com.ct.entity;

import java.io.Serializable;

public class image implements Serializable {

    //图片编号
    private Integer img_id;

    //终端编号
    private Integer ter_id;

    //图片名
    private String img_name;

    public Integer getImg_id() {
        return img_id;
    }

    public void setImg_id(Integer img_id) {
        this.img_id = img_id;
    }

    public Integer getTer_id() {
        return ter_id;
    }

    public void setTer_id(Integer ter_id) {
        this.ter_id = ter_id;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }
}
