package com.strategy.model;

import lombok.Data;

@Data
public class GetHistoryListCase {
    private int page;     //页码（从1开始）
    private int pageSize;  //每页展示数
    private int isDeal;  //1:所有；2:只有完成的
}
