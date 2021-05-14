/**
 * *   Description:
 * *   @File     :GlobalExceptionHandler.py
 * *   @Author   :王炜 IAmTrying
 * *   @QQ       :690622472
 * *   @Time     :5/12/2021 22:56
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

import cdu.tuogen.bean.wei.MyException;
import cdu.tuogen.bean.wei.Tmpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String globalExceptionHandler(Exception e, Model model){
        MyException myException;
        if (e instanceof MyException){
            myException=(MyException) e;
        } else {
            myException=MyException.getTmpl(Tmpl.GENERAL_ERROR);
            myException.setDescription(e.getMessage());
        }
        model.addAttribute("myException", myException);
        return "/WEB-INF/view/exception.jsp";
    }
}

