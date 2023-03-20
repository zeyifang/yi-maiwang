package com.javacto.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javacto.po.DangdangProduct;
import com.javacto.po.DangdangShopping;
import com.javacto.po.DangdangShoppingItems;
import com.javacto.po.DangdangUser;
import com.javacto.service.DangdangProductService;
import com.javacto.service.DangdangShoppingService;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
@Controller
@RequestMapping("/dangdangShopping")
public class DangdangShoppingController {

    @Autowired
    DangdangShoppingService dangdangShoppingService;

    @Autowired
    DangdangProductService dangdangProductService;

    @RequestMapping("/queryAll")
    public String queryAll(HttpSession session){
        List<DangdangShopping> list = dangdangShoppingService.selectAll();
        session.setAttribute("shopping",list);
        return "shopping";
    }

    @RequestMapping("/queryAllByUserId")
    public String queryAllByUserId(HttpSession session,Map<String,Object>map){
        String check = null;
        DangdangUser dangdangUser = (DangdangUser) session.getAttribute("User");
        if (dangdangUser == null) {
            check = "login";
        } else {
            int userId = dangdangUser.getDuUserId();
            List<DangdangShopping> dangdangShoppings = dangdangShoppingService.queryAllById(userId);
            //前端要用session.什么接收
            session.setAttribute("shopping", dangdangShoppings);
            map.put("path","/SpringBootShop/images/product/");
            check = "shopping";
        }
        return check;
    }


    @RequestMapping("/addShopping")
    public String addShopping(Integer dpId, HttpSession session, Map<String,Object>map) {
        String check = null;
        DangdangUser dangdangUser = (DangdangUser) session.getAttribute("User");
        if (dangdangUser == null) {
            check = "login";
        } else {
            int userId = dangdangUser.getDuUserId();
            List<DangdangShopping> dangdangShoppings = dangdangShoppingService.queryByDoUserId(userId, dpId);
            //前端要用session.什么接收
            session.setAttribute("shopping", dangdangShoppings);
            map.put("path","/SpringBootShop/images/product/");
            check = "shopping";
        }
        return check;
    }

    @RequestMapping("/updateShopping")
    public String updateShopping(Integer  dpId,int dodQuantity, HttpSession session) throws IOException {
        DangdangProduct dangdangProduct = dangdangProductService.getById(dpId);
        Double price = dangdangProduct.getDpPrice();
        DangdangShopping dangdangShopping = new DangdangShopping();
        Double cost = price*dodQuantity;
        dangdangShopping.setDpId(dpId);
        dangdangShopping.setDodQuantity(dodQuantity);
        dangdangShopping.setDodCost(cost);
        dangdangShoppingService.updateIdAndQuantity(dangdangShopping);
        return "forward:/dangdangShopping/queryAll";
    }
    @RequestMapping("/deleteShopping")
    public String deleteShopping(Integer dpId,HttpSession session,Map<String,Object>map
    ){
        dangdangShoppingService.deleteShopping(dpId);
        List<DangdangShopping> list = dangdangShoppingService.selectAll();
        session.setAttribute("shopping",list);
        map.put("path","/SpringBootShop/images/product/");
        return "forward:/dangdangShopping/queryAll";
    }
}

