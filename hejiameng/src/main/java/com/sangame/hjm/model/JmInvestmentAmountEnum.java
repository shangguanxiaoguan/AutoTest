package com.sangame.hjm.model;

import lombok.Getter;

@Getter
public enum JmInvestmentAmountEnum {
    ONE_FOLLOWING(0, "0-1", "1万以下",0,1),
    ONE_THREE(1, "1-3", "1-3万",1,3),
    THREE_FIVE(2, "3-5", "3-5万",3,5),
    FIVE_TEN(3, "5-10", "5-10万",5,10),
    TEN_TWENTY(4, "10-20", "10-20万",10,20),
    TWENTY_FIFTY(5, "20-50", "20-50万",20,50),
    FIFTY_ONE_HUNDRED(6, "50-100", "50-100万",50,100),
    ONE_HUNDRED_ABOVE(7, "100-0", "100以上",100,99999),
    OTHER(8, "0-0", "其他",0,0);

    private int code;
    private String value;
    private String msg;
    private int min;
    private int max;

    JmInvestmentAmountEnum(int code, String value, String msg,int min,int max) {
        this.code = code;
        this.value = value;
        this.msg = msg;
        this.min = min;
        this.max = max;
    }

    public static JmInvestmentAmountEnum getByCode(int code) {
        JmInvestmentAmountEnum[] values = values();
        for (JmInvestmentAmountEnum codeEnum : values) {
            if (codeEnum.getCode() == code) {
                return codeEnum;
            }
        }
        return ONE_FOLLOWING;
    }
}
