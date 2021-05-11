/**
 * *   Description:
 * *   @File     :FreightMapper.py
 * *   @Author   :王炜 IAmTrying
 * *   @QQ       :690622472
 * *   @Time     :5/11/2021 10:24
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

package cdu.tuogen.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 运费
 */
public interface FreightMapper {
    @Select({"select transport_discount " +
            "from uservip_level where" +
            " vip_level=(select vip_level from user where user_id=#{userId})"})
    float get(int userId);

    @Update("update uservip_level set transport_discount=#{discount} where vip_level=#{vipLevel}")
    int mod(@Param("discount") float discount, @Param("vipLevel")int vipLevel);
}


