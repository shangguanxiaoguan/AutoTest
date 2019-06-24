package com.strategy.model;

import lombok.Data;

@Data
public class LoginCase {
    private int id;
    private String mobile;
    private String pwd;
    private String expected;
}
