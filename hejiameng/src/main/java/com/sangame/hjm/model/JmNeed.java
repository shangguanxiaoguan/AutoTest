package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmNeed {
    private int id;
    private String created_at;
    private String updated_at;
    private String creator;
    private String modifier;
    private int cngold_id;
    private int gender;
    private int job;
    private double invest_min;
    private double invest_max;
    private int interest_category;
    private int delete_flag;
    private String leaving_message;
    private String name;
    private String phone_number;
    private int amount_code;
}
