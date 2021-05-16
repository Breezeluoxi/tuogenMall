/**
 * @date : 2021/5/2
 * @name : tuogenMall_cdu.tuogen.controller_OrderController
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

package cdu.tuogen.controller;

import cdu.tuogen.bean.NormalMsg;
import cdu.tuogen.bean.Page;
import cdu.tuogen.mapper.GoodsMapper;
import cdu.tuogen.pojo.*;
import cdu.tuogen.pojo.myenum.OrderPayMethod;
import cdu.tuogen.pojo.myenum.OrderPayStatus;
import cdu.tuogen.pojo.myenum.OrderStatus;
import cdu.tuogen.pojo.myenum.OrderTransMethod;
import cdu.tuogen.service.OrderService;
import cdu.tuogen.service.UserService;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@CrossOrigin("http://localhost:8080")
public class OrderController {


    Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsMapper goodsMapper;

    @GetMapping("/orders")
    public NormalMsg queryOrders(int page, int limit,HttpServletRequest request){
        PageInfo<OrderInfo> orders = orderService.queryOrders(new Page(page, limit));
        System.out.println(orders);
        return getNormalMsg(orders);
    }

    @GetMapping("/queryOrders")
    public NormalMsg queryOrdersById(int page, int limit, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","true");
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        User user1 = userService.queryUser(new User(12));

        PageInfo<OrderInfoUser> orders = orderService.queryOrdersById(new Page(page, limit),user1);
        System.out.println(orders);
        return getNormalMsg(orders);
    }

    @GetMapping("/goodsList")
    public NormalMsg queryAdminGoods(HttpServletRequest request){

        NormalMsg msg;
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user instanceof Admin){
            List<Goods> goods = goodsMapper.queryGoodsByAdminId((Admin) user);
            msg = new NormalMsg(0, "查询成功",(long) goods.size(), goods);
        }else{
            msg = new NormalMsg(-1,"查询失败",0L, null);
        }
        return msg;
    }

    @RequestMapping("/addOrder")
    public NormalMsg addOrder(OrderAdd orderAdd,HttpServletRequest request){
        return doAddOrder(orderAdd,request.getSession().getAttribute("user"));
    }

    @GetMapping("/order/del")
    public String delOrder(Integer orderIds){
        Integer integer = orderService.deleteOrders(Arrays.asList(orderIds));
        return "ok";
    }

    @PostMapping("/updateOrder")
    public NormalMsg updateOrder(OrderModify orderModify){
        NormalMsg msg = null;

        System.out.println(orderModify);
        // 1.查询是否有订单
        Order queryOrder = orderService.searcherOrder(new Order(orderModify.getOrderId()));
        if(queryOrder == null){
            msg = new NormalMsg(-1,"没有此订单",0L, null);
        }else{
            // 2.修改值
            int orderStatus = orderModify.getOrderStatus();
            int payMethod = orderModify.getPayMethod();
            queryOrder.setOrderStatus((byte)orderStatus);
            queryOrder.setOrderDeliveryMethod(orderModify.getTransMethod());
            queryOrder.setOrderPayMethod((byte)payMethod);
            // 3. 更新订单
            orderService.updateOrders(queryOrder);
            msg =  new NormalMsg(0,"更新成功",1L, null);
        }
        return msg;
    }

    private NormalMsg doAddOrder(OrderAdd orderAdd, Object user) {
        if(orderAdd.getAdminId()==null || orderAdd.getGoodsList()==null
        || orderAdd.getPayMethod()==null||orderAdd.getUserId()==null){
            System.out.println("失败 1");
            return new NormalMsg(-1,"添加失败",0L,null);
        }
        else if(user instanceof Admin && ((Admin) user).getAdminId().equals(orderAdd.getUserId())){
            System.out.println("失败 2");

            return new NormalMsg(-1,"添加失败",0L,null);
        }else{
            // 1. 添加商品表
            // 1.1分离商品id
            String[] goodsIds = orderAdd.getGoodsList().split("_");
            // 1.2 查询是否有商品
            Double titlePrice = 0.0;
            int merId = (int)System.currentTimeMillis();
            List<GoodsList> lists = new ArrayList<>();
            for (String goods_id :
                    goodsIds) {
                titlePrice += goodsMapper.queryGoodsById(Integer.parseInt(goods_id)).getGoodPrice();
                lists.add(new GoodsList(merId, Integer.parseInt(goods_id), 1));
            }
            orderService.insertGoodsList(lists);
            // 2.插入订单表
            int orderId = (int)System.currentTimeMillis();
            int payMethod = orderAdd.getPayMethod();
            int transMethod = orderAdd.getTransMethod();
            List<Order> orderList1 = Arrays.asList(
                    new Order(orderId, merId,orderAdd.getUserId(), orderAdd.getAdminId(), new Date(),
                            OrderStatus.TODO.getStatus(), OrderPayStatus.UNPAID.getStatus(),
                            (byte)payMethod, "顺丰速递",0L,
                            titlePrice,titlePrice
                    ));
            orderService.insertOrder(orderList1);
            // 3.插入用户表
            int orderUserId = (int)System.currentTimeMillis();
            orderService.insertUserOrderList(Arrays.asList(
               new UserOrderList(orderUserId,orderId)
            ));
            // 3.1插入用户订单表表
            orderService.insertUserOrder(Arrays.asList(
               new UserOrder(orderUserId,orderAdd.getUserId())
            ));
            return new NormalMsg(1,"添加成功",1L,null);
        }
    }

    private <T> NormalMsg getNormalMsg(PageInfo<T> orders) {
        NormalMsg msg;
        if(orders == null){
            msg = new NormalMsg(-1,"查询失败",0L, null);
        }else{
            msg = new NormalMsg(0, "查询成功",orders.getTotal(), orders.getList());
        }
        System.out.println(msg);
        return msg;
    }
}
