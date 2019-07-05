package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmBanner {
    private int id;
    private String created_at;
    private String updated_at;
    private String creator;
    private String modifier;
    private int position;
    private String title;
    private String url;
    private String photo;
    private int disable_flag;  //禁用标志：1禁用 2启用
    private int delete_flag;
    private int product_id;
    private Integer type; //类型 1 跳转url 2跳转产品详情
}
