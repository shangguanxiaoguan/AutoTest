package com.strategy.model;

import lombok.Data;

@Data
public class GetEntrustDetailCase {
    private String strategyType; //买入0，卖出1，历史已平仓2,持仓3
    private String strategyId; //买入委托ID，或卖出委托ID，或历史ID,或持仓ID
}
