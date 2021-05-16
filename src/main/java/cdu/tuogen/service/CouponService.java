/**
 * *   Description:
 * *   @File     :CouponService.py
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
package cdu.tuogen.service;

import cdu.tuogen.pojo.Coupon;

import java.util.List;

public interface CouponService {
    Coupon get(int couponId);
    List<Coupon> getAll();
    int add(Coupon coupon);
    int mod(Coupon coupon);
    Coupon del(int couponId);
}
