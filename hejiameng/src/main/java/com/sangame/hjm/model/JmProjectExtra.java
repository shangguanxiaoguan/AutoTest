package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmProjectExtra {
    private int id;
    private String createdAt;
    private String updatedAt;
    private String creator;
    private String modifier;
    private int projectId;
    private String introduce;
    private int deleteFlag;
}
