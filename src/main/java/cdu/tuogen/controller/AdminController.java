/**
 * @date : 2021/5/2
 * @name : tuogenMall_cdu.tuogen.controller_AdminController
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
import cdu.tuogen.service.AdminService;
import cdu.tuogen.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@RequestMapping("/admin")
public class AdminController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;

    @RequestMapping("/login")
    public LoginMsg<Admin> queryUsers(String username, String password, HttpServletRequest request) throws Exception {
        Admin admin = adminService.queryAdmin(new Admin(username,password));
        HttpSession session = request.getSession();
        LoginMsg<Admin> msg;
        if (admin == null){
            throw  new Exception("登录失败");
        }else{
            session.setAttribute("user", admin);
            msg = new LoginMsg(1, "登录成功");
        }
        return msg;
    }

    @RequestMapping("/admins")
    public NormalMsg<Admin> queryAdmins() throws Exception {
        List<Admin> admins = adminService.queryAdmins();
        int size = admins.size();
        NormalMsg msg;
        if (admins == null) {
            msg = new NormalMsg(-1, "查询失败", 0L, null);

        } else {
            msg = new NormalMsg(0, "查询成功", (long) size, admins);
        }
        return msg;
    }

    @RequestMapping("/admin_modify")
    public LoginMsg<Admin> modifyAdmins(Admin admin, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        System.out.println(admin);
        Admin admin1 = adminService.queryAdmin(new Admin(admin.getAdminId()));
        admin1.setAdminLevel(admin.getAdminLevel());
        adminService.updateAdmin(admin);
        System.out.println(admin);
        LoginMsg<Admin> msg;
        if (admin1 == null) {
            throw new Exception("修改失败");
        } else {
            session.setAttribute("admin", admin);
            msg = new LoginMsg(1, "修改成功");
        }
        return msg;
    }

}
