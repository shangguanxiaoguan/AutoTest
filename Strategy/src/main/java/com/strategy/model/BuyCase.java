package com.strategy.model;

import lombok.Data;

@Data
public class BuyCase {
//    private int id;
    private String stockCode;  //股票代码
    private String price;    //委托价格
    private String count;    //委托数量
    private String strategyType;  //0 限价委托 1 市价
    private String level;    //杠杆倍数
    private String voucherId;  //代金券ID
    private String voucherRecordId;  //代金券和用户绑定的记录ID
}
