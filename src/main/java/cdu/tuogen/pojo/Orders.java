package cdu.tuogen.pojo;


/**
 * @author Breezeluoxi
 */
public class Orders {

  private Long orderId;
  private String name;
  private Long merId;
  private Long userId;
  private Long adminId;

  @Override
  public String toString() {
    return "Orders{" +
            "orderId=" + orderId +
            ", name='" + name + '\'' +
            ", merId=" + merId +
            ", userId=" + userId +
            ", adminId=" + adminId +
            '}';
  }

  public Orders() {
  }

  public Orders(Long orderId, String name, Long merId, Long userId, Long adminId) {
    this.orderId = orderId;
    this.name = name;
    this.merId = merId;
    this.userId = userId;
    this.adminId = adminId;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getMerId() {
    return merId;
  }

  public void setMerId(Long merId) {
    this.merId = merId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getAdminId() {
    return adminId;
  }

  public void setAdminId(Long adminId) {
    this.adminId = adminId;
  }
}
