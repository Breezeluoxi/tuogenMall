package cdu.tuogen.aspect;

import cdu.tuogen.bean.LoginMsg;
import cdu.tuogen.bean.NormalMsg;
import cdu.tuogen.controller.AdminController;
import cdu.tuogen.controller.OrderController;
import cdu.tuogen.pojo.Admin;
import cdu.tuogen.pojo.User;
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
public class AdminLog extends ALogAspect{

    @Override
    Class getProxyClass() {
        return AdminController.class;
    }

    @Override
    String outLogPath() {
        return "/log/userLog.txt";
    }

    /**
     * 添加一条优惠券
     */
    String login(Msg msg) {
        LoginMsg returning = (LoginMsg) msg.returning;
        HttpSession session = msg.session;
        Object user = session.getAttribute("user");
        if (user == null){
            return "未登录的非法操作";
        }
        String name= user instanceof User?((User) user).getUserName():((Admin)user).getAdminName();
        String message =returning.getMessage();
        String success = "登录成功";
        String fail = "登录失败";
        if(success.equals(message)){
            return name+"商家登录成功";
        }else if(fail.equals(message)){
            return "商家登录失败";
        }
        return null;
    }
}
