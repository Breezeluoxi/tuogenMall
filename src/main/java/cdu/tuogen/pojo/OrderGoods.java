package cdu.tuogen.pojo;


/**
 * @author Breezeluoxi
 */
public class OrderGoods {

  private Integer merId;
  private Integer goodId;

  public OrderGoods(Integer merId, Integer goodId) {
    this.merId = merId;
    this.goodId = goodId;
  }

  public OrderGoods() {
  }

  public Integer getMerId() {
    return merId;
  }

  public void setMerId(Integer merId) {
    this.merId = merId;
  }

  public Integer getGoodId() {
    return goodId;
  }

  @Override
  public String toString() {
    return "OrderGoods{" +
            "merId=" + merId +
            ", goodId=" + goodId +
            '}';
  }

  public void setGoodId(Integer goodId) {
    this.goodId = goodId;
  }
}
