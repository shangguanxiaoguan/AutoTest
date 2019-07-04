package com.sangame.hjm.model;

public class CreateYunXinIDResult {

    /**
     * code : 0
     * msg : 注册成功
     * data : {"createAt":null,"updateAt":null,"creator":null,"modifier":null,"deleteFlag":false,"id":2,"userId":null,"yxAccid":"yk_595635422210555904","yxName":"游客595635422210555904","yxToken":"4c639db22f0ea84e8e0c62825411bb6a","crmAgent":"3","userImg":null,"accessApp":null}
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
         * createAt : null
         * updateAt : null
         * creator : null
         * modifier : null
         * deleteFlag : false
         * id : 2
         * userId : null
         * yxAccid : yk_595635422210555904
         * yxName : 游客595635422210555904
         * yxToken : 4c639db22f0ea84e8e0c62825411bb6a
         * crmAgent : 3
         * userImg : null
         * accessApp : null
         */

        private Object createAt;
        private Object updateAt;
        private Object creator;
        private Object modifier;
        private boolean deleteFlag;
        private int id;
        private Object userId;
        private String yxAccid;
        private String yxName;
        private String yxToken;
        private String crmAgent;
        private Object userImg;
        private Object accessApp;

        public Object getCreateAt() {
            return createAt;
        }

        public void setCreateAt(Object createAt) {
            this.createAt = createAt;
        }

        public Object getUpdateAt() {
            return updateAt;
        }

        public void setUpdateAt(Object updateAt) {
            this.updateAt = updateAt;
        }

        public Object getCreator() {
            return creator;
        }

        public void setCreator(Object creator) {
            this.creator = creator;
        }

        public Object getModifier() {
            return modifier;
        }

        public void setModifier(Object modifier) {
            this.modifier = modifier;
        }

        public boolean isDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(boolean deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getYxAccid() {
            return yxAccid;
        }

        public void setYxAccid(String yxAccid) {
            this.yxAccid = yxAccid;
        }

        public String getYxName() {
            return yxName;
        }

        public void setYxName(String yxName) {
            this.yxName = yxName;
        }

        public String getYxToken() {
            return yxToken;
        }

        public void setYxToken(String yxToken) {
            this.yxToken = yxToken;
        }

        public String getCrmAgent() {
            return crmAgent;
        }

        public void setCrmAgent(String crmAgent) {
            this.crmAgent = crmAgent;
        }

        public Object getUserImg() {
            return userImg;
        }

        public void setUserImg(Object userImg) {
            this.userImg = userImg;
        }

        public Object getAccessApp() {
            return accessApp;
        }

        public void setAccessApp(Object accessApp) {
            this.accessApp = accessApp;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "createAt=" + createAt +
                    ", updateAt=" + updateAt +
                    ", creator=" + creator +
                    ", modifier=" + modifier +
                    ", deleteFlag=" + deleteFlag +
                    ", id=" + id +
                    ", userId=" + userId +
                    ", yxAccid='" + yxAccid + '\'' +
                    ", yxName='" + yxName + '\'' +
                    ", yxToken='" + yxToken + '\'' +
                    ", crmAgent='" + crmAgent + '\'' +
                    ", userImg=" + userImg +
                    ", accessApp=" + accessApp +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CreateYunXinIDResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
