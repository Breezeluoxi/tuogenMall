package cdu.tuogen.service;

import cdu.tuogen.pojo.Goods;
import cdu.tuogen.pojo.GoodsAll;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodsService {
    /**
     *  类型条件查询
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
     * 插入商品
     * @param goods
     * @return
     */
    boolean insertGoods(Goods goods, MultipartFile file);

    /**
     * 更新商品
     * @param goods
     * @return
     */
    boolean updateGoods(Goods goods, MultipartFile file);
    /**
     * 更新商品库存
     * @param
     * @return
     */
    boolean updateGoodsWare(int goodsId, int goodsNum);

    /**
     * 删除商品集合
     * @param goodId
     * @return
     */
    boolean deleteGoods(int goodId);

    /**
     * 查询
     * @param typeId
     * @return
     */
    List<Goods> queryGoodsListByTypeId(int typeId);
}
