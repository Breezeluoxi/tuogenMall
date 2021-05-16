package cdu.tuogen.controller;

import cdu.tuogen.pojo.Admin;
import cdu.tuogen.pojo.GoodsAll;
import cdu.tuogen.pojo.User;
import cdu.tuogen.utils.Constants;
import cdu.tuogen.pojo.Goods;
import cdu.tuogen.service.AdminService;
import cdu.tuogen.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/goods")
public class    GoodsController extends HttpServlet{
    @Autowired
    @Qualifier("goodsServiceImpl")
    private GoodsService goodsService;

    @RequestMapping(value = "/queryGoodsType", method = RequestMethod.POST)
    public String queryGoodsType(HttpServletRequest req, Model model, @RequestParam(defaultValue = "1")int pageNo){
        try {
            req.setCharacterEncoding("utf-8");//设置参数的编码格式
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int goodTypeId = Integer.parseInt(req.getParameter("goodTypeId"));
        int goodSaleType = Integer.parseInt(req.getParameter("goodSaleType"));
        System.out.println("测试1");
        System.out.println(goodTypeId);
        System.out.println(goodSaleType);
        String goodsSaleType = "";
        if (goodSaleType == 1){
            goodsSaleType = "新品";
        } else if(goodSaleType == 2){
            goodsSaleType = "热卖";
        }else if(goodSaleType == 3){
            goodsSaleType = "折扣";
        }
        System.out.println("测试2");
        System.out.println(goodTypeId);
        System.out.println(goodsSaleType);
        int adminShopId = 1;
//        int adminLevel = Integer.parseInt(admin.getAdminLevel());
        PageHelper.startPage(pageNo,5);
        List<GoodsAll> goodsAllList = goodsService.queryGoodsAllType(adminShopId,goodTypeId,goodsSaleType);
        PageInfo pageInfo = new PageInfo(goodsAllList);
//        System.out.println(goodsList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("goodsList",goodsAllList);
        return "/view/manager/goods_list.jsp";
    }



    @GetMapping("/list")
    public String list(HttpServletRequest request, Model model, @RequestParam(defaultValue = "1") int pageNo) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("user");
        System.out.println("测试");
        System.out.println(admin);
        int adminShopId = 1;
        int adminLevel = Integer.parseInt(admin.getAdminLevel());
//        System.out.println(adminLevel);
        PageHelper.startPage(pageNo,5);
        List<GoodsAll> goodsAllList = goodsService.queryGoodsAll(adminShopId);
//        List<Goods> goodsList = goodsService.queryGoods();
        PageInfo pageInfo = new PageInfo(goodsAllList);
//        System.out.println(goodsList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("goodsList",goodsAllList);
        model.addAttribute("adminLevel",adminLevel);
        return "/view/manager/goods_list.jsp";
    }


    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    public String insertGoods(HttpServletRequest req,HttpServletResponse resp, @RequestParam("goodPicUrl") MultipartFile file){
        try {
            req.setCharacterEncoding("utf-8");//设置参数的编码格式
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (file != null){
            // 生成图片存储的名称，UUID 避免相同图片名冲突
            // 原始文件名
            String originalFileName = file.getOriginalFilename();
            // 图片后缀
            String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + suffix;
            String path1 = req.getSession().getServletContext().getRealPath("/");
            //System.out.println(path1);
            String filePath1 =path1 + Constants.IMG_PATH1 + fileName;
            File saveFile1 = new File(filePath1);
            try {
                // 将上传的文件保存到服务器文件系统
                file.transferTo(saveFile1);
                // 记录服务器文件系统图片名称
                int goodId = 0;
                String goodName =req.getParameter("goodName");
                int goodTypeId = Integer.parseInt(req.getParameter("goodTypeId"));
                String goodSaleType =req.getParameter("goodSaleType");
                int goodNum = Integer.parseInt(req.getParameter("goodNum"));
                String goodIntroduce =req.getParameter("goodIntroduce");
                Double goodPrice = Double.valueOf(req.getParameter("goodPrice"));
                int goodShopId = Integer.parseInt(req.getParameter("goodShopId"));
                String goodPicUrl =fileName;
//                System.out.println("测试");
//                System.out.println(goodName);
//                System.out.println(file);
                Goods goods = new Goods(goodId, goodName, goodTypeId, goodSaleType, goodNum,goodIntroduce, goodPrice,goodShopId,goodPicUrl);
                System.out.println("整体测试");
                System.out.println(goods);
                if (goodsService.insertGoods(goods, file)){
                    return "redirect:list"; // 添加成功，跳转到显示页面
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/view/manager/add_goods.jsp"; // 添加失败，重定向到商品增加页面
    }

    @GetMapping("/gmodPer")
    public void gmodPer(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
        int goodId = Integer.parseInt(request.getParameter("goodId"));
        Goods goods = goodsService.queryGoodsById(goodId);
        request.setAttribute("goods", goods);
        request.getRequestDispatcher("/view/manager/mod_goods.jsp").forward(request, response);
    }

    @RequestMapping(value = "/modGoods", method = RequestMethod.POST)
    public String modGoods(HttpServletRequest req,HttpServletResponse resp, @RequestParam("goodPicUrl") MultipartFile file){
        try {
            req.setCharacterEncoding("utf-8");//设置参数的编码格式
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (file != null){
            // 生成图片存储的名称，UUID 避免相同图片名冲突
            String originalFileName = file.getOriginalFilename(); // 原始文件名
            String suffix = originalFileName.substring(originalFileName.lastIndexOf(".")); // 图片后缀
            String fileName = UUID.randomUUID().toString() + suffix;
            String path1 = req.getSession().getServletContext().getRealPath("/");
            String filePath1 =path1 + Constants.IMG_PATH1 + fileName;
            File saveFile1 = new File(filePath1);
            try {
                // 将上传的文件保存到服务器文件系统
//                file.transferTo(saveFile);
                file.transferTo(saveFile1);
                this.inputStreamToFile((FileInputStream) file.getInputStream(), new File(filePath1));

                // 记录服务器文件系统图片名称
                int goodId = Integer.parseInt(req.getParameter("goodId"));
                String goodName =req.getParameter("goodName");
                int goodTypeId = Integer.parseInt(req.getParameter("goodTypeId"));
                String goodSaleType =req.getParameter("goodSaleType");
                int goodNum = Integer.parseInt(req.getParameter("goodNum"));
                String goodIntroduce =req.getParameter("goodIntroduce");
                Double goodPrice = Double.valueOf(req.getParameter("goodPrice"));
                int goodShopId = Integer.parseInt(req.getParameter("goodShopId"));
                String goodPicUrl =fileName;
//                System.out.println("测试");
//                System.out.println(goodName);
//                System.out.println(file);
                Goods goods = new Goods(goodId, goodName, goodTypeId, goodSaleType, goodNum,goodIntroduce, goodPrice,goodShopId,goodPicUrl);
                System.out.println("整体测试");
                System.out.println(goods);
                if (goodsService.updateGoods(goods, file)){
                    return "redirect:list"; // 更新成功，跳转到显示页面
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/view/manager/mod_goods.jsp"; // 更新失败，重定向到商品增加页面
    }

    public void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/delGoods")
    public String delGoods(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        int goodId = Integer.parseInt(request.getParameter("goodId"));
        Goods goods = goodsService.queryGoodsById(goodId);
        if(goodsService.deleteGoods(goodId)){
            return "redirect:list";
        }else {
            return "redirect:list";
        }
    }

    @GetMapping("/wareGoods")
    public void wareGoods(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
        int goodId = Integer.parseInt(request.getParameter("goodId"));
        Goods goods = goodsService.queryGoodsById(goodId);
        request.setAttribute("goods", goods);
        request.getRequestDispatcher("/view/manager/goods_warehousing.jsp").forward(request, response);
    }


    @RequestMapping(value = "/goodware", method = RequestMethod.POST)
    public String goodware(HttpServletRequest req, HttpServletResponse response)  throws ServletException, IOException{
        int goodId = Integer.parseInt(req.getParameter("goodId"));
        int goodNum = Integer.parseInt(req.getParameter("goodNum"));
        System.out.println("整体测试");
        System.out.println(goodId);
        System.out.println(goodNum);
        if (goodsService.updateGoodsWare(goodId, goodNum)){
            return "redirect:list"; // 更新成功，跳转到显示页面
        }

        return "redirect:/view/manager/goods_warehousing.jsp"; // 更新失败，重定向到商品增加页面
    }

}
