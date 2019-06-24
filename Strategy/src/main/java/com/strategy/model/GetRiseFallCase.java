package com.strategy.model;

import lombok.Data;

@Data
public class GetRiseFallCase {
    private int page; //页码
    private int size; //每页显示数
    private int type; //-1涨幅；1跌幅
}
