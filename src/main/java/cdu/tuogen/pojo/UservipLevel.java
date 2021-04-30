package cdu.tuogen.pojo;


public class UservipLevel {

  private String vipLevel;
  private Long couponNum;
  private Double transportDiscount;

  public UservipLevel() {
  }

  public UservipLevel(String vipLevel, Long couponNum, Double transportDiscount) {
    this.vipLevel = vipLevel;
    this.couponNum = couponNum;
    this.transportDiscount = transportDiscount;
  }

  public String getVipLevel() {
    return vipLevel;
  }

  public void setVipLevel(String vipLevel) {
    this.vipLevel = vipLevel;
  }

  public Long getCouponNum() {
    return couponNum;
  }

  public void setCouponNum(Long couponNum) {
    this.couponNum = couponNum;
  }

  public Double getTransportDiscount() {
    return transportDiscount;
  }

  public void setTransportDiscount(Double transportDiscount) {
    this.transportDiscount = transportDiscount;
  }

  @Override
  public String toString() {
    return "UservipLevel{" +
            "vipLevel='" + vipLevel + '\'' +
            ", couponNum=" + couponNum +
            ", transportDiscount=" + transportDiscount +
            '}';
  }
}
