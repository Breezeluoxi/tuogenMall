package cdu.tuogen.mapperTest;

import cdu.tuogen.mapper.AdminMapper;
import cdu.tuogen.pojo.Admin;
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

/**
 * @date : 2021/5/1
 * @name : tuogenMall_cdu.tuogen.mapperTest_AdminTest
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

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/spring-*.xml")
public class AdminTest {
    Logger log = LoggerFactory.getLogger(AdminTest.class);

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void AdminMapperQueryAdmin(){
        Admin admin = adminMapper.queryAdmin(new Admin("123456","breeze"));
        log.error(admin.toString());
    }

    @Test
    public void AdminMapperInsertAdmin(){
        Integer integer = adminMapper.insertAdmin(Arrays.asList(
                new Admin((int)System.currentTimeMillis(), "123456", "2", "tuogen_elect", "张三",""),
                new Admin((int)System.currentTimeMillis()+1, "123456", "2", "tuogen_car", "李四",""),
                new Admin((int)System.currentTimeMillis()+2, "123456", "2", "tuogen_furn", "王五","")
        ));
        log.error("操作数 = " + integer);
    }

    @Test
    public void AdminMapperDeleteAdmin(){
        adminMapper.deleteAdmin(Arrays.asList(676955919,676955912));
    }

    @Test
    public void AdminMapperUpdateAdmin(){
        adminMapper.updateAdmin(new Admin(713163288,"pujinmin3344","1","4518482458","洛溪",""));
    }

    @Test
    public void AdminMapperQueryAdminById(){
        Admin admin = adminMapper.queryAdminById(1);
        log.error(admin.toString());
    }

    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1,4,6);
        //System.out.println(String.join("_",s));
    }
}
