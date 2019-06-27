package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmProjectPhoto {
    private String created_at;
    private String updated_at;
    private String creator;
    private String modifier;
    private int project_id;
    private String photo;
    private int delete_flag;
}
