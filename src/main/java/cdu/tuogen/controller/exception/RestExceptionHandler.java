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

import cdu.tuogen.bean.wei.MyMsg;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice(annotations = {RestController.class})
public class RestExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public MyMsg argumentMismatch(Exception e) { return MyMsg.Argument_Mismatch; }

    @ExceptionHandler(value = {Exception.class})
    public MyMsg allException(Exception e) { return MyMsg.FAILED.addDescription(e.getMessage()); }

    @ModelAttribute
    public void clear() { MyMsg.clearDetail(); }

}
