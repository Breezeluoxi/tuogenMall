/**
 * *   Description:
 * *   @File     :CouponExceptionHandler.py
 * *   @Author   :王炜 IAmTrying
 * *   @QQ       :690622472
 * *   @Time     :5/9/2021 12:37
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

package cdu.tuogen.controller.exception;

import cdu.tuogen.bean.CouponMsg;
import cdu.tuogen.controller.CouponController;
import cdu.tuogen.controller.UserCouponController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice(assignableTypes = {CouponController.class, UserCouponController.class})//
public class CouponExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public CouponMsg argumentMismatch(Exception e) { return CouponMsg.Argument_Mismatch; }

    @ExceptionHandler(value = {Exception.class})
    public CouponMsg allException(Exception e) { return CouponMsg.FAILED.addDescription(e.getMessage()); }

    @ModelAttribute
    public void clear() { CouponMsg.clearDetail(); }

}
