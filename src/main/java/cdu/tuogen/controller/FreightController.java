/**
 * *   Description:
 * *   @File     :FreightController.py
 * *   @Author   :王炜 IAmTrying
 * *   @QQ       :690622472
 * *   @Time     :5/11/2021 10:36
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

package cdu.tuogen.controller;

import cdu.tuogen.mapper.FreightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/freight")
public class FreightController {
    @Autowired
    FreightMapper freightMapper;
    @GetMapping("{userId}")
    //查询运费折扣
    public Object get(@PathVariable("userId") int userId){
        float discount = freightMapper.get(userId);
        return discount!=0?discount:"fail";
    }

    @PutMapping
    //修改运费折扣
    public Object mod(float discount,int vipLevel){ return freightMapper.mod(discount,vipLevel)>0?"ok":"fail"; }
    
}
