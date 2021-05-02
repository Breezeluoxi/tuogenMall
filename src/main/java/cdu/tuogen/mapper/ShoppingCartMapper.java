package cdu.tuogen.mapper;

import cdu.tuogen.pojo.ShoppingCart;
import cdu.tuogen.pojo.User;

import java.util.List;

/**
 * @date : 2021/5/1
 * @name : tuogenMall_cdu.tuogen.mapper_shoppingCartMapper
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
 * <p>购物车相关Mapper</p>
 */


public interface ShoppingCartMapper {

    /**
     * 根据用户ID查询购物车
     * @param user 用户
     * @return
     */
    List<ShoppingCart> queryShoppingCart(User user);

    /**
     * 插入一条购物车
     * @param shoppingCart  购物车
     * @return
     */
    Integer insertShoppingCart(ShoppingCart shoppingCart);

    /**
     * 删除一条购物车记录
     * @param shoppingCart
     * @return
     */
    Integer deleteShoppingCart(ShoppingCart shoppingCart);
}
