package cdu.tuogen.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import sun.util.calendar.BaseCalendar;

import java.util.List;
import java.util.Date;

/**
 * @author Breezeluoxi
 */
public class Order extends PrentOrder{

  @JsonIgnore
  private Integer merId;
  private Integer userId;
  private Integer adminId;

  /**
   * 订单包含商品列表
   */
  private List<OrderGoods> goodList;
  /**
   * 订单卖家信息
   */
  private User user;
  /**
   * 订单商家信息
   */
  private Admin admin;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Admin getAdmin() {
    return admin;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public Order(Integer orderId, String name, Byte orderStatus, Byte orderPayStatus, String orderDeliveryMethod, Date createTime, Integer merId, Integer userId, Integer adminId, List<OrderGoods> goodList, User user, Admin admin) {
    super(orderId, user.getUserName(), orderStatus, orderPayStatus, orderDeliveryMethod, createTime);
    this.merId = merId;
    this.userId = userId;
    this.adminId = adminId;
    this.goodList = goodList;
    this.user = user;
    this.admin = admin;
  }

  public Order(Integer merId, Integer userId, Integer adminId, List<OrderGoods> goodList, User user, Admin admin) {
    this.merId = merId;
    this.userId = userId;
    this.adminId = adminId;
    this.goodList = goodList;
    this.user = user;
    this.admin = admin;
  }

  public Order() {
  }

  public Order(Integer merId) {
    this.merId = merId;
  }

  public Integer getMerId() {
    return merId;
  }

  public void setMerId(Integer merId) {
    this.merId = merId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }

  public List<OrderGoods> getGoodList() {
    return goodList;
  }

  public void setGoodList(List<OrderGoods> goodList) {
    this.goodList = goodList;
  }
}
