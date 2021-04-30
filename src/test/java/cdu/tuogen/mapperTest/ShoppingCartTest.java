/**
 * @date : 2021/5/1
 * @name : tuogenMall_cdu.tuogen.test_ShoppingCartTest
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

package cdu.tuogen.mapperTest;

import cdu.tuogen.mapper.OrdersMapper;
import cdu.tuogen.mapper.ShoppingCartMapper;
import cdu.tuogen.pojo.ShoppingCart;
import cdu.tuogen.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class ShoppingCartTest {
    Logger log = LoggerFactory.getLogger(ShoppingCartMapper.class);

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Test
    public void cartMapperInsertCart(){
        shoppingCartMapper.insertShoppingCart(new ShoppingCart(1, Arrays.asList(4,5,6)));
    }

    @Test
    public void cartMapperQueryCart(){
        List<ShoppingCart> carts = shoppingCartMapper.queryShoppingCart(new User(1));
        log.error(carts.toString());
    }

    @Test
    public void cartMapperDeleteCart(){
        shoppingCartMapper.deleteShoppingCart(new ShoppingCart(1,Arrays.asList(4)));
    }



}
