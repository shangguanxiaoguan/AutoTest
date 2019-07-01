package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmBanner {
    private int id;
    private String created_at;
    private String updated_at;
    private String creator;
    private String modifier;
    private int position;
    private String title;
    private String url;
    private String photo;
    private int disable_flag;
    private int delete_flag;
}
