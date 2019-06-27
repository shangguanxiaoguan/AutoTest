package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmEnterApply {
    private int id;
    private String created_at;
    private String updated_at;
    private String creator;
    private String modifier;
    private int cngold_id;
    private String brand;
    private String company;
    private String name;
    private int city_id;
    private int delete_flag;
    private String phone_number;
}
