package cdu.tuogen.pojo;


/**
 * @author Breezeluoxi
 */
public class TCoupon {

  private Long id;
  private Long discount;
  private Long baseLine;

    public TCoupon() {
    }

    public TCoupon(Long id) {
        this.id = id;
    }

    public TCoupon(Long id, Long discount, Long baseLine) {
        this.id = id;
        this.discount = discount;
        this.baseLine = baseLine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getBaseLine() {
        return baseLine;
    }

    public void setBaseLine(Long baseLine) {
        this.baseLine = baseLine;
    }

    @Override
    public String toString() {
        return "TCoupon{" +
                "id=" + id +
                ", discount=" + discount +
                ", baseLine=" + baseLine +
                '}';
    }
}
