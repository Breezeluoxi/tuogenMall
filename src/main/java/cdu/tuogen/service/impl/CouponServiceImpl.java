/**
 * *   Description:
 * *   @File     :CouponServiceImpl.py
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

package cdu.tuogen.service.impl;

import cdu.tuogen.mapper.CouponMapper;
import cdu.tuogen.pojo.Coupon;
import cdu.tuogen.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    CouponMapper couponMapper;

    @Override
    public Coupon get(int couponId) {
        return couponMapper.get(couponId);
    }

    @Override
    public List<Coupon> getAll() { return couponMapper.getAll();}

    @Override
    public int add(Coupon coupon) {
        return couponMapper.add(coupon);
    }

    @Override
    public int mod(Coupon coupon) {
        return couponMapper.mod(coupon);
    }

    @Override
    public Coupon del(int couponId) {
        Coupon coupon=couponMapper.get(couponId);
        if (coupon!=null) {
            int del = couponMapper.del(couponId);
            if (del!=0)return coupon;
        }
        return null;
    }
}
