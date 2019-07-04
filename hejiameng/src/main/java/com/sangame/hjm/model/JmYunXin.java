package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmYunXin {
    private int id;
    private int user_id;
    private String yx_accid;
    private String yx_name;
    private String yx_token;
    private String crm_agent;
    private String access_app;
    private String created_at;
    private String updated_at;
    private String modifier;
    private String creator;
    private int delete_flag;
}
