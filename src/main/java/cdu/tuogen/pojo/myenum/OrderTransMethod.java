package cdu.tuogen.pojo.myenum;

/**
 * @date : 2021/5/3
 * @name : tuogenMall_cdu.tuogen.pojo.myenum_OrderTransMethod
 * @Author: Breezeluoxi
 *                                                    __----~~~~~~~~~~~------___
 *                                   .  .   ~~//====......          __--~ ~~
 *                   -.            \_|//     |||\\  ~~~~~~::::... /~
 *                ___-==_       _-~o~  \/    |||  \\            _/~~-
 *        __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
 *    _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
 *  .~       .~       |   \\ -_    /  /-   /   ||      \   /
 * /  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
 * |~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
 *          '         ~-|      /|    |-~\~~       __--~~
 *                      |-~~-_/ |    |   ~\_   _-~            /\
 *                           /  \     \__   \/~                \__
 *                       _--~ _/ | .-~~____--~-/                  ~~==.
 *                      ((->/~   '.|||' -_|    ~~-/ ,              . _||
 *                                 -_     ~\      ~~---l__i__i__i--~~_/
 *                                 _-~-__   ~)  \--______________--~~
 *                               //.-~~~-~_--~- |-------~~~~~~~~
 *                                      //.-~~~--\
 *                          神兽保佑                   代码无BUG!
 */


public enum OrderTransMethod {
    ZT("中通速递", (byte)1), ST("申通速递",(byte) 2),
    YT("圆通速递", (byte)3), SF("顺风速递",(byte) 4),
    JD("京东次日达", (byte)5), JDT("京东物流",(byte) 6),
    USER_SELF("用户自提", (byte)4);
    private final String describe;
    private final Byte status;

    OrderTransMethod(String describe, Byte status) {
        this.describe = describe;
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public Byte getStatus() {
        return status;
    }
}
