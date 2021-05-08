package cdu.tuogen.ServiceTest;


import cdu.tuogen.pojo.Goods;
import cdu.tuogen.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class GoodsServiceTest {
    Logger log = LoggerFactory.getLogger(GoodsServiceTest.class);

    @Autowired
    private GoodsService goodsService;

    @Test
    public void test(){
        List<Goods> goodsList = goodsService.queryGoods();
        System.out.println(goodsList);
    }


}
