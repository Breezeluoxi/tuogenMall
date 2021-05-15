package cdu.tuogen.utilTest;

import cdu.tuogen.mapper.OrdersMapper;
import cdu.tuogen.mapper.UserMapper;
import cdu.tuogen.pojo.OrderInfoUser;
import cdu.tuogen.pojo.User;
import cdu.tuogen.utils.BreezeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @date : 2021/5/14
 * @name : cdu.tuogen.utilTest.BreezeTest
 * @Author: breezeluoxi
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class BreezeTest {

    @Autowired
    private BreezeUtil breezeUtil;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void test(){
        List<OrderInfoUser> orderForUser = breezeUtil.getOrderForUser(ordersMapper.queryUserOrderListByUserIds(12), userMapper.queryUser(new User(1)));
        System.out.println(orderForUser);
    }
}
