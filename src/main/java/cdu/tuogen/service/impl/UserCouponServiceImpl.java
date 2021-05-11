/**
 * *   Description:
 * *   @File     :UserCouponImpl.py
 * *   @Author   :王炜 IAmTrying
 * *   @QQ       :690622472
 * *   @Time     :5/8/2021 21:47
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

import cdu.tuogen.mapper.UserCouponMapper;
import cdu.tuogen.pojo.UserCoupon;
import cdu.tuogen.service.UserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCouponServiceImpl implements UserCouponService {
    @Autowired
    UserCouponMapper userCouponMapper;

    @Override
    public UserCoupon get(int userCouponId) {
        return userCouponMapper.get(userCouponId);
    }

    @Override
    public List<UserCoupon> getAll(int userId) {
        return userCouponMapper.getAll(userId);
    }

    @Override
    public int add(UserCoupon userCoupon) {
        return userCouponMapper.add(userCoupon);
    }

    @Override
    public int mod(UserCoupon userCoupon) {
        return userCouponMapper.mod(userCoupon);
    }

    @Override
    public UserCoupon del(int userCouponId) {
        UserCoupon userCoupon = userCouponMapper.get(userCouponId);
        if (userCoupon!=null) {
            int del = userCouponMapper.del(userCouponId);
            if (del!=0) return userCoupon;
        }
        return null;
    }


}
