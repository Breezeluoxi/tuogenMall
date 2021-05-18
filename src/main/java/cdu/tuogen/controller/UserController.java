/**
 * @date : 2021/5/2
 * @name : tuogenMall_cdu.tuogen.controller_UserController
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
import cdu.tuogen.pojo.Admin;
import cdu.tuogen.pojo.User;
import cdu.tuogen.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@RequestMapping("/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping("/login")
    public LoginMsg<User> queryUsers(String username, String password, HttpServletRequest request) throws Exception {
        User user = userService.queryUser(new User(username, password));
        HttpSession session = request.getSession();
        LoginMsg<User> msg;
        if (user == null) {
            throw new Exception("登录失败");
        } else {
            session.setAttribute("user", user);
            msg = new LoginMsg(1, "登录成功");
        }
        return msg;
    }

    @RequestMapping("/add")
    public LoginMsg<User> addUsers(User user, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        System.out.println(user);
        user.setUserId(null);
        userService.insertUser(Arrays.asList(user));
        LoginMsg<User> msg;
        if (user == null) {
            throw new Exception("添加失败");
        } else {
            session.setAttribute("user", user);
            msg = new LoginMsg(1, "添加成功");
        }
        return msg;
    }

    @RequestMapping("/list")
    public NormalMsg queryUsers() throws Exception {
        List<User> users = userService.queryUsers();
        int size = users.size();
        NormalMsg msg;
        if (users == null) {
            msg = new NormalMsg(-1, "查询失败", 0L, null);

        } else {
            msg = new NormalMsg(0, "查询成功", (long) size, users);
        }
        return msg;

    }

    @RequestMapping("/modify")
    public LoginMsg<User> modifyUsers(User user, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        User user1 = userService.queryUser(new User(user.getUserId()));
        user1.setUserPassword(user.getUserPassword());
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setUserPhone(user.getUserPhone());
        user1.setUserAddress(user.getUserAddress());
        user1.setUserVipLevel(user.getUserVipLevel());
        userService.updateUser(user);
        System.out.println(user);
        LoginMsg<User> msg;
        if (user1 == null) {
            throw new Exception("修改失败");
        } else {
            session.setAttribute("user", user);
            msg = new LoginMsg(1, "修改成功");
        }
        return msg;
    }

    @GetMapping("/user/del")
    public String deleteUser(Integer id){
        Integer integer = userService.deleteUser(Arrays.asList(id));
        return "ok";
    }

    @RequestMapping("/info")
    public Admin userInfo(HttpServletRequest request){
        return (Admin)request.getSession().getAttribute("user");
    }
}
