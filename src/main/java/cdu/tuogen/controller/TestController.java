package cdu.tuogen.controller;
import cdu.tuogen.pojo.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        HttpSession session = request.getSession();
        return "/view/helloView.jsp";
    }
}
