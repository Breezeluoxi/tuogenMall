package cdu.tuogen.service.impl;

import cdu.tuogen.pojo.GoodsAll;
import cdu.tuogen.utils.Constants;
import cdu.tuogen.mapper.GoodsMapper;
import cdu.tuogen.pojo.Goods;
import cdu.tuogen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsAll> queryGoodsAllType(int goodShopId, int goodTypeId, String goodSaleType) {
        List<GoodsAll> goodsAllList = goodsMapper.queryGoodsAllType(goodShopId, goodTypeId, goodSaleType);
        return goodsAllList;
    }

    @Override
    public List<GoodsAll> queryGoodsAll(int goodShopId) {
        List<GoodsAll> goodsAllList = goodsMapper.queryGoodsAll(goodShopId);
        return goodsAllList;
    }

    @Override
    public List<Goods> queryGoods() {
        List<Goods> goodsList = goodsMapper.queryGoods();
//        System.out.println("service测试");
//        System.out.println(goodsList);
        return goodsList;
    }

    @Override
    public Goods queryGoodsById(int goodId) {

        return goodsMapper.queryGoodsById(goodId);
    }

    @Override
    public Goods queryGoodsByShopId() {
        return null;
    }

    @Override
    public boolean insertGoods(Goods goods, MultipartFile file) {

        // 持久化 user
        return goodsMapper.insertGoods(goods) > 0;
//   return  goodsMapper.insertGoods(goods) == 1 ? true : false;
    }

    @Override
    public boolean updateGoods(Goods goods, MultipartFile file) {
        return  goodsMapper.updateGoods(goods) == 1 ? true : false;
    }

    @Override
    public boolean deleteGoods(int goodId) {

        return  goodsMapper.deleteGoods(goodId) == 1 ? true : false;
    }
}
