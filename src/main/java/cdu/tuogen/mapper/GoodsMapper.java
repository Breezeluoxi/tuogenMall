package cdu.tuogen.mapper;

import cdu.tuogen.pojo.Admin;
import cdu.tuogen.pojo.Goods;
import cdu.tuogen.pojo.GoodsAll;

import java.util.List;


public interface GoodsMapper {
    /**
     * 类型条件查询
     * @param goodShopId
     * @param goodTypeId
     * @param goodSaleType
     * @return
     */
    List<GoodsAll> queryGoodsAllType(int goodShopId,int goodTypeId,String goodSaleType);
    /**
     *  查询店铺id下所有商品
     * @return
     */
    List<GoodsAll> queryGoodsAll(int goodShopId);
    /**
     *  查询所有商品
     * @return
     */
    List<Goods> queryGoods();
    /**
     * 通过Id 查询商品
     * @return goodId
     */
    Goods queryGoodsById(int goodId);

    /**
     * 通过shop_id 查询商品
     * @return
     */
    Goods queryGoodsByShopId();

    /**
     * 通过AdminId 查询商品
     * @param admin
     * @param <T> T extends Admin
     * @return
     */
    <T extends Admin> List<Goods> queryGoodsByAdminId(T admin);

    /**
     * 插入商品
     * @param goods
     * @return
     */
    Integer insertGoods(Goods goods);

    /**
     * 更新商品
     * @param goods
     * @return
     */
    Integer updateGoods(Goods goods);
    /**
     * 更新商品库存
     * @param
     * @return
     */
    Integer updateGoodsWare(int goodsId, int goodsNum);

    /**
     * 删除商品集合
     * @param goodId
     * @return
     */
    Integer deleteGoods(int goodId);

    /**
     * 差
     * @param typeId
     * @return
     */
    List<Goods> queryGoodsListByTypeId(int typeId);
}