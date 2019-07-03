package com.sangame.hjm.model;

import java.util.List;

public class SearchCategoryResult {

    /**
     * code : 0
     * msg : success
     * data : [{"createAt":"2019-06-24 15:05:52","updateAt":"2019-06-24 15:05:52","creator":null,"modifier":null,"deleteFlag":false,"id":1,"spell":"fuzhuang","title":"服装","icon":null},{"createAt":"2019-06-24 15:05:50","updateAt":"2019-06-24 15:05:50","creator":null,"modifier":null,"deleteFlag":false,"id":2,"spell":"canyin","title":"餐饮","icon":"http://appapi.jmw.com.cn/images/v1/icon_canyin_126_126.png"},{"createAt":"2019-06-24 15:05:51","updateAt":"2019-06-24 15:05:51","creator":null,"modifier":null,"deleteFlag":false,"id":3,"spell":"meirong","title":"美容","icon":null},{"createAt":"2019-06-24 15:05:52","updateAt":"2019-06-24 15:05:52","creator":null,"modifier":null,"deleteFlag":false,"id":4,"spell":"ganxi","title":"干洗","icon":null},{"createAt":"2019-06-24 15:06:11","updateAt":"2019-06-24 15:06:11","creator":null,"modifier":null,"deleteFlag":false,"id":5,"spell":"jingpin","title":"精品","icon":null},{"createAt":"2019-06-24 15:06:09","updateAt":"2019-06-24 15:06:09","creator":null,"modifier":null,"deleteFlag":false,"id":7,"spell":"shipin","title":"饰品","icon":null},{"createAt":"2019-06-24 15:05:50","updateAt":"2019-06-24 15:05:50","creator":null,"modifier":null,"deleteFlag":false,"id":13,"spell":"youer","title":"幼儿","icon":null},{"createAt":"2019-06-24 15:06:09","updateAt":"2019-06-24 15:06:09","creator":null,"modifier":null,"deleteFlag":false,"id":15,"spell":"lingshou","title":"零售","icon":null},{"createAt":"2019-06-24 15:06:08","updateAt":"2019-06-24 15:06:08","creator":null,"modifier":null,"deleteFlag":false,"id":16,"spell":"jiaju","title":"家居","icon":null},{"createAt":"2019-06-24 15:06:09","updateAt":"2019-06-24 15:06:09","creator":null,"modifier":null,"deleteFlag":false,"id":17,"spell":"huanbao","title":"环保","icon":null},{"createAt":"2019-06-24 15:06:10","updateAt":"2019-06-24 15:06:10","creator":null,"modifier":null,"deleteFlag":false,"id":19,"spell":"wujin","title":"五金","icon":null},{"createAt":"2019-06-24 15:06:08","updateAt":"2019-06-24 15:06:08","creator":null,"modifier":null,"deleteFlag":false,"id":21,"spell":"zhubao","title":"珠宝","icon":null},{"createAt":"2019-06-24 15:06:08","updateAt":"2019-06-24 15:06:08","creator":null,"modifier":null,"deleteFlag":false,"id":22,"spell":"jiafang","title":"家纺","icon":null},{"createAt":"2019-06-24 15:05:51","updateAt":"2019-06-24 15:05:51","creator":null,"modifier":null,"deleteFlag":false,"id":23,"spell":"qiche","title":"汽车","icon":null},{"createAt":"2019-06-24 15:06:08","updateAt":"2019-06-24 15:06:08","creator":null,"modifier":null,"deleteFlag":false,"id":24,"spell":"jiancai","title":"建材","icon":null},{"createAt":"2019-06-24 15:05:51","updateAt":"2019-06-24 15:05:51","creator":null,"modifier":null,"deleteFlag":false,"id":147,"spell":"jiudian","title":"酒店","icon":null},{"createAt":"2019-06-24 15:06:09","updateAt":"2019-06-24 15:06:09","creator":null,"modifier":null,"deleteFlag":false,"id":196,"spell":"jiushui","title":"酒水","icon":null},{"createAt":"2019-06-24 15:06:08","updateAt":"2019-06-24 15:06:08","creator":null,"modifier":null,"deleteFlag":false,"id":223,"spell":"chaoshi","title":"超市","icon":null},{"createAt":"2019-06-24 15:06:10","updateAt":"2019-06-24 15:06:10","creator":null,"modifier":null,"deleteFlag":false,"id":230,"spell":"fuwu","title":"服务","icon":null},{"createAt":"2019-06-24 15:06:11","updateAt":"2019-06-24 15:06:11","creator":null,"modifier":null,"deleteFlag":false,"id":231,"spell":"xinhangye","title":"新行业","icon":null},{"createAt":"2019-06-24 15:06:10","updateAt":"2019-06-24 15:06:10","creator":null,"modifier":null,"deleteFlag":false,"id":232,"spell":"yule","title":"娱乐","icon":null},{"createAt":"2019-06-24 15:06:11","updateAt":"2019-06-24 15:06:11","creator":null,"modifier":null,"deleteFlag":false,"id":233,"spell":"jianshen","title":"健身","icon":null},{"createAt":"2019-06-24 15:06:09","updateAt":"2019-06-24 15:06:09","creator":null,"modifier":null,"deleteFlag":false,"id":234,"spell":"shipin","title":"食品","icon":null},{"createAt":"2019-06-24 15:06:10","updateAt":"2019-06-24 15:06:10","creator":null,"modifier":null,"deleteFlag":false,"id":235,"spell":"jiadian","title":"家电","icon":null},{"createAt":"2019-06-24 15:06:10","updateAt":"2019-06-24 15:06:10","creator":null,"modifier":null,"deleteFlag":false,"id":236,"spell":"shuma","title":"数码","icon":null},{"createAt":"2019-06-24 15:06:11","updateAt":"2019-06-24 15:06:11","creator":null,"modifier":null,"deleteFlag":false,"id":245,"spell":"chongwudian","title":"宠物店","icon":null},{"createAt":"2019-06-24 15:05:51","updateAt":"2019-06-24 15:05:51","creator":null,"modifier":null,"deleteFlag":false,"id":372,"spell":"shilibaojian","title":"视力保健","icon":null}]
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
         * createAt : 2019-06-24 15:05:52
         * updateAt : 2019-06-24 15:05:52
         * creator : null
         * modifier : null
         * deleteFlag : false
         * id : 1
         * spell : fuzhuang
         * title : 服装
         * icon : null
         */

        private String createAt;
        private String updateAt;
        private Object creator;
        private Object modifier;
        private boolean deleteFlag;
        private int id;
        private String spell;
        private String title;
        private Object icon;

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

        public String getSpell() {
            return spell;
        }

        public void setSpell(String spell) {
            this.spell = spell;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
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
                    ", spell='" + spell + '\'' +
                    ", title='" + title + '\'' +
                    ", icon=" + icon +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SearchCategoryResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
