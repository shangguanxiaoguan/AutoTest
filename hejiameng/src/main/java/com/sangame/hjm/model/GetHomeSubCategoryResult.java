package com.sangame.hjm.model;

import java.util.List;

public class GetHomeSubCategoryResult {

    /**
     * code : 0
     * msg : success
     * data : [{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":28,"categoryId":2,"title":"快餐","spell":"kuaican","icon":"http://appapi.jmw.com.cn/images/v1/icon_kuaican_126_126.png","hotFlag":null,"recommendFlag":null,"indexFlag":1},{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":48,"categoryId":11,"title":"英语","spell":"yingyu","icon":"http://appapi.jmw.com.cn/images/v1/icon_yingyu_126_126.png","hotFlag":null,"recommendFlag":null,"indexFlag":1},{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":57,"categoryId":13,"title":"早教","spell":"zaojiao","icon":"http://appapi.jmw.com.cn/images/v1/icon_zaojiao_126_126.png","hotFlag":null,"recommendFlag":null,"indexFlag":1},{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":172,"categoryId":2,"title":"精品餐饮","spell":"jingpin canyin","icon":"http://appapi.jmw.com.cn/images/v1/icon_canyin_126_126.png","hotFlag":null,"recommendFlag":null,"indexFlag":1},{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":293,"categoryId":147,"title":"快捷酒店","spell":"kuaijie jiudian","icon":"http://appapi.jmw.com.cn/images/v1/icon_jiudian_126_126.png","hotFlag":null,"recommendFlag":null,"indexFlag":1},{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":368,"categoryId":11,"title":"机器人教育","spell":"jiqirenjiaoyu","icon":"http://appapi.jmw.com.cn/images/v1/icon_jiqiren_126_126.png","hotFlag":null,"recommendFlag":null,"indexFlag":1},{"createAt":"2019-06-24 00:00:00","updateAt":"2019-06-24 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":383,"categoryId":11,"title":"在线教育","spell":"zaixianjiaoyu","icon":"http://appapi.jmw.com.cn/images/v1/icon_jiaoyu_126_126.png","hotFlag":null,"recommendFlag":null,"indexFlag":1}]
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
         * id : 28
         * categoryId : 2
         * title : 快餐
         * spell : kuaican
         * icon : http://appapi.jmw.com.cn/images/v1/icon_kuaican_126_126.png
         * hotFlag : null
         * recommendFlag : null
         * indexFlag : 1
         */

        private String createAt;
        private String updateAt;
        private Object creator;
        private Object modifier;
        private String deleteFlag;
        private int id;
        private int categoryId;
        private String title;
        private String spell;
        private String icon;
        private Object hotFlag;
        private Object recommendFlag;
        private int indexFlag;

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

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSpell() {
            return spell;
        }

        public void setSpell(String spell) {
            this.spell = spell;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getHotFlag() {
            return hotFlag;
        }

        public void setHotFlag(Object hotFlag) {
            this.hotFlag = hotFlag;
        }

        public Object getRecommendFlag() {
            return recommendFlag;
        }

        public void setRecommendFlag(Object recommendFlag) {
            this.recommendFlag = recommendFlag;
        }

        public int getIndexFlag() {
            return indexFlag;
        }

        public void setIndexFlag(int indexFlag) {
            this.indexFlag = indexFlag;
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
                    ", categoryId=" + categoryId +
                    ", title='" + title + '\'' +
                    ", spell='" + spell + '\'' +
                    ", icon='" + icon + '\'' +
                    ", hotFlag=" + hotFlag +
                    ", recommendFlag=" + recommendFlag +
                    ", indexFlag=" + indexFlag +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GetHomeSubCategoryResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
