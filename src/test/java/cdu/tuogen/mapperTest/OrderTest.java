/**
 * @date : 2021/5/1
 * @name : tuogenMall_cdu.tuogen.test_OrderTest
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

package cdu.tuogen.mapperTest;

import cdu.tuogen.mapper.OrdersMapper;
import cdu.tuogen.pojo.*;
import cdu.tuogen.pojo.myenum.OrderPayMethod;
import cdu.tuogen.pojo.myenum.OrderPayStatus;
import cdu.tuogen.pojo.myenum.OrderStatus;
import cdu.tuogen.pojo.myenum.OrderTransMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class OrderTest {

    Logger log = LoggerFactory.getLogger(OrderTest.class);

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void orderMapperQueryOrders(){
        log.error(ordersMapper.queryOrders().get(0).toString());
    }

    @Test
    public void orderMapperQueryOrderById(){
        log.error(ordersMapper.queryOrder(new Order(1)).toString());
    }

    @Test
    public void orderMapperInsertOrder(){
        List<Order> orderList = Arrays.asList(new Order(null, 1, 1, 1, new Date(),
                        OrderStatus.TODO.getStatus(), OrderPayStatus.UNPAID.getStatus(),
                        OrderPayMethod.ALI_PAY.getStatus(), OrderTransMethod.ZT.getDescribe()),
                new Order(null, 1, 1, 1, new Date(),
                        OrderStatus.TODO.getStatus(), OrderPayStatus.UNPAID.getStatus(),
                        OrderPayMethod.ALI_PAY.getStatus(), OrderTransMethod.SF.getDescribe()
                ));
        List<Order> orderList1 = Arrays.asList(new Order(null, 1, 1, 1, new Date(),
                        OrderStatus.TODO.getStatus(), OrderPayStatus.UNPAID.getStatus(),
                        OrderPayMethod.ALI_PAY.getStatus(), OrderTransMethod.YT.getDescribe(),
                        1L,789.5,4848.5),
                new Order(null, 1, 1, 1, new Date(),
                        OrderStatus.TODO.getStatus(), OrderPayStatus.UNPAID.getStatus(),
                        OrderPayMethod.ALI_PAY.getStatus(), OrderTransMethod.ST.getDescribe()
                ));
        Integer integer = ordersMapper.insertOrder(orderList1);
        System.out.println("======================"+orderList.toString());
    }

    @Test
    public void orderMapperDeleteOrder(){
        Integer integer = ordersMapper.deleteOrders(Arrays.asList(5, 4, 3));
        if (integer != 0) {
            log.error("删除成功！！！");
        }else{
            log.error("删除失败！！");
        }
    }

    @Test
    public void orderMapperUpdateOrder(){
        Order order = ordersMapper.queryOrder(new Order(13));
        order.setOrderDeliveryMethod(OrderTransMethod.SF.getDescribe());
        ordersMapper.updateOrders(order);
    }
}
