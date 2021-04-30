package cdu.tuogen.pojo;


/**
 * @author Breezeluoxi
 */
public class GoodsType {

  private Long goodTypeId;
  private String goodType;

  public GoodsType(Long goodTypeId, String goodType) {
    this.goodTypeId = goodTypeId;
    this.goodType = goodType;
  }

  public Long getGoodTypeId() {
    return goodTypeId;
  }

  public void setGoodTypeId(Long goodTypeId) {
    this.goodTypeId = goodTypeId;
  }

  public String getGoodType() {
    return goodType;
  }

  public void setGoodType(String goodType) {
    this.goodType = goodType;
  }

  @Override
  public String toString() {
    return "GoodsType{" +
            "goodTypeId=" + goodTypeId +
            ", goodType='" + goodType + '\'' +
            '}';
  }
}
