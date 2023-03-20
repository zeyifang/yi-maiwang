package com.javacto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javacto.po.DangdangOrder;
import com.javacto.po.DangdangProduct;
import com.javacto.po.DangdangUser;
import com.javacto.service.DangdangOrderDetailService;
import com.javacto.service.DangdangOrderService;
import com.javacto.service.DangdangProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/dangdangOrder")
public class DangdangOrderController {

    @Autowired
    DangdangOrderService dangdangOrderService;

    @RequestMapping("/BuyAndAddOrder")
    public String BuyAndAddOrder(Integer dpId, HttpSession session){
        //获取用户对象
        DangdangUser dangdangUser = (DangdangUser) session.getAttribute("User");
        //如果获取不到就去登录
        if (dangdangUser==null){
            return "login";
        }
        dangdangOrderService.addOrderAndDetail(dpId,dangdangUser);
        return "forward:/dangdangProductCategory/queryAll";
    }

    @RequestMapping("/queryAllOrderPage")
    public String goOrderManage(Page page, HttpSession session, Map<String,Object>map){
        List<DangdangOrder> dangdangOrderPage = (List<DangdangOrder>) session.getAttribute("dangdangOrderPage");
        page.setSize(3);
        QueryWrapper<DangdangOrder> dangdangOrderQueryWrapper = new QueryWrapper<>();
        dangdangOrderService.pageMaps(page,dangdangOrderQueryWrapper);
        session.setAttribute("dangdangOrderPage",page.getRecords());
        map.put("page",page);
        return "manage/order";
    }

    @RequestMapping("/queryOrderByIdManage")
    public String queryOrderByIdManage(Integer doId, Model model){
        DangdangOrder orderListById = dangdangOrderService.getById(doId);
        model.addAttribute("orderListById",orderListById);
        return "manage/order-modify";
    }
    @RequestMapping("/updateOrderManage")
    public String updateOrderManage(DangdangOrder dangdangOrder,Model model){
        dangdangOrderService.updateOrderManage(dangdangOrder);
        model.addAttribute("msg",2);
        return "forward:/dangdangOrder/queryAllOrderPage";
    }

    @RequestMapping("/deleteOrderManage")
    public String deleteOrderManage(Integer doId,Model model){
        dangdangOrderService.removeById(doId);
        model.addAttribute("msg",3);
        return "forward:/dangdangOrder/queryAllOrderPage";
    }

    @RequestMapping("/queryNumberAndName")
    public String queryNumberAndName(DangdangOrder dangdangOrder,Map<String,Object>map){
        List<DangdangOrder> dangdangOrders =  dangdangOrderService.queryNumberAndName(dangdangOrder);
        map.put("dangdanSelect",dangdangOrders);
        return "manage/order2";
    }
}

