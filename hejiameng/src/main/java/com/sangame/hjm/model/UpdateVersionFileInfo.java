package com.sangame.hjm.model;

import lombok.Data;

@Data
public class UpdateVersionFileInfo {

    /**
     * version : 1.12.1
     * mversion : 1.12.1
     * content : 1.优化用户体验；
     2.修改已知bug。
     * review : 0
     * jump : https://pz.simuhao.com/home/104
     * adress : https://itunes.apple.com/cn/app/id1376552203
     * appID : 1376552203
     * isHiddenIndex : 0
     */

    private String version;
    private String mversion;
    private String content;
    private int review;
    private String jump;
    private String adress;
    private String appID;
    private String isHiddenIndex;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMversion() {
        return mversion;
    }

    public void setMversion(String mversion) {
        this.mversion = mversion;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public String getJump() {
        return jump;
    }

    public void setJump(String jump) {
        this.jump = jump;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getIsHiddenIndex() {
        return isHiddenIndex;
    }

    public void setIsHiddenIndex(String isHiddenIndex) {
        this.isHiddenIndex = isHiddenIndex;
    }
}
