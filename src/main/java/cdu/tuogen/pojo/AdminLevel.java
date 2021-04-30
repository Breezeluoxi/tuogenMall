package cdu.tuogen.pojo;


/**
 * @author Breezeluoxi
 */
public class AdminLevel {

  private String adminLevel;
  private Byte addFunction;
  private Byte deleteFunction;
  private Byte checkFunction;
  private Byte modifyFunction;
  private Byte warehousing;

    public AdminLevel() {
    }

    public AdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    public AdminLevel(String adminLevel, Byte addFunction, Byte deleteFunction, Byte checkFunction, Byte modifyFunction, Byte warehousing) {
        this.adminLevel = adminLevel;
        this.addFunction = addFunction;
        this.deleteFunction = deleteFunction;
        this.checkFunction = checkFunction;
        this.modifyFunction = modifyFunction;
        this.warehousing = warehousing;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    public Byte getAddFunction() {
        return addFunction;
    }

    public void setAddFunction(Byte addFunction) {
        this.addFunction = addFunction;
    }

    public Byte getDeleteFunction() {
        return deleteFunction;
    }

    public void setDeleteFunction(Byte deleteFunction) {
        this.deleteFunction = deleteFunction;
    }

    public Byte getCheckFunction() {
        return checkFunction;
    }

    public void setCheckFunction(Byte checkFunction) {
        this.checkFunction = checkFunction;
    }

    public Byte getModifyFunction() {
        return modifyFunction;
    }

    public void setModifyFunction(Byte modifyFunction) {
        this.modifyFunction = modifyFunction;
    }

    public Byte getWarehousing() {
        return warehousing;
    }

    public void setWarehousing(Byte warehousing) {
        this.warehousing = warehousing;
    }

    @Override
    public String toString() {
        return "AdminLevel{" +
                "adminLevel='" + adminLevel + '\'' +
                ", addFunction=" + addFunction +
                ", deleteFunction=" + deleteFunction +
                ", checkFunction=" + checkFunction +
                ", modifyFunction=" + modifyFunction +
                ", warehousing=" + warehousing +
                '}';
    }
}
