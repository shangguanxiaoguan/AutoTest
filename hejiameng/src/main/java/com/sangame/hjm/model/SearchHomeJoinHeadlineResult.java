package com.sangame.hjm.model;

import java.util.List;

public class SearchHomeJoinHeadlineResult {

    /**
     * code : 0
     * msg : 查询加盟头条成功
     * data : [{"createAt":"2019-12-30 15:14:28","updateAt":"2019-12-30 15:14:28","creator":null,"modifier":null,"deleteFlag":false,"id":15482,"categoryId":2,"subCategoryId":25,"categoryName":null,"subCategoryName":null,"companyId":null,"title":"汉轩阁冰煮火锅","keyword":"喷泉火锅，木桶鱼，提供设备，选址，驻店，培训","photo":"http://attachment2.jmw.com.cn/slt/2019/06/13/s1_90051560408855.jpg","recommendFlag":1,"buildDate":"1970-01-18 00:00:00","originAddr":"上海","businessModel":null,"product":"喷泉火锅，木桶鱼，提供设备，选址，驻店，培训","crowd":null,"area":"","support":"[\"实地考察选址\",\"量身定制装修\",\"带店培训\",\"技术操作培训\",\"行业背景分析\",\"标准化运营手册\",\"区域保护支持\",\"人员管理指导\",\"销售指导\"]","investMin":3,"investMax":15,"margin":null,"facilityCost":null,"otherCost":4,"description":"汉轩阁冰煮三鲜火锅涮、煎、烤、煮超凡组合，四季热卖","companyName":null,"registerTime":2018,"state":1,"stateName":"上架中","attribute":1,"attributeName":"头条","projectExtra":null,"projectPhotos":null,"likes":null,"stat":null}]
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
         * createAt : 2019-12-30 15:14:28
         * updateAt : 2019-12-30 15:14:28
         * creator : null
         * modifier : null
         * deleteFlag : false
         * id : 15482
         * categoryId : 2
         * subCategoryId : 25
         * categoryName : null
         * subCategoryName : null
         * companyId : null
         * title : 汉轩阁冰煮火锅
         * keyword : 喷泉火锅，木桶鱼，提供设备，选址，驻店，培训
         * photo : http://attachment2.jmw.com.cn/slt/2019/06/13/s1_90051560408855.jpg
         * recommendFlag : 1
         * buildDate : 1970-01-18 00:00:00
         * originAddr : 上海
         * businessModel : null
         * product : 喷泉火锅，木桶鱼，提供设备，选址，驻店，培训
         * crowd : null
         * area :
         * support : ["实地考察选址","量身定制装修","带店培训","技术操作培训","行业背景分析","标准化运营手册","区域保护支持","人员管理指导","销售指导"]
         * investMin : 3
         * investMax : 15
         * margin : null
         * facilityCost : null
         * otherCost : 4
         * description : 汉轩阁冰煮三鲜火锅涮、煎、烤、煮超凡组合，四季热卖
         * companyName : null
         * registerTime : 2018
         * state : 1
         * stateName : 上架中
         * attribute : 1
         * attributeName : 头条
         * projectExtra : null
         * projectPhotos : null
         * likes : null
         * stat : null
         */

        private String createAt;
        private String updateAt;
        private Object creator;
        private Object modifier;
        private boolean deleteFlag;
        private int id;
        private int categoryId;
        private int subCategoryId;
        private Object categoryName;
        private Object subCategoryName;
        private Object companyId;
        private String title;
        private String keyword;
        private String photo;
        private Integer recommendFlag;
        private String buildDate;
        private String originAddr;
        private Object businessModel;
        private String product;
        private Object crowd;
        private String area;
        private String support;
        private int investMin;
        private int investMax;
        private Object margin;
        private Object facilityCost;
        private Integer otherCost;
        private String description;
        private Object companyName;
        private int registerTime;
        private Integer state;
        private String stateName;
        private int attribute;
        private String attributeName;
        private Object projectExtra;
        private Object projectPhotos;
        private Object likes;
        private Object stat;

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

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getSubCategoryId() {
            return subCategoryId;
        }

        public void setSubCategoryId(int subCategoryId) {
            this.subCategoryId = subCategoryId;
        }

        public Object getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(Object categoryName) {
            this.categoryName = categoryName;
        }

        public Object getSubCategoryName() {
            return subCategoryName;
        }

        public void setSubCategoryName(Object subCategoryName) {
            this.subCategoryName = subCategoryName;
        }

        public Object getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Object companyId) {
            this.companyId = companyId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public Integer getRecommendFlag() {
            return recommendFlag;
        }

        public void setRecommendFlag(int recommendFlag) {
            this.recommendFlag = recommendFlag;
        }

        public String getBuildDate() {
            return buildDate;
        }

        public void setBuildDate(String buildDate) {
            this.buildDate = buildDate;
        }

        public String getOriginAddr() {
            return originAddr;
        }

        public void setOriginAddr(String originAddr) {
            this.originAddr = originAddr;
        }

        public Object getBusinessModel() {
            return businessModel;
        }

        public void setBusinessModel(Object businessModel) {
            this.businessModel = businessModel;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public Object getCrowd() {
            return crowd;
        }

        public void setCrowd(Object crowd) {
            this.crowd = crowd;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getSupport() {
            return support;
        }

        public void setSupport(String support) {
            this.support = support;
        }

        public int getInvestMin() {
            return investMin;
        }

        public void setInvestMin(int investMin) {
            this.investMin = investMin;
        }

        public int getInvestMax() {
            return investMax;
        }

        public void setInvestMax(int investMax) {
            this.investMax = investMax;
        }

        public Object getMargin() {
            return margin;
        }

        public void setMargin(Object margin) {
            this.margin = margin;
        }

        public Object getFacilityCost() {
            return facilityCost;
        }

        public void setFacilityCost(Object facilityCost) {
            this.facilityCost = facilityCost;
        }

        public Integer getOtherCost() {
            return otherCost;
        }

        public void setOtherCost(int otherCost) {
            this.otherCost = otherCost;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getCompanyName() {
            return companyName;
        }

        public void setCompanyName(Object companyName) {
            this.companyName = companyName;
        }

        public int getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(int registerTime) {
            this.registerTime = registerTime;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }

        public int getAttribute() {
            return attribute;
        }

        public void setAttribute(int attribute) {
            this.attribute = attribute;
        }

        public String getAttributeName() {
            return attributeName;
        }

        public void setAttributeName(String attributeName) {
            this.attributeName = attributeName;
        }

        public Object getProjectExtra() {
            return projectExtra;
        }

        public void setProjectExtra(Object projectExtra) {
            this.projectExtra = projectExtra;
        }

        public Object getProjectPhotos() {
            return projectPhotos;
        }

        public void setProjectPhotos(Object projectPhotos) {
            this.projectPhotos = projectPhotos;
        }

        public Object getLikes() {
            return likes;
        }

        public void setLikes(Object likes) {
            this.likes = likes;
        }

        public Object getStat() {
            return stat;
        }

        public void setStat(Object stat) {
            this.stat = stat;
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
                    ", subCategoryId=" + subCategoryId +
                    ", categoryName=" + categoryName +
                    ", subCategoryName=" + subCategoryName +
                    ", companyId=" + companyId +
                    ", title='" + title + '\'' +
                    ", keyword='" + keyword + '\'' +
                    ", photo='" + photo + '\'' +
                    ", recommendFlag=" + recommendFlag +
                    ", buildDate='" + buildDate + '\'' +
                    ", originAddr='" + originAddr + '\'' +
                    ", businessModel=" + businessModel +
                    ", product='" + product + '\'' +
                    ", crowd=" + crowd +
                    ", area='" + area + '\'' +
                    ", support='" + support + '\'' +
                    ", investMin=" + investMin +
                    ", investMax=" + investMax +
                    ", margin=" + margin +
                    ", facilityCost=" + facilityCost +
                    ", otherCost=" + otherCost +
                    ", description='" + description + '\'' +
                    ", companyName=" + companyName +
                    ", registerTime=" + registerTime +
                    ", state=" + state +
                    ", stateName='" + stateName + '\'' +
                    ", attribute=" + attribute +
                    ", attributeName='" + attributeName + '\'' +
                    ", projectExtra=" + projectExtra +
                    ", projectPhotos=" + projectPhotos +
                    ", likes=" + likes +
                    ", stat=" + stat +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SearchHomeJoinHeadlineResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
