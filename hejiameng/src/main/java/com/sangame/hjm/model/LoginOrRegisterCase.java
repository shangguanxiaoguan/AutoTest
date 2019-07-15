package com.sangame.hjm.model;

import lombok.Data;

@Data
public class LoginOrRegisterCase {
    private String mobile;
    private String authCode;
    private String expect;
}
