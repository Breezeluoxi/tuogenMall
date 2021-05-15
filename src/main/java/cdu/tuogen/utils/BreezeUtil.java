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
import cdu.tuogen.mapper.GoodsMapper;
import cdu.tuogen.mapper.OrdersMapper;
import cdu.tuogen.mapper.UserMapper;
import cdu.tuogen.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Component(value = "breeze")
public class BreezeUtil {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    public List<OrderInfo> getPrentOrders(List<Order> orders) {
        ArrayList<OrderInfo> orderInfos = new ArrayList<>();
        for (Order order :
                orders) {
            // 1.获取用户信息
            User user = userMapper.queryUser(new User(order.getUserId()));
            // 2.封装实体类
            orderInfos.add(new OrderInfo(order.getOrderId(), user.getUserName(),
                    order.getOrderTotalAmount(), order.getOrderPayableAmount(), order.getOrderStatus(), order.getOrderPayStatus(), order.getOrderDeliveryMethod(),
                    order.getCreateTime()));
        }
        return orderInfos;
    }

    public OrderInfo getPrentOrder(Order order) {
        // 1.获取用户信息
        User user = userMapper.queryUser(new User(order.getUserId()));
        // 2.封装实体类并返回
        return new OrderInfo(order.getOrderId(), user.getUserName(),
                order.getOrderTotalAmount(), order.getOrderPayableAmount(), order.getOrderStatus(), order.getOrderPayStatus(), order.getOrderDeliveryMethod(),
                order.getCreateTime());
    }

    public <T extends User> List<OrderInfoUser> getOrderForUser(List<UserOrderMap> OrderListId, T user) {
        ArrayList<OrderInfoUser> orderList = new ArrayList<>();
        // 1. 查询OrderList orderList
        for (UserOrderMap orderMap :
                OrderListId) {
            List<Integer> orderIds = ordersMapper.queryOrdersByOrderListIds(orderMap.getUserOrderListId());
            // 2.封装一个订单
            orderList.add(getOrderInfoUSer(orderIds, user,orderMap));
        }
        return orderList;
    }

    private OrderInfoUser getOrderInfoUSer(List<Integer> orderIdList, User user,UserOrderMap orderMap) {
        Map<Goods, Integer> map = new HashMap<>(4);

        List<Order> orders = new ArrayList<>();
        // 1.遍历用户订单列表中的所有订单id
        for (Integer orderId :
                orderIdList) {
            // 2.遍历通过用户订单id查询到的所有订单id
            Order order = ordersMapper.queryOrder(new Order(orderId));

            // 3.查询到订单对应的所有商品及数量
            List<GoodsMap> goodsMaps = ordersMapper.queryGoodsListMapMerId(order.getMerId());


            for (GoodsMap goodsMap
                    : goodsMaps
            ) {
                // 3.增加到Map中
                Goods goods = goodsMapper.queryGoodsById(goodsMap.getGoodsId());
                map.put(goods, goodsMap.getCount());
            }
            orders.add(order);



        }

        return new OrderInfoUser(orderMap.getUserOrderId(), user.getUserName(),
                orders.get(0).getCreateTime(), orders.get(0).getOrderStatus(), orders.get(0).getOrderPayStatus(),
                orders.get(0).getOrderPayMethod(), map);
    }
}
