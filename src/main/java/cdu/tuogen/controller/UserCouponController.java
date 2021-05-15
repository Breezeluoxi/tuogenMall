/**
 * *   Description:
 * *   @File     :UserCouponController.py
 * *   @Author   :王炜 IAmTrying
 * *   @QQ       :690622472
 * *   @Time     :5/8/2021 17:03
 * *   =================================================
 * *             ┌─┐       ┌─┐ + +
 * *          ┌──┘ ┴───────┘ ┴──┐++
 * *          │                 │
 * *          │       ───       │++ + + +
 * *          ███████───███████ │+
 * *          │                 │+
 * *          │       ─┴─       │
 * *          │                 │
 * *          └───┐         ┌───┘
 * *              │         │
 * *              │         │   + +
 * *              │         │
 * *              │         └──────────────┐
 * *              │                        │
 * *              │                        ├─┐
 * *              │                        ┌─┘
 * *              │                        │
 * *              └─┐  ┐  ┌───────┬──┐  ┌──┘  + + + +
 * *                │ ─┤ ─┤       │ ─┤ ─┤
 * *                └──┴──┘       └──┴──┘  + + + +
 * *                       神兽保佑
 * *                      代码无BUG!
 * *   ==================================================
 **/
package cdu.tuogen.controller;
import cdu.tuogen.bean.wei.MyMsg;
import cdu.tuogen.pojo.UserCoupon;
import cdu.tuogen.service.UserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/userCoupon")
@RestController
public class UserCouponController {
    @Autowired
    UserCouponService userCouponService;
    //查询用户所有优惠卷
    @GetMapping("{userId}")
    public MyMsg get(@PathVariable("userId") int userId){
        List<UserCoupon> all = userCouponService.getAll(userId);
        return all.size()!=0? MyMsg.SUCCESS.addDetail("userCoupons",all): MyMsg.FAILED.addDescription("no coupon");
    }

    //增加用户优惠卷
    @PostMapping()
    public MyMsg add(@Valid UserCoupon userCoupon, BindingResult result){
        result.getFieldErrors().forEach((error)-> MyMsg.ADD_FAILED.addDetail(error.getField()+"Error",error.getDefaultMessage()));
        return result.hasErrors()? MyMsg.ADD_FAILED:userCouponService.add(userCoupon)!=0? MyMsg.SUCCESS: MyMsg.FAILED;
    }

    //修改用户优惠卷
    @PutMapping()
    public MyMsg mod(UserCoupon userCoupon){
        return userCouponService.mod(userCoupon)!=0? MyMsg.SUCCESS: MyMsg.MOD_FAILED;
    }

    //删除用户优惠卷
    @DeleteMapping()
    public MyMsg del(@RequestParam("id") int userCouponId){
        UserCoupon del = userCouponService.del(userCouponId);
        return del!=null? MyMsg.SUCCESS.addDetail("deleted_user_coupon",del): MyMsg.DEL_FAILED.addDescription("no user coupon");
    }
}