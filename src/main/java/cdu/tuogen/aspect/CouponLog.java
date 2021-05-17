/**
 * *   Description:
 * *   @File     :CouponLog.py
 * *   @Author   :王炜 IAmTrying
 * *   @QQ       :690622472
 * *   @Time     :5/17/2021 15:18
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

package cdu.tuogen.aspect;

import cdu.tuogen.bean.wei.MyMsg;
import cdu.tuogen.controller.CouponController;
import cdu.tuogen.pojo.Coupon;
import org.springframework.stereotype.Component;

/**
 * coupon日志类
 */
@Component
public class CouponLog extends ALogAspect {
    @Override
    Class getProxyClass() {
        //代理类
        return CouponController.class;
    }

    @Override
    String outLogPath() {
        //指定输出路径
        return "/log/coupon.txt";
    }

    //记录添加成功
    String add(Msg msg) {
        MyMsg returning = (MyMsg) msg.returning;
        if (returning.getMessage().contains("success")&&!returning.getDetail().isEmpty()){
            return "添加了一张优惠卷="+returning.getDetail();
        }
        return null;
    }

    String mod(Msg msg) {
        MyMsg returning = (MyMsg) msg.returning;
        if (returning.getMessage().contains("success")){
            return "修改了一张优惠卷="+returning.getDetail();
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
