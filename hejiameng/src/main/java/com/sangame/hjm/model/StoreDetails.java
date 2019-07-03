package com.sangame.hjm.model;

import java.util.List;

public class StoreDetails {

    //jm_project表对应字段

    private String createAt;
    private String updateAt;
    private Object creator;
    private Object modifier;
    private int deleteFlag;
    private int id;
    private int categoryId;
    private int subCategoryId;
    private Object companyId;
    private String title;
    private String keyword;
    private String photo;
    private Object recommendFlag;
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
    private int otherCost;
    private String description;
    private int directStore;
    private int joinStore;
    private int messageNum;
    private Object companyName;
    private int registerTime;
    private Object projectExtra;
    private Object projectPhotos;
    private Object likes;
    private List<JmProjectPhotos> projectPhoto;
    private List<LikesBean> like;

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

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
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

    public Object getRecommendFlag() {
        return recommendFlag;
    }

    public void setRecommendFlag(Object recommendFlag) {
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

    public int getOtherCost() {
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

    public int getDirectStore() {
        return directStore;
    }

    public void setDirectStore(int directStore) {
        this.directStore = directStore;
    }

    public int getJoinStore() {
        return joinStore;
    }

    public void setJoinStore(int joinStore) {
        this.joinStore = joinStore;
    }

    public int getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(int messageNum) {
        this.messageNum = messageNum;
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

    public List<JmProjectPhotos> getProjectPhoto() {
        return projectPhoto;
    }

    public void setProjectPhoto(List<JmProjectPhotos> projectPhoto) {
        this.projectPhoto = projectPhoto;
    }

    public List<LikesBean> getLike() {
        return like;
    }

    public void setLike(List<LikesBean> like) {
        this.like = like;
    }

    public static class JmProjectPhotos {
            /**
             * createAt : 2019-06-25 14:21:51
             * updateAt : 2019-06-25 14:21:51
             * creator : null
             * modifier : null
             * deleteFlag : false
             * id : 103874
             * projectId : 14326
             * photo : http://attachment2.jmw.com.cn/slt/2019/02/21/s1_18711550712372.jpg
             */

            private String createAt;
            private String updateAt;
            private Object creator;
            private Object modifier;
            private String deleteFlag;
            private int id;
            private int projectId;
            private String photo;

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

            public int getProjectId() {
                return projectId;
            }

            public void setProjectId(int projectId) {
                this.projectId = projectId;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            @Override
            public String toString() {
                return "ProjectPhotosBean{" +
                        "createAt='" + createAt + '\'' +
                        ", updateAt='" + updateAt + '\'' +
                        ", creator=" + creator +
                        ", modifier=" + modifier +
                        ", deleteFlag=" + deleteFlag +
                        ", id=" + id +
                        ", projectId=" + projectId +
                        ", photo='" + photo + '\'' +
                        '}';
            }
        }

        public static class LikesBean {
            /**
             * createAt : 2019-06-25 14:21:33
             * updateAt : 2019-06-25 14:21:33
             * creator : null
             * modifier : null
             * deleteFlag : false
             * id : 14292
             * categoryId : 2
             * subCategoryId : 29
             * companyId : null
             * title : 口口绝烤鸭肠
             * keyword : 小吃 小吃加盟 烧烤 烧烤加盟 烤鸭肠
             * photo : http://attachment2.jmw.com.cn/slt/2019/01/21/s1_38101548059263.jpg
             * recommendFlag : null
             * buildDate : null
             * originAddr : 重庆
             * businessModel : null
             * product : 小吃 小吃加盟 烧烤 烧烤加盟 烤鸭肠
             * crowd : null
             * area : 全国
             * support : ["实地考察选址","总部统一装修","实操培训","选址培训","技术操作培训","标准化运营手册","区域保护支持","人员管理指导","销售指导"]
             * investMin : 2
             * investMax : 5
             * margin : null
             * facilityCost : null
             * otherCost : 2
             * description : 口口绝烤鸭肠采用优质原料搭配三十六种神秘配方，用古法手艺和现代炖煮相结合的秘制美味
             * directStore : 5
             * joinStore : 230
             * messageNum : 1670
             * companyName : null
             * registerTime : 0
             * projectExtra : null
             * projectPhotos : null
             * likes : null
             */

            private String createAt;
            private String updateAt;
            private Object creator;
            private Object modifier;
            private boolean deleteFlag;
            private int id;
            private int categoryId;
            private int subCategoryId;
            private Object companyId;
            private String title;
            private String keyword;
            private String photo;
            private Object recommendFlag;
            private Object buildDate;
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
            private int otherCost;
            private String description;
            private int directStore;
            private int joinStore;
            private int messageNum;
            private Object companyName;
            private int registerTime;
            private Object projectExtra;
            private Object projectPhotos;
            private Object likes;

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

            public Object getRecommendFlag() {
                return recommendFlag;
            }

            public void setRecommendFlag(Object recommendFlag) {
                this.recommendFlag = recommendFlag;
            }

            public Object getBuildDate() {
                return buildDate;
            }

            public void setBuildDate(Object buildDate) {
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

            public int getOtherCost() {
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

            public int getDirectStore() {
                return directStore;
            }

            public void setDirectStore(int directStore) {
                this.directStore = directStore;
            }

            public int getJoinStore() {
                return joinStore;
            }

            public void setJoinStore(int joinStore) {
                this.joinStore = joinStore;
            }

            public int getMessageNum() {
                return messageNum;
            }

            public void setMessageNum(int messageNum) {
                this.messageNum = messageNum;
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

            @Override
            public String toString() {
                return "LikesBean{" +
                        "createAt='" + createAt + '\'' +
                        ", updateAt='" + updateAt + '\'' +
                        ", creator=" + creator +
                        ", modifier=" + modifier +
                        ", deleteFlag=" + deleteFlag +
                        ", id=" + id +
                        ", categoryId=" + categoryId +
                        ", subCategoryId=" + subCategoryId +
                        ", companyId=" + companyId +
                        ", title='" + title + '\'' +
                        ", keyword='" + keyword + '\'' +
                        ", photo='" + photo + '\'' +
                        ", recommendFlag=" + recommendFlag +
                        ", buildDate=" + buildDate +
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
                        ", directStore=" + directStore +
                        ", joinStore=" + joinStore +
                        ", messageNum=" + messageNum +
                        ", companyName=" + companyName +
                        ", registerTime=" + registerTime +
                        ", projectExtra=" + projectExtra +
                        ", projectPhotos=" + projectPhotos +
                        ", likes=" + likes +
                        '}';
            }
        }

    @Override
    public String toString() {
        return "StoreDetails{" +
                "createAt='" + createAt + '\'' +
                ", updateAt='" + updateAt + '\'' +
                ", creator=" + creator +
                ", modifier=" + modifier +
                ", deleteFlag=" + deleteFlag +
                ", id=" + id +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
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
                ", directStore=" + directStore +
                ", joinStore=" + joinStore +
                ", messageNum=" + messageNum +
                ", companyName=" + companyName +
                ", registerTime=" + registerTime +
                ", projectExtra=" + projectExtra +
                ", projectPhotos=" + projectPhotos +
                ", likes=" + likes +
                ", projectPhotos=" + projectPhotos +
                ", likes=" + likes +
                '}';
    }
}
