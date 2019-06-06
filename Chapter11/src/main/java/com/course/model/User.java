package com.course.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String userPwd;
    private String userPhoto;
    private String userFlag;
    private String userTel;
    private String token;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userFlag='" + userFlag + '\'' +
                ", userTel='" + userTel + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
