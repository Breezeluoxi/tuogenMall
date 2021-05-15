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
import cdu.tuogen.pojo.Admin;
import cdu.tuogen.pojo.OrderInfo;
import cdu.tuogen.pojo.OrderInfoUser;
import cdu.tuogen.pojo.User;
import cdu.tuogen.service.OrderService;
import cdu.tuogen.service.UserService;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @GetMapping("/orders")
    public NormalMsg queryOrders(int page, int limit,HttpServletRequest request){
        PageInfo<OrderInfo> orders = orderService.queryOrders(new Page(page, limit));
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
