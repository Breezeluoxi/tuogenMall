package cdu.tuogen.mapper;

import cdu.tuogen.pojo.Admin;
import cdu.tuogen.pojo.User;

import java.util.List;

/**
 * @date : 2021/5/1
 * @name : tuogenMall_cdu.tuogen.mapper_AdminMapper
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
 * <p>商家管理员相关Mapper</p>
 */


public interface AdminMapper {
    /**
     * 查询用户
     * @param admin
     * @return
     */
    Admin queryAdmin(Admin admin);

    /**
     * 插入Admin
     * @param admins
     * @return
     */
    Integer insertAdmin(List<Admin> admins);

    /**
     * 删除用户
     * @param ids
     * @return
     */
    Integer deleteAdmin(List<Integer> ids);

    /**
     * 更新用户
     * @param admin
     * @return
     */
    Integer updateAdmin(Admin admin);
}
