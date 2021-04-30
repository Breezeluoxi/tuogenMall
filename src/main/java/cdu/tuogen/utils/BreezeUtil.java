/**
 * @date : 2021/5/3
 * @name : tuogenMall_cdu.tuogen.utils_BreezeUtil
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

package cdu.tuogen.utils;

import cdu.tuogen.mapper.AdminMapper;
import cdu.tuogen.mapper.UserMapper;
import cdu.tuogen.pojo.Order;
import cdu.tuogen.pojo.OrderInfo;
import cdu.tuogen.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Component(value = "breeze")
public class BreezeUtil {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;

    public List<OrderInfo> getPrentOrders(List<Order> orders){
        ArrayList<OrderInfo> orderInfos = new ArrayList<>();
        for (Order order:
             orders) {
            // 1.获取用户信息
            User user = userMapper.queryUser(new User(order.getUserId()));
            // 2.封装实体类
            orderInfos.add(new OrderInfo(order.getOrderId(),user.getUserName(),
                    order.getOrderTotalAmount(),order.getOrderPayableAmount(),order.getOrderStatus(),order.getOrderPayStatus(), order.getOrderDeliveryMethod(),
                    order.getCreateTime()));
        }
        return orderInfos;
    }
    public OrderInfo getPrentOrder(Order order){
        // 1.获取用户信息
        User user = userMapper.queryUser(new User(order.getUserId()));
        // 2.封装实体类并返回
        return new OrderInfo(order.getOrderId(), user.getUserName(),
                order.getOrderTotalAmount(), order.getOrderPayableAmount(), order.getOrderStatus(), order.getOrderPayStatus(), order.getOrderDeliveryMethod(),
                order.getCreateTime());
    }
}
