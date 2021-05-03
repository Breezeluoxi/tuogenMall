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

import cdu.tuogen.bean.LoginMsg;
import cdu.tuogen.bean.NormalMsg;
import cdu.tuogen.bean.Page;
import cdu.tuogen.pojo.Order;
import cdu.tuogen.pojo.PrentOrder;
import cdu.tuogen.service.OrderService;
import cdu.tuogen.service.UserService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;

    @GetMapping("/orders")
    public NormalMsg queryOrders(int page, int limit){
        PageInfo<PrentOrder> orders = orderService.queryOrders(new Page(page, limit));
        NormalMsg msg;
        if(orders == null){
            log.error("查询失败");
            msg = new NormalMsg(-1,"查询失败",0L, null);
        }else{
            log.error("查询成功");
            msg = new NormalMsg(0, "查询成功",orders.getTotal(), orders.getList());
        }
        return msg;
    }

}
