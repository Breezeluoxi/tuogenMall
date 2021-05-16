package cdu.tuogen.mapper;

import cdu.tuogen.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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
     * 查询同用户订单列表Id
     * @param id
     * @return
     */
    @Select("select user_order_id,userOrder_id from user_order where user_id=#{id}")
    List<UserOrderMap> queryUserOrderListByUserIds(@Param("id") Integer id);

    /**
     * 查询goodsList 表通过merId
     * @param id
     * @return
     */
    @Select("select mer_id from orders where mer_id=#{id}")
    List<Integer> queryGoodsListIdByMerId(@Param("id") Integer id);

    /**
     * 查询goodsList 表通过merId
     * @param id
     * @return
     */
    List<GoodsMap> queryGoodsListMapMerId(@Param("id") Integer id);

    /**
     * 查询同用户订单列表Id
     * @param id
     * @return
     */
    @Select("select order_id from userOrder_order where userOrder_order_id=#{id}")
    List<Integer> queryOrdersByOrderListIds(@Param("id") Integer id);


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
     * 插入商品列表表
     * @param goodsList
     * @return
     */
    Integer insertGoodsList(List<GoodsList> goodsList);
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
