package cdu.tuogen.pojo;


import java.util.Arrays;
import java.util.List;

/**
 * @author Breezeluoxi
 */
public class ShoppingCart {

  private Integer userId;
  private List<Integer> goodIds;

  @Override
  public String toString() {
    return "ShoppingCart{" +
            "userId=" + userId +
            ", goodId=" + goodIds.toString() +
            '}';
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

  public ShoppingCart() {
  }

  public ShoppingCart(Integer userId, List<Integer> goodIds) {
    this.userId = userId;
    this.goodIds = goodIds;
  }
}
