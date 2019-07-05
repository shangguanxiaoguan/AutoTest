package com.sangame.hjm.model;

import java.util.List;

public class SearchInvestmentResult {

    /**
     * code : 0
     * msg : success
     * data : [{"code":0,"value":"1万以下"},{"code":1,"value":"1-3万"},{"code":2,"value":"3-5万"},{"code":3,"value":"5-10万"},{"code":4,"value":"10-20万"},{"code":5,"value":"20-50万"},{"code":6,"value":"50-100万"},{"code":7,"value":"100以上"},{"code":8,"value":"其他"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * code : 0
         * value : 1万以下
         */

        private int code;
        private String value;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "code=" + code +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SearchInvestmentResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
