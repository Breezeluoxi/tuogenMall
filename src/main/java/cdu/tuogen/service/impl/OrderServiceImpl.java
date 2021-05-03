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
import cdu.tuogen.pojo.Order;
import cdu.tuogen.pojo.PrentOrder;
import cdu.tuogen.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public PageInfo<PrentOrder> queryOrders(Page page) {
        // 分页限制查询
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<Order> queryOrders = ordersMapper.queryOrders();
        // 降级为PrentOrder
        List<PrentOrder> orders = new ArrayList<>();
        for (Order order :
                queryOrders) {
            orders.add(order);
        }

        return new PageInfo<PrentOrder>(orders);
    }

    @Override
    public Order queryOrder(Order order) {
        return ordersMapper.queryOrder(order);
    }

    @Override
    public Integer insertOrder(List<Order> orderList) {
        return null;
    }

    @Override
    public Integer deleteOrders(List<Integer> ids) {
        return null;
    }

    @Override
    public Integer updateOrders(Order order) {
        return null;
    }
}
