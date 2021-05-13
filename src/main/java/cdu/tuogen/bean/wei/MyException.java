/**
 * *   Description:
 * *   @File     :MyException.py
 * *   @Author   :王炜 IAmTrying
 * *   @QQ       :690622472
 * *   @Time     :5/13/2021 12:15
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
import org.springframework.validation.BindingResult;

public class MyException extends Exception {
    //错误信息
    private String error="";
    //错误描述
    private String description="";
    //连接名
    private String aText="";
    //连接url
    private String aHref="";

    @Override
    public String getMessage() {
        return description;
    }

    /**
     * 获得异常模板
     *
     * @return MyException 异常模板
     */
    public static MyException getTmpl(Tmpl tmpl) {
        return tmpl.getTmpl();
    }

    /**
     * 自动解析BindingResult
     *
     * @param result
     * @return MyException
     */
    public static MyException getTmplAndParsing(Tmpl tmpl,BindingResult result) {
        String message = result.getFieldErrors().stream().
                map((fieldError -> (fieldError.isBindingFailure()
                        ? fieldError.getField() + "格式错误"
                        : fieldError.getDefaultMessage()) + "   "))
                .reduce("", (a, b) -> a + b);
        return tmpl.getTmpl().setDescription(message);
    }


    public MyException() {
    }

    public MyException(String error) {
        this.error = error;
    }

    public MyException(String error, String aText, String aHref) {
        this.error = error;
        this.aText = aText;
        this.aHref = aHref;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "title='" + error + '\'' +
                ", error='" + description + '\'' +
                ", linkName='" + aText + '\'' +
                ", link='" + aHref + '\'' +
                '}';
    }

    public String getError() {
        return error;
    }

    public MyException setError(String error) {
        this.error = error;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MyException setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getaText() {
        return aText;
    }

    public MyException setaText(String aText) {
        this.aText = aText;
        return this;
    }

    public String getaHref() {
        return aHref;
    }

    public MyException setaHref(String aHref) {
        this.aHref = aHref;
        return this;
    }
}


