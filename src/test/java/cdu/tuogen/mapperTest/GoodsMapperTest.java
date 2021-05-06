package cdu.tuogen.mapperTest;


import cdu.tuogen.mapper.GoodsMapper;
import cdu.tuogen.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class GoodsMapperTest {
    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void test(){

        List<Goods> goodsList = goodsMapper.queryGoods();
        System.out.println(goodsList);
    }
}
