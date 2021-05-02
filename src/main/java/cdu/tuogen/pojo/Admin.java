package cdu.tuogen.pojo;


/**
 * @author Breezeluoxi
 */
public class Admin {

  private Integer adminId;
  private String adminPassword;
  private String adminLevel;
  private String adminShopName;
  private String adminName;

  public Admin(String adminPassword, String adminName) {
    this.adminPassword = adminPassword;
    this.adminName = adminName;
  }

  public Admin(Integer adminId, String adminPassword, String adminLevel, String adminShopName, String adminName) {
    this.adminId = adminId;
    this.adminPassword = adminPassword;
    this.adminLevel = adminLevel;
    this.adminShopName = adminShopName;
    this.adminName = adminName;
  }

  public Admin() {
  }

  @Override
  public String toString() {
    return "Admin{" +
            "adminId=" + adminId +
            ", adminPassword='" + adminPassword + '\'' +
            ", adminLevel='" + adminLevel + '\'' +
            ", adminShopName='" + adminShopName + '\'' +
            ", adminName='" + adminName + '\'' +
            '}';
  }

  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }

  public String getAdminPassword() {
    return adminPassword;
  }

  public void setAdminPassword(String adminPassword) {
    this.adminPassword = adminPassword;
  }

  public String getAdminLevel() {
    return adminLevel;
  }

  public void setAdminLevel(String adminLevel) {
    this.adminLevel = adminLevel;
  }

  public String getAdminShopName() {
    return adminShopName;
  }

  public void setAdminShopName(String adminShopName) {
    this.adminShopName = adminShopName;
  }

  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }
}
