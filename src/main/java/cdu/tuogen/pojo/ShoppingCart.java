package cdu.tuogen.pojo;


import java.util.List;

/**
 * @author Breezeluoxi
 */
public class ShoppingCart {

  private Integer userId;
  private List<Integer> goodIds;


  public ShoppingCart() {

  }

  public ShoppingCart(Integer userId, List<Integer> goodIds) {
    this.userId = userId;
    this.goodIds = goodIds;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public List<Integer> getGoodIds() {
    return goodIds;
  }

  public void setGoodIds(List<Integer> goodIds) {
    this.goodIds = goodIds;
  }

  @Override
  public String toString() {
    return "ShoppingCart{" +
            "userId=" + userId +
            ", goodIds=" + goodIds +
            '}';
  }
}
