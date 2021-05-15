package cdu.tuogen.service;

import cdu.tuogen.bean.Page;
import cdu.tuogen.pojo.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @date : 2021/5/2
 * @name : tuogenMall_cdu.tuogen.service.impl_OrderService
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


public interface OrderService {
    /**
     * 查询所有订单
     * @param page 分页信息
     * @return Orders
     */
    @Deprecated
    PageInfo<OrderInfo> queryOrders(Page page);


    /**
     * 通过用户ID查询订单
     * @param page
     * @param user
     * @param <T>
     * @return
     */
    <T> PageInfo<OrderInfoUser> queryOrdersById(Page page, T user);

    /**
     * 通过id查询单个用户
     * @param order 完整的订单
     * @return Order
     */
    OrderInfo queryOrder(Order order);

    /**
     * 插入订单
     * @param orderList 完整订单
     * @return 影响行数
     */
    Integer insertOrder(List<Order> orderList);

    /**
     * 批量删除
     * @param ids id列表
     * @return 影响行数
     */
    Integer deleteOrders(List<Integer> ids);

    /**
     * 更新用户
     * @param order order
     * @return
     */
    Integer updateOrders(Order order);

    /**
     * 插入商品关联订单表
     * @param asList
     */
    void insertGoodsList(List<GoodsList> asList);
    /**
     * 插入用户订单列表表
     * @param userOrderLists
     * @return
     */
    Integer insertUserOrderList(List<UserOrderList> userOrderLists);

    /**
     * 插入用户订单列表表
     * @param userOrderLists
     * @return
     */
    Integer insertUserOrder(List<UserOrder> userOrderLists);
}
