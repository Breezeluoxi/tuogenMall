/**
 * *   Description:
 * *   @File     :CouponCode.py
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
package cdu.tuogen.bean.wei;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public enum MyMsg {
    /**
     * 操作成功、失败
     */
    SUCCESS("success",true), FAILED("failed"),
    /**
     * 删除失败、修改失败、增加失败
     */
    DEL_FAILED("no such a coupon"),
    MOD_FAILED("modify coupon failed"),
    ADD_FAILED("add coupon failed"),
    /**
     * 参数无法成功匹配
     */
    Argument_Mismatch("method argument type mismatch exception"),;

    //状态码
    private int code;
    //状态
    private boolean successStatus;
    //信息描述
    private String message;
    //存放额外信息
    private static Map<Object,Object> detail = new HashMap<>();

    MyMsg(String message) {
        this.message=message;
        this.code=Util.CODE++;
        this.successStatus=false;
    }
    MyMsg(String message, boolean successStatus) {
        this.message=message;
        this.code=Util.CODE++;
        this.successStatus=successStatus;
    }

    /**
     * 清空detail
     */
    public static void clearDetail() {
        detail.clear();
    }
    public static MyMsg clearDetail(MyMsg code) {
        clearDetail();
        return code;
    }

    /**
     * 增加详情
     * @param key
     * @param value
     * @return
     */
    public MyMsg addDetail(Object key, Object value){
        detail.put(key,value);
        return this;
    }
    public static MyMsg addDetail(Object key, Object value, MyMsg code){
        detail.put(key,value);
        return code;
    }

    /**
     * 添加描述
     * @param value
     * @return
     */
    public MyMsg addDescription(Object value){
        detail.put("description",value);
        return this;
    }
    public static MyMsg addDescription(Object value, MyMsg code){
        detail.put("description",value);
        return code;
    }

    public Object getDetail(Object key){
        return detail.get(key);
    }

    public Map getDetail() {
        return detail;
    }
    public String getMessage() { return message; }

    public boolean isSuccessStatus() { return successStatus; }

    public int getCode() { return code; }
    @Override
    public String toString() {
        return "CouponCode{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", map=" + detail +
                '}';
    }

    private static class Util{
        private static int CODE = 0;

    }

}
