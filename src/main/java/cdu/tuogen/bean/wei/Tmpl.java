/**
 * *   Description:
 * *   @File     :Tmpl.py
 * *   @Author   :王炜 IAmTrying
 * *   @QQ       :690622472
 * *   @Time     :5/13/2021 21:48
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

package cdu.tuogen.bean.wei;

public enum Tmpl{
    /**
     *  通用异常模板
     */
    GENERAL_ERROR("王大哥提示你异常啦", "返回", "javascript:history.go(-1);"),
    /**
     * 注册异常模板
     */
    REGISTER_ERROR("注册失败","确定","/register"),
    /**
     * 登录异常模板
     */
    LOGIN_ERROR("登录失败","返回","javascript:history.go(-1);"),
    ;

    private MyException tmpl;
    Tmpl(MyException tmpl){
        this.tmpl=tmpl;
    }
    Tmpl(String error, String aText, String aHref){
        this.tmpl=new MyException(error,aText,aHref);
    }

    public MyException getTmpl() {
        return tmpl;
    }
}
