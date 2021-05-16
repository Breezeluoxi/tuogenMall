package cdu.tuogen.controller;

import cdu.tuogen.bean.wei.MyMsg;
import cdu.tuogen.pojo.Goods;
import cdu.tuogen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Made By 王炜
 * 购物车
 */
@RequestMapping("/cart")
@RestController
public class CartController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 添加购物车
     * @param goodId
     * @param session
     * @param response
     * @return
     */
    @PostMapping
    public MyMsg add(@RequestParam("goodId")int goodId,@ModelAttribute("cart")ArrayList<Goods> cart ,HttpSession session, HttpServletResponse response) {
        //查询商品
        Goods goods = goodsService.queryGoodsById(goodId);
        if (goods == null) return MyMsg.FAILED;
        //添加商品至购物车
        cart.add(goods);
        //设置session存活时长
        session.setMaxInactiveInterval(60 * 60 * 2);
        //设置cookie存活时间
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60 * 60 * 2);
        response.addCookie(cookie);
        return MyMsg.SUCCESS;
    }

    /**
     * 查询购物车
     * @return
     */
    @GetMapping
    public MyMsg get(@ModelAttribute("cart")ArrayList<Goods> cart){
        return MyMsg.SUCCESS.addDetail("goods",cart);
    }

    /**
     * 清空购物车
     * @param session
     * @return
     */
    @DeleteMapping
    public MyMsg clear(HttpSession session){
        session.removeAttribute("cart");
        return MyMsg.SUCCESS;
    }

    @ModelAttribute("cart")
    public ArrayList<Goods> checkCart(HttpSession session){
        //获取购物车
        ArrayList<Goods> cart = (ArrayList<Goods>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<Goods>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
}
