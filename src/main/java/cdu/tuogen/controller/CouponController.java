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
import cdu.tuogen.bean.wei.MyMsg;
import cdu.tuogen.pojo.Coupon;
import cdu.tuogen.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/coupon")//,produces = {"application/json;charset=UTF-8"}
public class CouponController {

    @Autowired
    private CouponService couponService;
    //查询
    @GetMapping("{id}")
    public MyMsg get(@PathVariable("id")int id){
        Coupon coupon = couponService.get(id);
        return coupon!=null? MyMsg.SUCCESS.addDetail("coupon",coupon): MyMsg.FAILED.addDescription("no coupon");
    }
    //添加
    @PostMapping
    public MyMsg add(@Valid Coupon coupon, BindingResult result){
        result.getFieldErrors().forEach((error)-> MyMsg.ADD_FAILED.addDetail(error.getField()+"Error",error.getDefaultMessage()));
        return result.hasErrors()? MyMsg.ADD_FAILED:couponService.add(coupon)!=0? MyMsg.SUCCESS.addDetail("coupon",coupon): MyMsg.ADD_FAILED;
    }
    //修改
    @PutMapping
    public MyMsg mod(Coupon coupon){
        return couponService.mod(coupon)!=0? MyMsg.SUCCESS.addDetail("coupon",coupon): MyMsg.MOD_FAILED;
    }
    //删除
    @DeleteMapping()
    public MyMsg del(int id){
        return couponService.del(id)!=null? MyMsg.SUCCESS: MyMsg.DEL_FAILED;
    }

    //查询所有
    @GetMapping()
    public MyMsg get_all(Model model){
        return MyMsg.SUCCESS.addDetail("coupons",couponService.getAll());
    }
}



