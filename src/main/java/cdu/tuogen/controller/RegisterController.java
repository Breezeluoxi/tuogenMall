package cdu.tuogen.controller;

import cdu.tuogen.bean.wei.MyException;
import cdu.tuogen.bean.wei.Tmpl;
import cdu.tuogen.pojo.Admin;
import cdu.tuogen.pojo.User;
import cdu.tuogen.service.AdminService;
import cdu.tuogen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Made By 王炜
 * 供注册使用Servlet
 */
@RequestMapping("/register")
@Controller
public class RegisterController implements ServletContextAware {
    //项目真实路径
    public static String realPath;
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Override
    public void setServletContext(ServletContext servletContext) {
        realPath = servletContext.getRealPath("/");
    }
    @GetMapping
    public String view2(){
        return "/WEB-INF/view/register.jsp";
    }

    //注册用户
    @PostMapping("/user")
    public String user(@Validated User user, BindingResult result, @RequestParam("icon") MultipartFile icon, Model model) throws Exception {
        System.out.println(result.hasErrors());
        System.out.println(user);
        //数据校验
        if (result.hasErrors())throw MyException.getTmplAndParsing(Tmpl.REGISTER_ERROR,result);
        //设置头像路径
        user.setPicUrl(dealIcon(icon));
        //插入数据库
        Integer status = userService.insertUser(Arrays.asList(user));
        if (status==null) throw MyException.getTmpl(Tmpl.REGISTER_ERROR);
        //设置状态
        model.addAttribute("user_register_success",user);
        return "redirect:/index.html";
    }

    //注册商家
    @PostMapping("/merchant")
    public String merchant(Admin admin, BindingResult result, @RequestParam("icon") MultipartFile icon, Model model) throws Exception {
        //数据校验
        if (result.hasErrors())throw MyException.getTmplAndParsing(Tmpl.REGISTER_ERROR,result);
        //设置头像路径
        admin.setPicUrl(dealIcon(icon));
        //插入数据库
        Integer status = adminService.insertAdmin(Arrays.asList(admin));
        if (status==null) throw MyException.getTmpl(Tmpl.REGISTER_ERROR);
        //设置状态
        model.addAttribute("admin_register_success",admin);
        return "redirect:/index.html";
    }

    //保存图片
    private String dealIcon(MultipartFile iconFile) throws IOException {
        String icon_path="";
        if (!iconFile.isEmpty()){
            String name = System.currentTimeMillis()+"."+iconFile.getContentType().split("/")[1];
            //获取路径
            String icon_url=realPath+"static\\userIcon\\"+name;
            File newFile=new File(icon_url);
            newFile.mkdirs();
            //保存icon
            iconFile.transferTo(newFile);
            icon_path="static/userIcon/"+name;
        }
        return icon_path;
    }

}
