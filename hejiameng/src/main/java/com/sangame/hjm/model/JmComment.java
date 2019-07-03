package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmComment {
    private int id;
    private String createdAt;
    private String updatedAt;
    private String creator;
    private String modifier;
    private int cngoldId;
    private int commentId;
    private String content;
    private int deleteFlag;
}
