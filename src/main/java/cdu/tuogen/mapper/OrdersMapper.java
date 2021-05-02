package cdu.tuogen.mapper;

import cdu.tuogen.pojo.Order;

import java.util.List;

/**
 * @date : 2021/4/30
 * @name : tuogenMall_cdu.tuogen.mapper_OrdersMapper
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
 * <p>订单相关Mapper</p>
 */


public interface OrdersMapper {
    /**
     * 查询所有订单
     * @return Orders
     */
    List<Order> queryOrders();

    /**
     * 通过id查询单个用户
     * @param order 完整的订单
     * @return Order
     */
    Order queryOrder(Order order);

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
}
