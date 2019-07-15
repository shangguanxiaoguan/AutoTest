package com.sangame.hjm.model;

public class SendMobileResult {

    /**
     * code : 0
     * msg : 短信验证码发送成功，请查收
     * data : null
     */

    private int code;
    private String msg;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SendMobileResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
