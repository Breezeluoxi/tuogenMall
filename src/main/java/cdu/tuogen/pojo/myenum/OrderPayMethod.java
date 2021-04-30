/**
 * @date : 2021/5/3
 * @name : tuogenMall_cdu.tuogen.pojo.myenum_OrderPayMethod
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

package cdu.tuogen.pojo.myenum;

public enum OrderPayMethod {
    ALI_PAY("支付宝", (byte)0), CASH_ON_DELIVERY("货到付款",(byte) 1), WEI_CHAT_PAY("微信支付",(byte) 2);
    private final String payMethod;
    private final Byte status;

    OrderPayMethod(String payMethod, Byte status) {
        this.payMethod = payMethod;
        this.status = status;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public Byte getStatus() {
        return status;
    }
}
