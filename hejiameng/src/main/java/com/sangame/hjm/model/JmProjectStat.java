package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmProjectStat {
    private int id;
    private String created_at;
    private String updated_at;
    private String creator;
    private String modifier;
    private int project_id;
    private int apply_count;
    private int visit_count;
    private int join_store_count;
    private int direct_store_count;
    private String delete_flag;
}
