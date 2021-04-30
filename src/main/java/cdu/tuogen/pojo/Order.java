package cdu.tuogen.pojo;

import cdu.tuogen.pojo.myenum.OrderPayMethod;
import cdu.tuogen.pojo.myenum.OrderPayStatus;
import cdu.tuogen.pojo.myenum.OrderStatus;
import cdu.tuogen.pojo.myenum.OrderTransMethod;

import java.util.Date;

/**
 * @author Breezeluoxi
 */
public class Order{

  private Integer orderId;
  private Integer merId;
  private Integer userId;
  private Integer adminId;
  private Date createTime;
  private Byte orderStatus;
  private Byte orderPayStatus;
  private Byte orderPayMethod;
  private String orderDeliveryMethod;
  private Long orderUseCoupon=0L;
  private Double orderTotalAmount=-1.0;
  private Double orderPayableAmount=-1.0;

  public Order() {
  }

  public Order(Integer orderId) {
    this.orderId = orderId;
  }

  /**
   * 不指定所用优惠券
   * <p>已过时</p>
   * @param orderId
   * @param merId
   * @param userId
   * @param adminId
   * @param createTime
   * @param orderStatus
   * @param orderPayStatus
   * @param orderPayMethod
   * @param orderDeliveryMethod
   */
  @Deprecated
  public Order(Integer orderId, Integer merId, Integer userId,
               Integer adminId, Date createTime, Byte orderStatus,
               Byte orderPayStatus, Byte orderPayMethod,
               String orderDeliveryMethod) {
    this.orderId = orderId;
    this.merId = merId;
    this.userId = userId;
    this.adminId = adminId;
    this.createTime = createTime;
    this.orderStatus = orderStatus;
    this.orderPayStatus = orderPayStatus;
    this.orderPayMethod = orderPayMethod;
    this.orderDeliveryMethod = orderDeliveryMethod;
  }

  /**
   * 指定优惠券 总金额 实付款
   * @param orderId
   * @param merId
   * @param userId
   * @param adminId
   * @param createTime
   * @param orderStatus
   * @param orderPayStatus
   * @param orderPayMethod
   * @param orderDeliveryMethod
   * @param orderUseCoupon
   * @param orderTotalAmount
   * @param orderPayableAmount
   */
  public Order(Integer orderId, Integer merId, Integer userId, Integer
                adminId, Date createTime, Byte orderStatus, Byte orderPayStatus,
                Byte orderPayMethod, String orderDeliveryMethod, Long orderUseCoupon,
                Double orderTotalAmount, Double orderPayableAmount) {
    this.orderId = orderId;
    this.merId = merId;
    this.userId = userId;
    this.adminId = adminId;
    this.createTime = createTime;
    this.orderStatus = orderStatus;
    this.orderPayStatus = orderPayStatus;
    this.orderPayMethod = orderPayMethod;
    this.orderDeliveryMethod = orderDeliveryMethod;
    this.orderUseCoupon = orderUseCoupon;
    this.orderTotalAmount = orderTotalAmount;
    this.orderPayableAmount = orderPayableAmount;
  }

  @Override
  public String toString() {
    return "Order{" +
            "orderId=" + orderId +
            ", merId=" + merId +
            ", userId=" + userId +
            ", adminId=" + adminId +
            ", createTime=" + createTime +
            ", orderStatus=" + orderStatus +
            ", orderPayStatus=" + orderPayStatus +
            ", orderPayMethod=" + orderPayMethod +
            ", orderDeliveryMethod='" + orderDeliveryMethod + '\'' +
            ", orderUseCoupon=" + orderUseCoupon +
            ", orderTotalAmount=" + orderTotalAmount +
            ", orderPayableAmount=" + orderPayableAmount +
            '}';
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
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

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Byte getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(Byte orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Byte getOrderPayStatus() {
    return orderPayStatus;
  }

  public void setOrderPayStatus(Byte orderPayStatus) {
    this.orderPayStatus = orderPayStatus;
  }

  public Byte getOrderPayMethod() {
    return orderPayMethod;
  }

  public void setOrderPayMethod(Byte orderPayMethod) {
    this.orderPayMethod = orderPayMethod;
  }

  public String getOrderDeliveryMethod() {
    return orderDeliveryMethod;
  }

  public void setOrderDeliveryMethod(String orderDeliveryMethod) {
    this.orderDeliveryMethod = orderDeliveryMethod;
  }

  public Long getOrderUseCoupon() {
    return orderUseCoupon;
  }

  public void setOrderUseCoupon(Long orderUseCoupon) {
    this.orderUseCoupon = orderUseCoupon;
  }

  public Double getOrderTotalAmount() {
    return orderTotalAmount;
  }

  public void setOrderTotalAmount(Double orderTotalAmount) {
    this.orderTotalAmount = orderTotalAmount;
  }

  public Double getOrderPayableAmount() {
    return orderPayableAmount;
  }

  public void setOrderPayableAmount(Double orderPayableAmount) {
    this.orderPayableAmount = orderPayableAmount;
  }
}

