package cdu.tuogen.mapper;

import cdu.tuogen.pojo.Admin;
import cdu.tuogen.pojo.User;

import java.util.List;

/**
 * @date : 2021/5/1
 * @name : tuogenMall_cdu.tuogen.mapper_UserMapper
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
 * <p>买家相关Mapper </p>
 */


public interface UserMapper{
    /**
     * 查寻用户详情
     * @param user
     * @return
     */
    User queryUser(User user);
    /**
     * 通过Id查询用户
     * @param userId
     * @return
     */
    User queryUserById(Integer userId);
    /**
     * 增加用户List
     * @param users user集合
     * @return
     */
    Integer insertUser(List<User> users);

    /**
     * 删除用户
     * @param id id 集合
     * @return
     */
    Integer deleteUser(List<Integer> id);

    /**
     * 更新用户
     * @param user 新用户信息
     * @return
     */
    Integer updateUser(User user);
}
