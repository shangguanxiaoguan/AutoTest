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
    private JmProjectStat projectStat;
}
