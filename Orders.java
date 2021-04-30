package com.sample;


public class Orders {

  private long orderId;
  private String name;
  private long merId;
  private long userId;
  private long adminId;


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getMerId() {
    return merId;
  }

  public void setMerId(long merId) {
    this.merId = merId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getAdminId() {
    return adminId;
  }

  public void setAdminId(long adminId) {
    this.adminId = adminId;
  }

}
