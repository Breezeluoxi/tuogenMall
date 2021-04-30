package cdu.tuogen.pojo;

import java.util.Date;

public class TUserCoupon {

  private Long id;
  private Long userId;
  private Long couponId;
  private Long num;
  private Date getData;
  private Date validityDate;

  public TUserCoupon() {
  }

  public TUserCoupon(Long id) {
    this.id = id;
  }

  public TUserCoupon(Long id, Long userId, Long couponId, Long num, Date getData, Date validityDate) {
    this.id = id;
    this.userId = userId;
    this.couponId = couponId;
    this.num = num;
    this.getData = getData;
    this.validityDate = validityDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getCouponId() {
    return couponId;
  }

  public void setCouponId(Long couponId) {
    this.couponId = couponId;
  }

  public Long getNum() {
    return num;
  }

  public void setNum(Long num) {
    this.num = num;
  }

  public Date getGetData() {
    return getData;
  }

  public void setGetData(Date getData) {
    this.getData = getData;
  }

  public Date getValidityDate() {
    return validityDate;
  }

  public void setValidityDate(Date validityDate) {
    this.validityDate = validityDate;
  }

  @Override
  public String toString() {
    return "TUserCoupon{" +
            "id=" + id +
            ", userId=" + userId +
            ", couponId=" + couponId +
            ", num=" + num +
            ", getData=" + getData +
            ", validityDate=" + validityDate +
            '}';
  }
}
