package cdu.tuogen.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Breezeluoxi
 */
public class Order extends PrentOrder {
    /**
     * 订单编号
     */
    private Integer orderId;
    /**
     * 商品集合
     */
    private List<Goods> goodsList;
    /**
     * 订单卖家信息
     */
    private User user;
    /**
     * 订单商家信息
     */
    private Admin admin;
    /**
     * 订单物流状态
     */
    private Byte orderStatus;
    /**
     * 订单支付状态
     */
    private Byte orderPayStatus;
    /**
     * 订单配送方式
     */
    private String orderDeliveryMethod;
    /**
     * 订单创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Order(Integer orderId, List<Goods> goodsList, User user, Admin admin) {
        Double totalAmount = 0.0;
        for (Goods goods :
                goodsList) {
            totalAmount += goods.getGoodPrice();
        }
        super.setOrderId(orderId);
        super.setName(user.getUserName());
        super.setTotalAmount(totalAmount);
        //TODO 获取用户打折水平以获得最终应付价格
        super.setPayAbleAmount(totalAmount);

        this.goodsList = goodsList;
        this.user = user;
        this.admin = admin;
    }

    public Order(Integer orderId, List<Goods> goodsList, User user, Admin admin, Byte orderStatus, Byte orderPayStatus, String orderDeliveryMethod, Date createTime) {
        this.orderId = orderId;
        this.goodsList = goodsList;
        this.user = user;
        this.admin = admin;
        this.orderStatus = orderStatus;
        this.orderPayStatus = orderPayStatus;
        this.orderDeliveryMethod = orderDeliveryMethod;
        this.createTime = createTime;
    }

    @Override
    public Integer getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Order() {
    }

    @Override
    public Byte getOrderStatus() {
        return orderStatus;
    }

    @Override
    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public Byte getOrderPayStatus() {
        return orderPayStatus;
    }

    @Override
    public void setOrderPayStatus(Byte orderPayStatus) {
        this.orderPayStatus = orderPayStatus;
    }

    @Override
    public String getOrderDeliveryMethod() {
        return orderDeliveryMethod;
    }

    @Override
    public void setOrderDeliveryMethod(String orderDeliveryMethod) {
        this.orderDeliveryMethod = orderDeliveryMethod;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
