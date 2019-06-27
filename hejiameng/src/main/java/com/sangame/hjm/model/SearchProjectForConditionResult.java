package com.sangame.hjm.model;

import java.util.List;

public class SearchProjectForConditionResult {

    /**
     * flag : true
     * code : 0
     * msg : page search success
     * pageSize : 10
     * pageNum : 0
     * total : 3
     * totalPage : 1
     * data : [{"createAt":"2019-06-25 00:00:00","updateAt":"2019-06-25 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":14308,"categoryId":2,"subCategoryId":25,"companyId":null,"title":"馋火炉鱼","keyword":"烤鱼 炭火烤鱼 烤鱼加盟 加盟 烤鱼店加盟","photo":"http://attachment2.jmw.com.cn/slt/2018/08/27/s1_36451535348569.jpg","recommendFlag":null,"buildDate":null,"originAddr":"北京","businessModel":null,"product":"烤鱼 炭火烤鱼 烤鱼加盟 加盟 烤鱼店加盟","crowd":null,"area":"全国","support":"[\"远程协助选址\",\"总部统一装修\",\"总部短期培训\",\"技术操作培训\",\"行业背景分析\",\"区域保护支持\",\"开业指导\",\"人员管理指导\",\"销售指导\"]","investMin":13,"investMax":20,"margin":null,"facilityCost":null,"otherCost":6,"description":"&ldquo;馋火炉鱼&rdquo;聚团队、教技术、通物流、创环境，以解众人之&ldquo;馋&rd","directStore":3,"joinStore":300,"messageNum":925,"companyName":null,"registerTime":0,"projectExtra":null,"projectPhotos":null,"likes":null},{"createAt":"2019-06-25 00:00:00","updateAt":"2019-06-25 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":14328,"categoryId":2,"subCategoryId":25,"companyId":null,"title":"杨翔豆皮涮牛肚","keyword":"火锅,牛肚，牛肚店，牛肚加盟，杨翔豆皮涮牛肚加盟，杨翔豆皮涮牛肚加盟店 精品餐饮","photo":"http://attachment2.jmw.com.cn/slt/2018/11/13/s1_69991542082273.jpg","recommendFlag":null,"buildDate":"1970-01-15 00:00:00","originAddr":"陕西","businessModel":null,"product":"火锅,牛肚，牛肚店，牛肚加盟，杨翔豆皮涮牛肚加盟，杨翔豆皮涮牛肚加盟店 精品餐饮","crowd":null,"area":"全国","support":"[\"实地考察选址\",\"量身定制装修\",\"带店培训\",\"选址培训\",\"技术操作培训\",\"标准化运营手册\",\"区域保护支持\",\"人员管理指导\",\"销售指导\"]","investMin":20,"investMax":60,"margin":null,"facilityCost":null,"otherCost":20,"description":"杨翔豆皮涮牛肚诚邀加盟","directStore":11,"joinStore":138,"messageNum":661,"companyName":null,"registerTime":2010,"projectExtra":null,"projectPhotos":null,"likes":null},{"createAt":"2019-06-25 00:00:00","updateAt":"2019-06-25 00:00:00","creator":null,"modifier":null,"deleteFlag":false,"id":14336,"categoryId":2,"subCategoryId":25,"companyId":null,"title":"豆捞坊","keyword":"火锅,火锅店,火锅加盟 火锅","photo":"http://attachment4.jmw.com.cn/comp_uploadfile/slt/2018/11/20/s1_33371542697854.jpg","recommendFlag":null,"buildDate":"1970-01-16 00:00:00","originAddr":"江苏","businessModel":null,"product":"火锅,火锅店,火锅加盟 火锅","crowd":null,"area":"全国","support":"[\"实地考察选址\",\"量身定制装修\",\"带店培训\",\"选址培训\",\"技术操作培训\",\"标准化运营手册\",\"区域保护支持\",\"人员管理指导\",\"销售指导\"]","investMin":6,"investMax":20,"margin":null,"facilityCost":null,"otherCost":5,"description":"潜心研究小火锅品质，追寻健康美味的饮食文化","directStore":6,"joinStore":5,"messageNum":263,"companyName":null,"registerTime":2011,"projectExtra":null,"projectPhotos":null,"likes":null}]
     */

    private boolean flag;
    private int code;
    private String msg;
    private int pageSize;
    private int pageNum;
    private int total;
    private int totalPage;
    private List<DataBean> data;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createAt : 2019-06-25 00:00:00
         * updateAt : 2019-06-25 00:00:00
         * creator : null
         * modifier : null
         * deleteFlag : false
         * id : 14308
         * categoryId : 2
         * subCategoryId : 25
         * companyId : null
         * title : 馋火炉鱼
         * keyword : 烤鱼 炭火烤鱼 烤鱼加盟 加盟 烤鱼店加盟
         * photo : http://attachment2.jmw.com.cn/slt/2018/08/27/s1_36451535348569.jpg
         * recommendFlag : null
         * buildDate : null
         * originAddr : 北京
         * businessModel : null
         * product : 烤鱼 炭火烤鱼 烤鱼加盟 加盟 烤鱼店加盟
         * crowd : null
         * area : 全国
         * support : ["远程协助选址","总部统一装修","总部短期培训","技术操作培训","行业背景分析","区域保护支持","开业指导","人员管理指导","销售指导"]
         * investMin : 13
         * investMax : 20
         * margin : null
         * facilityCost : null
         * otherCost : 6
         * description : &ldquo;馋火炉鱼&rdquo;聚团队、教技术、通物流、创环境，以解众人之&ldquo;馋&rd
         * directStore : 3
         * joinStore : 300
         * messageNum : 925
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
    }
}
