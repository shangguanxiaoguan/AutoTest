package com.sangame.hjm.model;

import lombok.Data;

@Data
public class SysConfig {
    private int id;
    private String config_key;
    private String config_value;
    private String show_name;
    private String remark;
    private int  delete_flag;

}
