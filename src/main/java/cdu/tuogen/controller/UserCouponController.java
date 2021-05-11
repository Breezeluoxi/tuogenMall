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
import cdu.tuogen.bean.CouponMsg;
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
    public CouponMsg get(@PathVariable("userId") int userId){
        List<UserCoupon> all = userCouponService.getAll(userId);
        return all.size()!=0?CouponMsg.SUCCESS.addDetail("userCoupons",all):CouponMsg.FAILED.addDescription("no coupon");
    }

    //增加用户优惠卷
    @PostMapping()
    public CouponMsg add(@Valid UserCoupon userCoupon, BindingResult result){
        result.getFieldErrors().forEach((error)->CouponMsg.FAILED.addDetail(error.getField()+"Error",error.getDefaultMessage()));
        return userCouponService.add(userCoupon)!=0?CouponMsg.SUCCESS:CouponMsg.FAILED;
    }

    //修改用户优惠卷
    @PutMapping()
    public CouponMsg mod(UserCoupon userCoupon){
        return userCouponService.mod(userCoupon)!=0?CouponMsg.SUCCESS:CouponMsg.FAILED;
    }

    //删除用户优惠卷
    @DeleteMapping()
    public CouponMsg del(@RequestParam("id") int userCouponId){
        UserCoupon del = userCouponService.del(userCouponId);
        return del!=null?CouponMsg.SUCCESS.addDetail("deleted_user_coupon",del):CouponMsg.FAILED.addDescription("no user coupon");
    }
}