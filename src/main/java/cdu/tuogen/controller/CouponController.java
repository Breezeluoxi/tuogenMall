/**
 * *   Description:
 * *   @File     :CouponController.py
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
import cdu.tuogen.pojo.Coupon;
import cdu.tuogen.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
//@Validated
@RestController
@RequestMapping(value = "/coupon")//,produces = {"application/json;charset=UTF-8"}
public class CouponController {

    @Autowired
    private CouponService couponService;
    //查询
    @GetMapping("{id}")
    public CouponMsg get(@PathVariable("id")int id){
        Coupon coupon = couponService.get(id);
        return coupon!=null?CouponMsg.SUCCESS.addDetail("coupon",coupon): CouponMsg.FAILED.addDescription("no coupon");
    }
    //添加
    @PostMapping
    public CouponMsg add(@Valid Coupon coupon, BindingResult result){
        result.getFieldErrors().forEach((error)->CouponMsg.ADD_FAILED.addDetail(error.getField()+"Error",error.getDefaultMessage()));
        return result.hasErrors()?CouponMsg.ADD_FAILED:couponService.add(coupon)!=0? CouponMsg.SUCCESS: CouponMsg.ADD_FAILED;
    }
    //修改
    @PutMapping
    public CouponMsg mod(Coupon coupon){
        return couponService.mod(coupon)!=0? CouponMsg.SUCCESS: CouponMsg.MOD_FAILED;
    }
    //删除
    @DeleteMapping()
    public CouponMsg del(int id){
        return couponService.del(id)!=null? CouponMsg.SUCCESS: CouponMsg.DEL_FAILED;
    }

}



