package cdu.tuogen.pojo;

import java.util.Date;

/**
 * @author Breezeluoxi
 */
public class Log {

  private Date date;
  private String type;
  private String logDescribe;
  private Long adminId;

    public Log() {
    }

    public Log(Long adminId) {
        this.adminId = adminId;
    }

    public Log(Date date, String type, String logDescribe, Long adminId) {
        this.date = date;
        this.type = type;
        this.logDescribe = logDescribe;
        this.adminId = adminId;
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

    public String getLogDescribe() {
        return logDescribe;
    }

    public void setLogDescribe(String logDescribe) {
        this.logDescribe = logDescribe;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Log{" +
                "date=" + date +
                ", type='" + type + '\'' +
                ", logDescribe='" + logDescribe + '\'' +
                ", adminId=" + adminId +
                '}';
    }
}
