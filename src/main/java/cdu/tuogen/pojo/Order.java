package cdu.tuogen.pojo;


import sun.util.calendar.BaseCalendar;

import java.util.List;
import java.util.Date;

/**
 * @author Breezeluoxi
 */
public class Order {

  private Integer orderId;
  private String name;
  private Integer merId;
  private Integer userId;
  private Integer adminId;
  private List<OrderGoods> goodList;
  private Date createTime;

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Order(Integer orderId, String name, Integer merId, Integer userId, Integer adminId, List<OrderGoods> goodList, Date createTime) {
    this.orderId = orderId;
    this.name = name;
    this.merId = merId;
    this.userId = userId;
    this.adminId = adminId;
    this.goodList = goodList;
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "Order{" +
            "orderId=" + orderId +
            ", name='" + name + '\'' +
            ", merId=" + merId +
            ", userId=" + userId +
            ", adminId=" + adminId +
            ", goodList=" + goodList +
            ", createTime=" + createTime +
            '}';
  }

  public Order(Integer orderId, String name, Integer merId, Integer userId, Integer adminId, Date createTime) {
    this.orderId = orderId;
    this.name = name;
    this.merId = merId;
    this.userId = userId;
    this.adminId = adminId;
    this.createTime = createTime;
  }

  public Order(Integer orderId) {
    this.orderId = orderId;
  }

  public Order() {
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
