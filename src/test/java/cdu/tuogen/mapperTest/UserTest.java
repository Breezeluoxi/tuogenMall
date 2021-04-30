/**
 * @date : 2021/5/1
 * @name : tuogenMall_cdu.tuogen.test_OrderTest
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

import cdu.tuogen.mapper.UserMapper;
import cdu.tuogen.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class UserTest {

    Logger log = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void UserMapperQuery(){
        User user = userMapper.queryUser(new User(1));
        User user1 = userMapper.queryUser(new User("李四","123456"));
        log.error(user1.toString());
    }

    @Test
    public void UserMapperInsertUser(){
        userMapper.insertUser(Arrays.asList(
                new User(null,"123456","1","李四",(short)89,"13551647145","广元"),
                new User(null,"123456","1","王五",(short)89,"13551647145","广元范德萨发"),
                new User(null,"123456","1","阿斯顿",(short)89,"13551647145","广元阿斯顿")
        ));
    }

    @Test
    public void UserMapperDeleteUser(){
        userMapper.deleteUser(Arrays.asList(2,3));
    }

    @Test
    public void updateUser(){
        userMapper.updateUser(new User(4,"123456","1","l洛溪",(short)89,"548484845","撒旦"));
    }

    @Test
    public void UserMapperQueryUserById(){
        User queryUserById = userMapper.queryUserById(8);
        log.error(queryUserById.toString());

    }
}
