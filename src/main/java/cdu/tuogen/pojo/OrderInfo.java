/**
 * @date : 2021/5/3
 * @name : tuogenMall_cdu.tuogen.pojo_PrentOrder
 * @Author: Breezeluoxi
 *                                                    __----~~~~~~~~~~~------___
 *                                   .  .   ~~//====......          __--~ ~~
 *                   -.            \_|//     |||\\  ~~~~~~::::... /~
 *                ___-==_       _-~o~  \/    |||  \\            _/~~-
 *        __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
 *    _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
 *  .~       .~       |   \\ -_    /  /-   /   ||      \   /
 * /  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
 * |~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
 *          '         ~-|      /|    |-~\~~       __--~~
 *                      |-~~-_/ |    |   ~\_   _-~            /\
 *                           /  \     \__   \/~                \__
 *                       _--~ _/ | .-~~____--~-/                  ~~==.
 *                      ((->/~   '.|||' -_|    ~~-/ ,              . _||
 *                                 -_     ~\      ~~---l__i__i__i--~~_/
 *                                 _-~-__   ~)  \--______________--~~
 *                               //.-~~~-~_--~- |-------~~~~~~~~
 *                                      //.-~~~--\
 *                          神兽保佑                   代码无BUG!
 */

package cdu.tuogen.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderInfo {
    /**
     * 订单编号
     */
    private Integer orderId;
    /**
     * 收货人
     */
    private String username;
    /**
     * 总金额
     */
    private Double totalAmount;
    /**
     * 应付金额
     */
    private Double payAbleAmount;
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getOrderPayStatus() {
        return orderPayStatus;
    }

    public void setOrderPayStatus(Byte orderPayStatus) {
        this.orderPayStatus = orderPayStatus;
    }

    public String getOrderDeliveryMethod() {
        return orderDeliveryMethod;
    }

    public void setOrderDeliveryMethod(String orderDeliveryMethod) {
        this.orderDeliveryMethod = orderDeliveryMethod;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public OrderInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPayAbleAmount() {
        return payAbleAmount;
    }

    public void setPayAbleAmount(Double payAbleAmount) {
        this.payAbleAmount = payAbleAmount;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderId=" + orderId +
                ", username='" + username + '\'' +
                ", totalAmount=" + totalAmount +
                ", payAbleAmount=" + payAbleAmount +
                ", orderStatus=" + orderStatus +
                ", orderPayStatus=" + orderPayStatus +
                ", orderDeliveryMethod='" + orderDeliveryMethod + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    @Deprecated
    public OrderInfo(Integer orderId, String name, Byte orderStatus, Byte orderPayStatus, String orderDeliveryMethod, Date createTime) {
        this.orderId = orderId;
        this.username = name;
        this.orderStatus = orderStatus;
        this.orderPayStatus = orderPayStatus;
        this.orderDeliveryMethod = orderDeliveryMethod;
        this.createTime = createTime;
    }

    public OrderInfo(Integer orderId, String username, Double totalAmount, Double payAbleAmount, Byte orderStatus, Byte orderPayStatus, String orderDeliveryMethod, Date createTime) {
        this.orderId = orderId;
        this.username = username;
        this.totalAmount = totalAmount;
        this.payAbleAmount = payAbleAmount;
        this.orderStatus = orderStatus;
        this.orderPayStatus = orderPayStatus;
        this.orderDeliveryMethod = orderDeliveryMethod;
        this.createTime = createTime;
    }
}
