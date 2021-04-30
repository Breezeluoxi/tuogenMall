package cdu.tuogen.pojo;


/**
 * @author Breezeluoxi
 */
public class Goods {

  private Integer goodId;
  private String goodName;
  private Long goodTypeId;
  private String goodSaleType;
  private Long goodNum;
  private String goodIntroduce;
  private Double goodPrice;

  public Goods() {
  }

  public Goods(Integer goodId) {
    this.goodId = goodId;
  }

  public Goods(Integer goodId, String goodName, Long goodTypeId, String goodSaleType, Long goodNum, String goodIntroduce, Double goodPrice) {
    this.goodId = goodId;
    this.goodName = goodName;
    this.goodTypeId = goodTypeId;
    this.goodSaleType = goodSaleType;
    this.goodNum = goodNum;
    this.goodIntroduce = goodIntroduce;
    this.goodPrice = goodPrice;
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

  public Long getGoodTypeId() {
    return goodTypeId;
  }

  public void setGoodTypeId(Long goodTypeId) {
    this.goodTypeId = goodTypeId;
  }

  public String getGoodSaleType() {
    return goodSaleType;
  }

  public void setGoodSaleType(String goodSaleType) {
    this.goodSaleType = goodSaleType;
  }

  public Long getGoodNum() {
    return goodNum;
  }

  public void setGoodNum(Long goodNum) {
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

  @Override
  public String toString() {
    return "Goods{" +
            "goodId=" + goodId +
            ", goodName='" + goodName + '\'' +
            ", goodTypeId=" + goodTypeId +
            ", goodSaleType='" + goodSaleType + '\'' +
            ", goodNum=" + goodNum +
            ", goodIntroduce='" + goodIntroduce + '\'' +
            ", goodPrice=" + goodPrice +
            '}';
  }
}
