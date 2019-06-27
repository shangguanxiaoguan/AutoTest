package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmComment {
    private int id;
    private String created_at;
    private String updated_at;
    private String creator;
    private String modifier;
    private int cngold_id;
    private int comment_id;
    private String content;
    private int delete_flag;
}
