package com.sangame.hjm.model;

public class UpdateVersionResult {

    /**
     * code : 0
     * msg : 获取版本信息成功！
     * data : {"version":"1.12.0","mversion":"1.12.0","content":"1.修复bug；\r\n2.优化体验。","review":0,"jump":"https://pz.simuhao.com/home/104","adress":"http://www.zt456.cn/updater/app-lmzt.apk","appID":null,"isHiddenIndex":null}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * version : 1.12.0
         * mversion : 1.12.0
         * content : 1.修复bug；
         2.优化体验。
         * review : 0
         * jump : https://pz.simuhao.com/home/104
         * adress : http://www.zt456.cn/updater/app-lmzt.apk
         * appID : null
         * isHiddenIndex : null
         */

        private String version;
        private String mversion;
        private String content;
        private int review;
        private String jump;
        private String adress;
        private Object appID;
        private Object isHiddenIndex;

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

        public Object getAppID() {
            return appID;
        }

        public void setAppID(Object appID) {
            this.appID = appID;
        }

        public Object getIsHiddenIndex() {
            return isHiddenIndex;
        }

        public void setIsHiddenIndex(Object isHiddenIndex) {
            this.isHiddenIndex = isHiddenIndex;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "version='" + version + '\'' +
                    ", mversion='" + mversion + '\'' +
                    ", content='" + content + '\'' +
                    ", review=" + review +
                    ", jump='" + jump + '\'' +
                    ", adress='" + adress + '\'' +
                    ", appID=" + appID +
                    ", isHiddenIndex=" + isHiddenIndex +
                    '}';
        }
    }
}
