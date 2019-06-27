package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmProjectExtra {
    private String created_at;
    private String updated_at;
    private String creator;
    private String modifier;
    private int project_id;
    private String introduce;
    private int delete_flag;
}
