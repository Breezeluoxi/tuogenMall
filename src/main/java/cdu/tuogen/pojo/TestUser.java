package cdu.tuogen.pojo;


/**
 * @author Breeze
 */
public class TestUser {

  private Long id;
  private String name;
  private String password;
  private Byte gender;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Byte getGender() {
    return gender;
  }

  public void setGender(Byte gender) {
    this.gender = gender;
  }
}
