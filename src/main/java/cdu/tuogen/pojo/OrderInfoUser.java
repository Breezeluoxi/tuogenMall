package cdu.tuogen.pojo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @date : 2021/5/14
 * @name : cdu.tuogen.pojo.OrderInfoUser
 * @Author: breezeluoxi
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


public class OrderInfoUser implements Serializable {
    /**
     * 订单号
     */
    private Integer orderId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 时间
     */
    @JsonFormat(pattern = "YY-MM-DD hh:mm")
    private Date createTime;
    /**
     * 订单状态
     */
    private Byte orderStatus;
    /**
     * 支付状态
     */
    private Byte orderPayStatus;
    /**
     * 支付方式
     */
    private Byte orderPayMethod;
    /**
     * 商品
     */
    @JsonIgnore
    private Map<Goods,Integer> goodsList;

    /**
     * orderImg
     */
    private String orderImg;

    public String getOrderImg() {
        return orderImg;
    }

    public void setOrderImg(String orderImg) {
        for (Map.Entry map :
                goodsList.entrySet()) {
            Goods key = (Goods)map.getKey();
            this.orderImg = key.getGoodPicUrl();
            return;
        }
    }

    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 总价格
     */
    private Double allPrc;

    public String getGoodsName() {
        for (Map.Entry map :
                goodsList.entrySet()) {
            Goods key = (Goods)map.getKey();
            return key.getGoodName();
        }
        return "没辙了";
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getAllPrc() {
        Double money=0.0;
        for (Map.Entry map :
                goodsList.entrySet()) {
            Goods key = (Goods)map.getKey();
            money+=key.getGoodPrice();
        }
        return money;
    }

    public void setAllPrc(Double allPrc) {
        this.allPrc = allPrc;
    }

    /**
     *
     * @param orderId
     * @param userName
     * @param createTime
     * @param orderStatus
     * @param orderPayStatus
     * @param orderPayMethod
     * @param goodsList
     */
    public OrderInfoUser(Integer orderId, String userName, Date createTime, Byte orderStatus, Byte orderPayStatus, Byte orderPayMethod, Map<Goods, Integer> goodsList) {
        this.orderId = orderId;
        this.userName = userName;
        this.createTime = createTime;
        this.orderStatus = orderStatus;
        this.orderPayStatus = orderPayStatus;
        this.orderPayMethod = orderPayMethod;
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "OrderInfoUser{" +
                "orderId=" + orderId +
                ", UserName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", orderStatus=" + orderStatus +
                ", orderPayStatus=" + orderPayStatus +
                ", orderPayMethod=" + orderPayMethod +
                ", goodsList=" + goodsList +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Byte getOrderPayMethod() {
        return orderPayMethod;
    }

    public void setOrderPayMethod(Byte orderPayMethod) {
        this.orderPayMethod = orderPayMethod;
    }

    public Map<Goods, Integer> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(Map<Goods, Integer> goodsList) {
        this.goodsList = goodsList;
    }
}
