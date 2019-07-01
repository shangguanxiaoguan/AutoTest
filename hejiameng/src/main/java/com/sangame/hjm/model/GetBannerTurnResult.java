package com.sangame.hjm.model;

import java.util.List;

public class GetBannerTurnResult {

    /**
     * code : 0
     * msg : success
     * data : [{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":7,"position":1,"title":"","url":"http://m.jmw.com.cn/activity/active_620/index.html?platform=jmw&system=","photo":"http://image1.jmw.com.cn/m_active/img/active_620_bac.png","disableFlag":2},{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":8,"position":1,"title":"","url":"http://appapi.jmw.com.cn/newProjectInfo.php?user_id=&version=2&pid=6592733","photo":"http://attachment4.jmw.com.cn/jmw_search_uploadfile/2019/0517/20190517055925575.jpg!app-w750h426","disableFlag":2},{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":9,"position":1,"title":"","url":"http://appapi.jmw.com.cn/newProjectInfo.php?user_id=&version=2&pid=6672836","photo":"http://attachment4.jmw.com.cn/jmw_search_uploadfile/2019/0624/20190624084833441.jpg!app-w750h426","disableFlag":2},{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":10,"position":1,"title":"","url":"http://appapi.jmw.com.cn/newProjectInfo.php?user_id=&version=2&pid=6773375","photo":"http://attachment4.jmw.com.cn/jmw_search_uploadfile/2019/0624/20190624084912252.jpg!app-w750h426","disableFlag":2},{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":11,"position":1,"title":"","url":"http://appapi.jmw.com.cn/newProjectInfo.php?user_id=&version=2&pid=6767628","photo":"http://attachment4.jmw.com.cn/jmw_search_uploadfile/2019/0624/20190624084946732.jpg!app-w750h426","disableFlag":2},{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":12,"position":1,"title":"","url":"http://appapi.jmw.com.cn/newProjectInfo.php?user_id=&version=2&pid=6799318","photo":"http://attachment4.jmw.com.cn/jmw_search_uploadfile/2019/0624/20190624085024465.jpg!app-w750h426","disableFlag":2}]
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
         * createAt : 2019-06-24 00:00:00
         * updateAt : 2019-06-24 00:00:00
         * creator : null
         * modifier : null
         * deleteFlag : false
         * id : 7
         * position : 1
         * title :
         * url : http://m.jmw.com.cn/activity/active_620/index.html?platform=jmw&system=
         * photo : http://image1.jmw.com.cn/m_active/img/active_620_bac.png
         * disableFlag : 2
         */

        private String createAt;
        private String updateAt;
        private Object creator;
        private Object modifier;
        private String deleteFlag;
        private int id;
        private int position;
        private String title;
        private String url;
        private String photo;
        private int disableFlag;

        public String getCreateAt() {
            return createAt;
        }

        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }

        public String getUpdateAt() {
            return updateAt;
        }

        public void setUpdateAt(String updateAt) {
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

        public String isDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(String deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getDisableFlag() {
            return disableFlag;
        }

        public void setDisableFlag(int disableFlag) {
            this.disableFlag = disableFlag;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "createAt='" + createAt + '\'' +
                    ", updateAt='" + updateAt + '\'' +
                    ", creator=" + creator +
                    ", modifier=" + modifier +
                    ", deleteFlag=" + deleteFlag +
                    ", id=" + id +
                    ", position=" + position +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    ", photo='" + photo + '\'' +
                    ", disableFlag=" + disableFlag +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GetBannerTurnResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
