package com.strategy.model;

import lombok.Data;

@Data
public class SellCase {
    private String orderID;   //持仓ID
    private String strategyType;   //平仓类型 0限价 1市价
    private String price;   //平仓价格
}
