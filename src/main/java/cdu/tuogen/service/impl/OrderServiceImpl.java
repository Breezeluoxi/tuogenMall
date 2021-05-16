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

package cdu.tuogen.service.impl;

import cdu.tuogen.bean.Page;
import cdu.tuogen.mapper.OrdersMapper;
import cdu.tuogen.mapper.UserMapper;
import cdu.tuogen.pojo.*;
import cdu.tuogen.service.OrderService;
import cdu.tuogen.utils.BreezeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BreezeUtil breezeUtil;

    @Override
    public PageInfo<OrderInfo> queryOrders(Page page) {
        // 分页限制查询
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<Order> orders = ordersMapper.queryOrders();
        List<OrderInfo> orderInfos = breezeUtil.getPrentOrders(orders);
        return new PageInfo<>(orderInfos);
    }

    @Override
    public <T> PageInfo<OrderInfoUser> queryOrdersById(Page page, T user) {
        if(user instanceof User){
            PageHelper.startPage(page.getPageNum(),page.getPageSize());
            List<UserOrderMap> orderListIds = ordersMapper.queryUserOrderListByUserIds(((User) user).getUserId());
            List<OrderInfoUser> orderForUser = breezeUtil.getOrderForUser(orderListIds, (User) user);
            return new PageInfo<>(orderForUser);
        }else if(user instanceof Admin){

        }else{
            return null;
        }
        return null;
    }

    @Override
    public OrderInfo queryOrder(Order order) {
        return breezeUtil.getPrentOrder(ordersMapper.queryOrder(order));
    }

    @Override
    public Order searcherOrder(Order order) {
        return ordersMapper.queryOrder(order);
    }

    @Override
    public Integer insertOrder(List<Order> orderList) {
        return ordersMapper.insertOrder(orderList);
    }

    @Override
    public Integer deleteOrders(List<Integer> ids) {
        return ordersMapper.deleteOrders(ids);
    }

    @Override
    public Integer updateOrders(Order order) {
        return ordersMapper.updateOrders(order);
    }

    @Override
    public void insertGoodsList(List<GoodsList> asList) {
        ordersMapper.insertGoodsList(asList);
    }

    @Override
    public Integer insertUserOrderList(List<UserOrderList> userOrderLists) {
        return ordersMapper.insertUserOrderList(userOrderLists);
    }

    @Override
    public Integer insertUserOrder(List<UserOrder> userOrderLists) {
        return ordersMapper.insertUserOrder(userOrderLists);
    }
}
