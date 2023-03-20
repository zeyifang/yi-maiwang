package com.javacto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javacto.po.DangdangProduct;
import com.javacto.po.DangdangProductCategory;
import com.javacto.service.DangdangProductCategoryService;
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
@RequestMapping("/dangdangProductCategory")
public class DangdangProductCategoryController {

    @Autowired
    DangdangProductCategoryService dangdangProductCategoryService;

    @Autowired
    DangdangProductService dangdangProductService;

    @RequestMapping("/queryAll")
    public String queryAll(HttpSession session, Map<String,Object>map, Page page,Integer dpcChildId,Model model){
        List<DangdangProductCategory> dangdangProductCategory = (List<DangdangProductCategory>) session.getAttribute("produceCategoryList");
        if (dangdangProductCategory==null) {
            List<DangdangProductCategory> list = dangdangProductCategoryService.list();
            //List<DangdangProduct> list1 = dangdangProductService.list();
            session.setAttribute("produceCategoryList", list);
        }
        page.setSize(3);
        dangdangProductService.queryAll(page);
        map.put("productList",page.getRecords());
        map.put("page",page);
        map.put("path","/SpringBootShop/images/product/");
        map.put("dpcChildId",dpcChildId);
        model.addAttribute("check",1);
        return "index";
    }
    @RequestMapping("/queryDpcParentIdBydpcId")
    public String queryDpcParentIdBydpcId(Integer dpcParentId, Map<String,Object>map){
        /*List<DangdangProductCategory> dangdangProductCategoryByPid = (List<DangdangProductCategory>) session.getAttribute("dangdangProductCategoryByPid");*/
        /*if (dangdangProductCategoryByPid==null) {
            List<DangdangProductCategory> list = dangdangProductCategoryService.queryDpcParentIdBydpcId(dpcParentId);
            session.setAttribute("dangdangProductCategoryByPid",list);
        }*/
        List<DangdangProductCategory> list = dangdangProductCategoryService.queryDpcParentIdBydpcId(dpcParentId);
        map.put("productCateList2",list);
        return "index";
    }
    @RequestMapping("/queryAllByManage")
    public String queryAllByManage(HttpSession session,Page page){
        List<DangdangProductCategory> dangdangProductCategory = (List<DangdangProductCategory>) session.getAttribute("produceCategoryListPage");
        page.setSize(4);
        QueryWrapper<DangdangProductCategory> dangdangProductCategoryQueryWrapper = new QueryWrapper<DangdangProductCategory>();
        //加入条件dangdangProductCategoryQueryWrapper.eq()
        dangdangProductCategoryService.pageMaps(page,dangdangProductCategoryQueryWrapper);
        session.setAttribute("produceCategoryListPage", page.getRecords());
        return "manage/productClass";
    }

    @RequestMapping("/goAddProductCateManage")
    public String goAddProductCate(HttpSession session){
        List<DangdangProductCategory> dangdangProductCategory = (List<DangdangProductCategory>) session.getAttribute("produceCategoryList");
        if (dangdangProductCategory==null) {
            List<DangdangProductCategory> list = dangdangProductCategoryService.list();
            //List<DangdangProduct> list1 = dangdangProductService.list();
            session.setAttribute("produceCategoryList", list);
        }
        return "manage/productClass-add";
    }

    @RequestMapping("/addProductCateManage")
    public String addProductCateManage(String dpcName,Integer dpcId,Model model){
        DangdangProductCategory dangdangProductCategory = new DangdangProductCategory();
        dangdangProductCategory.setDpcName(dpcName);
        dangdangProductCategory.setDpcParentId(dpcId);
        int num = dangdangProductCategoryService.selectMaxDpcId(dpcId);
        dangdangProductCategory.setDpcId(num+1);
        dangdangProductCategoryService.addProductCateManage(dangdangProductCategory);
        model.addAttribute("msg",1);
        return "forward:/dangdangProductCategory/queryAllByManage";
    }

    @RequestMapping("/goUpdateProductCateManage")
    public String goUpdateProductCateManage(Integer dpcId,HttpSession session,Map<String,Object>map){
        DangdangProductCategory dangdangProductCategory1 = dangdangProductCategoryService.getById(dpcId);
        if (dangdangProductCategory1.getDpcParentId()==0){
            map.put("update",1);
            map.put("dpcName",dangdangProductCategory1.getDpcName());
            map.put("dpcId",dangdangProductCategory1.getDpcId());
        }else {
            map.put("update",2);
            map.put("dpcName",dangdangProductCategory1.getDpcName());
            map.put("dpcId",dangdangProductCategory1.getDpcId());
        }
        return "manage/productClass-modify";
    }

    @RequestMapping("/updateProductCateManage")
    public String updateProductCateManage(DangdangProductCategory dangdangProductCategory,Model model){
        dangdangProductCategoryService.updateById(dangdangProductCategory);
        model.addAttribute("msg",2);
        return "forward:/dangdangProductCategory/queryAllByManage";
    }

    @RequestMapping("/deleteProductCateManage")
    public String deleteProductCateManage(Integer dpcId,Model model){
        dangdangProductCategoryService.removeById(dpcId);
        model.addAttribute("msg",3);
        return "forward:/dangdangProductCategory/queryAllByManage";
    }
}

