package cdu.tuogen.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;

/**
 * @author Breezeluoxi
 */
public class User {

  private Integer userId;

  @JsonIgnore
  @NotBlank(message = "密码必须存在")
  private String userPassword;
  private String userVipLevel;

  @NotBlank(message = "用户名必须存在")
  private String userName;
  @Min(value = 1,message = "年龄最小值为1")
  private Short userAge;
  private String userPhone;
  private String userAddress;
  private String picUrl;


  public User(String userName, String userPassword) {
    this.userPassword = userPassword;
    this.userName = userName;
  }

  public User() {
  }

  public User(Integer userId) {
    this.userId = userId;
  }


  public User(Integer userId, String userPassword, String userVipLevel, String userName, Short userAge, String userPhone, String userAddress, String picUrl) {
    this.userId = userId;
    this.userPassword = userPassword;
    this.userVipLevel = userVipLevel;
    this.userName = userName;
    this.userAge = userAge;
    this.userPhone = userPhone;
    this.userAddress = userAddress;
    this.picUrl = picUrl;
  }

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", userPassword='" + userPassword + '\'' +
            ", userVipLevel='" + userVipLevel + '\'' +
            ", userName='" + userName + '\'' +
            ", userAge=" + userAge +
            ", userPhone='" + userPhone + '\'' +
            ", userAddress='" + userAddress + '\'' +
            ", picUrl='" + picUrl + '\'' +
            '}';
  }

  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserVipLevel() {
    return userVipLevel;
  }

  public void setUserVipLevel(String userVipLevel) {
    this.userVipLevel = userVipLevel;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Short getUserAge() {
    return userAge;
  }

  public void setUserAge(Short userAge) {
    this.userAge = userAge;
  }

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }
}
