package cdu.tuogen.pojo;

import java.util.Date;

public class TLog {

  private Long id;
  private Date date;
  private String type;
  private String describe;
  private Long adminId;

    public TLog() {
    }

    public TLog(Long id) {
        this.id = id;
    }

    public TLog(Long id, Date date, String type, String describe, Long adminId) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.describe = describe;
        this.adminId = adminId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "TLog{" +
                "id=" + id +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", describe='" + describe + '\'' +
                ", adminId=" + adminId +
                '}';
    }
}
