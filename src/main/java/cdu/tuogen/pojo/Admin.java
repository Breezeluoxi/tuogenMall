package cdu.tuogen.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Bean;

/**
 * @author Breezeluoxi
 */

public class Admin{

  private Integer adminId;
  @NotBlank(message = "密码必须存在")
  private String adminPassword;
  private String adminLevel;
  private String adminShopName;
  private Integer adminShopId;
  @NotBlank(message = "用户名必须存在")
  private String adminName;
  private String picUrl;

  public Admin(Integer adminId) {
    this.adminId = adminId;
  }

  public Admin(String adminName,String adminPassword) {
    this.adminPassword = adminPassword;
    this.adminName = adminName;
  }

  @Override
  public String toString() {
    return "Admin{" +
            "adminId=" + adminId +
            ", adminPassword='" + adminPassword + '\'' +
            ", adminLevel='" + adminLevel + '\'' +
            ", adminShopName='" + adminShopName + '\'' +
            ", adminName='" + adminName + '\'' +
            ", adminShopId=" + adminShopId +
            ", picUrl='" + picUrl + '\'' +
            '}';
  }

  public Admin() {
  }



  public Admin(Integer adminId, String adminPassword, String adminLevel, String adminShopName, String adminName, Integer adminShopId, String picUrl) {
    this.adminId = adminId;
    this.adminPassword = adminPassword;
    this.adminLevel = adminLevel;
    this.adminShopName = adminShopName;
    this.adminName = adminName;
    this.adminShopId = adminShopId;
    this.picUrl = picUrl;
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

  public Integer getAdminShopId() {
    return adminShopId;
  }

  public void setAdminShopId(Integer adminShopId) {
    this.adminShopId = adminShopId;
  }

  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }
}
