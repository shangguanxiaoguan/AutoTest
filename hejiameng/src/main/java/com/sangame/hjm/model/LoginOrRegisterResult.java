package com.sangame.hjm.model;

public class LoginOrRegisterResult {

    /**
     * code : 0
     * msg : 登录成功
     * data : {"createAt":null,"updateAt":null,"creator":null,"modifier":null,"deleteFlag":false,"id":7,"cngoldId":null,"nickname":"hejiameng9573c2a43c2d0","photo":null,"name":null,"gender":null,"mobile":"18305886617","area":null}
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
         * id : 7
         * cngoldId : null
         * nickname : hejiameng9573c2a43c2d0
         * photo : null
         * name : null
         * gender : null
         * mobile : 18305886617
         * area : null
         */

        private Object createAt;
        private Object updateAt;
        private Object creator;
        private Object modifier;
        private boolean deleteFlag;
        private int id;
        private Object cngoldId;
        private String nickname;
        private Object photo;
        private Object name;
        private Object gender;
        private String mobile;
        private Object area;

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

        public Object getCngoldId() {
            return cngoldId;
        }

        public void setCngoldId(Object cngoldId) {
            this.cngoldId = cngoldId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getPhoto() {
            return photo;
        }

        public void setPhoto(Object photo) {
            this.photo = photo;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getArea() {
            return area;
        }

        public void setArea(Object area) {
            this.area = area;
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
                    ", cngoldId=" + cngoldId +
                    ", nickname='" + nickname + '\'' +
                    ", photo=" + photo +
                    ", name=" + name +
                    ", gender=" + gender +
                    ", mobile='" + mobile + '\'' +
                    ", area=" + area +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginOrRegisterResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
