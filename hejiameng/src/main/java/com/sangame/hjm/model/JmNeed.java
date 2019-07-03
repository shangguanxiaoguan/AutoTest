package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmNeed {
    private int id;
    private String createdAt;
    private String updatedAt;
    private String creator;
    private String modifier;
    private int cngoldId;
    private int gender;
    private int job;
    private double investMin;
    private double investMax;
    private int interestCategory;
    private int deleteFlag;
    private String leavingMessage;
    private String name;
    private String phoneNumber;
    private int amountCode;
}
