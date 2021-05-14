package cdu.tuogen.pojo;



public class Goods {

  private Integer goodId;
  private String goodName;
  private Integer goodTypeId;
  private String goodSaleType;
  private Integer goodNum;
  private String goodIntroduce;
  private Double goodPrice;
  private Integer goodShopId;
  private String goodPicUrl;

  public Goods() {
  }

  public Goods(Integer goodId) {
    this.goodId = goodId;
  }

  public Goods(Integer goodId, String goodName, Integer goodTypeId, String goodSaleType, Integer goodNum, String goodIntroduce, Double goodPrice, Integer goodShopId, String goodPicUrl) {
    this.goodId = goodId;
    this.goodName = goodName;
    this.goodTypeId = goodTypeId;
    this.goodSaleType = goodSaleType;
    this.goodNum = goodNum;
    this.goodIntroduce = goodIntroduce;
    this.goodPrice = goodPrice;
    this.goodShopId = goodShopId;
    this.goodPicUrl =goodPicUrl;
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

  public Double getGoodPrice() {
    return goodPrice;
  }

  public void setGoodPrice(Double goodPrice) {
    this.goodPrice = goodPrice;
  }

  public String getGoodPicUrl() {
    return goodPicUrl;
  }

  public void setGoodPicUrl(String goodPicUrl) {
    this.goodPicUrl = goodPicUrl;
  }


  @Override
  public String toString() {
    return "Goods{" +
            "goodId=" + goodId +
            ", goodName='" + goodName + '\'' +
            ", goodTypeId=" + goodTypeId +
            ", goodSaleType='" + goodSaleType + '\'' +
            ", goodNum=" + goodNum +
            ", goodIntroduce='" + goodIntroduce + '\'' +
            ", goodPrice=" + goodPrice + '\'' +
            ",  goodShopId;=" +  goodShopId+ '\'' +
            ", goodPicUrl=" + goodPicUrl +
            '}';
  }
}
