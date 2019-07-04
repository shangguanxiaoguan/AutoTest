package com.sangame.hjm.model;

import lombok.Data;

@Data
public class BusinessHotSearch {
    private String createAt;
    private String updateAt;
    private Object creator;
    private Object modifier;
    private int deleteFlag;
    private int id;
    private int categoryId;
    private int subCategoryId;
    private Object companyId;
    private String title;
    private String keyword;
    private String photo;
    private Integer recommendFlag;
    private String buildDate;
    private String originAddr;
    private Object businessModel;
    private String product;
    private Object crowd;
    private String area;
    private String support;
    private int investMin;
    private int investMax;
    private Object margin;
    private Object facilityCost;
    private Integer otherCost;
    private String description;
    private int directStore;
    private int joinStore;
    private int messageNum;
    private Object companyName;
    private Integer registerTime;
    private Object projectExtra;
    private Object projectPhotos;
    private Object likes;
    private int attribute;
    private Integer state;
    private String core;
    private Integer investCode;
    private double investValue;
    private int regionId;
//    private JmProjectStat projectStat;
//private int id;
//    private String created_at;
//    private String updated_at;
//    private String creator;
//    private String modifier;
    private int project_id;
    private Integer apply_count;
    private int visit_count;
    private int join_store_count;
    private int direct_store_count;
    private String delete_flag;
}
