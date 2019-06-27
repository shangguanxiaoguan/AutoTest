package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmCategory {
    private String createAt;
    private String updateAt;
    private Object creator;
    private Object modifier;
    private boolean deleteFlag;
    private int id;
    private String spell;
    private String title;
    private Object icon;
}
