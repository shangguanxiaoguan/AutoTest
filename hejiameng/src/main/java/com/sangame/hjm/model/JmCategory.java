package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmCategory {
    private int id;
    private String createAt;
    private String updateAt;
    private Object creator;
    private Object modifier;
    private String title;
    private String spell;
    private Object icon;
    private boolean deleteFlag;
}
