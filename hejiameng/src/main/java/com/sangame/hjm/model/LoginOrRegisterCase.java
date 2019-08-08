package com.sangame.hjm.model;

import lombok.Data;

@Data
public class LoginOrRegisterCase {
    private String mobile;
    private String authCode;
    private String expect;

    public LoginOrRegisterCase(String mobile, String authCode, String expect) {
        super();
        this.mobile=mobile;
        this.authCode=authCode;
        this.expect=expect;
    }
}
