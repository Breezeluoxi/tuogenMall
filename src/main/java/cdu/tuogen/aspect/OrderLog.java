package cdu.tuogen.aspect;

import cdu.tuogen.bean.NormalMsg;
import cdu.tuogen.bean.wei.MyMsg;
import cdu.tuogen.controller.OrderController;
import cdu.tuogen.pojo.Admin;
import cdu.tuogen.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @date : 2021/5/18
 * @name : cdu.tuogen.aspect.OrderLog
 * @Author: breezeluoxi
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

@Component
public class OrderLog extends ALogAspect{

    @Override
    Class getProxyClass() {
        return OrderController.class;
    }

    @Override
    String outLogPath() {
        return "/log/orderLog.txt";
    }

    /**
     * 添加一条优惠券
     */
    String addOrder(Msg msg) {
        NormalMsg returning = (NormalMsg) msg.returning;
        HttpSession session = msg.session;
        Object user = session.getAttribute("user");
        if (user == null){
            return "未登录的非法操作";
        }
        String name= user instanceof User?((User) user).getUserName():((Admin)user).getAdminName();
        String message =returning.getMessage();
        String success = "添加成功";
        String fail = "添加失败";
        if(success.equals(message)){
            return name+"成功添加一条订单";
        }else if(fail.equals(message)){
            return name+"添加订单失败";
        }
        return null;
    }

    String updateOrder(Msg msg) {
        NormalMsg returning = (NormalMsg) msg.returning;
        HttpSession session = msg.session;
        Object user = session.getAttribute("user");
        if (user == null){
            return "未登录的非法操作";
        }
        String name= user instanceof User?((User) user).getUserName():((Admin)user).getAdminName();
        String message =returning.getMessage();
        String success = "更新成功";
        String fail = "没有此订单";
        if(success.equals(message)){
            return name+"成功更新订单";
        }else if(fail.equals(message)){
            return name+"更新订单失败";
        }
        return null;
    }
}
