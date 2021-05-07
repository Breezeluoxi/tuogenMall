package cdu.tuogen.pojo;

public class GoodsAll {
    private Integer goodId;
    private String goodName;
    private Integer goodTypeId;
    private String goodSaleType;
    private Integer goodNum;
    private String goodIntroduce;
    private Float goodPrice;
    private Integer goodShopId;
    private String goodPicUrl;
    private Integer goodsTypeId;
    private String goodType;

    public GoodsAll() {
        super();
    }


    public GoodsAll(Integer goodId, String goodName, Integer goodTypeId, String goodSaleType, Integer goodNum, String goodIntroduce, Float goodPrice, Integer goodShopId, String goodPicUrl,Integer goodsTypeId, String goodType) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodTypeId = goodTypeId;
        this.goodSaleType = goodSaleType;
        this.goodNum = goodNum;
        this.goodIntroduce = goodIntroduce;
        this.goodPrice = goodPrice;
        this.goodShopId = goodShopId;
        this.goodPicUrl =goodPicUrl;
        this.goodsTypeId =goodsTypeId;
        this.goodType =goodType;
    }


    public Integer getGoodShopId() {
        return goodShopId;
    }

    public void setGoodShopId(Integer goodShopId) {
        this.goodShopId = goodShopId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getGoodTypeId() {
        return goodTypeId;
    }

    public void setGoodTypeId(Integer goodTypeId) {
        this.goodTypeId = goodTypeId;
    }

    public String getGoodSaleType() {
        return goodSaleType;
    }

    public void setGoodSaleType(String goodSaleType) {
        this.goodSaleType = goodSaleType;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public String getGoodIntroduce() {
        return goodIntroduce;
    }

    public void setGoodIntroduce(String goodIntroduce) {
        this.goodIntroduce = goodIntroduce;
    }

    public Float getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Float goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodPicUrl() {
        return goodPicUrl;
    }

    public void setGoodPicUrl(String goodPicUrl) {
        this.goodPicUrl = goodPicUrl;
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    @Override
    public String toString() {
        return "GoodsAll{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", goodTypeId=" + goodTypeId +
                ", goodSaleType='" + goodSaleType + '\'' +
                ", goodNum=" + goodNum +
                ", goodIntroduce='" + goodIntroduce + '\'' +
                ", goodPrice=" + goodPrice + '\'' +
                ",  goodShopId;=" +  goodShopId+ '\'' +
                ", goodPicUrl=" + goodPicUrl + '\'' +
                ", goodsTypeId=" + goodsTypeId + '\'' +
                ", goodType=" + goodType +
                '}';
    }

}
