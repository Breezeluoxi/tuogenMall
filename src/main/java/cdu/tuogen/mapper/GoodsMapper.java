package cdu.tuogen.mapper;

import cdu.tuogen.pojo.Admin;
import cdu.tuogen.pojo.Goods;

import java.util.List;

/**
 * @date : 2021/5/3
 * @name : tuogenMall_cdu.tuogen.mapper_OrderGoodsMapper
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


public interface GoodsMapper {
    /**
     * 通过Id 查询商品
     * @return
     */
    Goods queryGoodsById();

    /**
     * 通过AdminId 查询商品
     * @param admin
     * @param <T> T extends Admin
     * @return
     */
    <T extends Admin> List<Goods> queryGoodsByAdminId(T admin);

    /**
     * 插入商品
     * @param goodsList
     * @return
     */
    Integer insertGoods(List<Goods> goodsList);

    /**
     * 更新商品
     * @param goods
     * @return
     */
    Integer updateGoods(Goods goods);

    /**
     * 删除商品集合
     * @param goodsIds
     * @return
     */
    Integer deleteGoods(List<Integer> goodsIds);
}
