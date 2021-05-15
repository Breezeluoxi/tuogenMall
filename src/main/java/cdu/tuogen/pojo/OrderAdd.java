package cdu.tuogen.pojo;

import java.util.List;

/**
 * @date : 2021/5/15
 * @name : cdu.tuogen.pojo.OrderAdd
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
public class OrderAdd {
    //{adminId: "1", userId: "1", tranMethod: "1", payMethod: "0", goodList: "1"}

    private Integer adminId;
    private Integer userId;
    private Integer transMethod;
    private Integer payMethod;
    private String goodsList;

    @Override
    public String toString() {
        return "OrderAdd{" +
                "adminId=" + adminId +
                ", userId=" + userId +
                ", transMethod=" + transMethod +
                ", payMethod=" + payMethod +
                ", goodsList='" + goodsList + '\'' +
                '}';
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTransMethod() {
        return transMethod;
    }

    public void setTransMethod(Integer transMethod) {
        this.transMethod = transMethod;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public String getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(String goodsList) {
        this.goodsList = goodsList;
    }

    public OrderAdd(Integer adminId, Integer userId, Integer transMethod, Integer payMethod, String goodsList) {
        this.adminId = adminId;
        this.userId = userId;
        this.transMethod = transMethod;
        this.payMethod = payMethod;
        this.goodsList = goodsList;
    }
}
