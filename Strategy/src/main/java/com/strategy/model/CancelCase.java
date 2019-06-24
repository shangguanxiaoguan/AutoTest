package com.strategy.model;

import lombok.Data;

@Data
public class CancelCase {
    private String orderID;   // 买入/卖出委托ID
    private String type;   //0买入，1卖出
}
