package com.javacto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javacto.po.DangdangProduct;
import com.javacto.po.DangdangProductCategory;
import com.javacto.service.DangdangProductCategoryService;
import com.javacto.service.DangdangProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.io.IOException;
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
@RequestMapping("/dangdangProduct")
public class DangdangProductController {

    @Autowired
    DangdangProductService dangdangProductService;

    @Autowired
    DangdangProductCategoryService dangdangProductCategoryService;

    @RequestMapping("/queryAllPage")
    public String queryAllPage(HttpSession session,Page page,Map<String,Object>map,Model model){
        List<DangdangProduct> dangdangProductList = (List<DangdangProduct>) session.getAttribute("productListPage");
        page.setSize(3);
        QueryWrapper<DangdangProduct> dangdangProductQueryWrapper = new QueryWrapper<DangdangProduct>();
        //需要添加条件再加
        dangdangProductService.pageMaps(page,dangdangProductQueryWrapper);
        session.setAttribute("productListPage",page.getRecords());
        map.put("path","/SpringBootShop/images/product/");
        map.put("page",page);
        return "manage/product";
    }

    @RequestMapping("/queryAll")
    public String queryAll(HttpSession session){

         DangdangProduct dangdangProduct = (DangdangProduct) session.getAttribute("productList");
         if (dangdangProduct==null){
             List<DangdangProduct> list = dangdangProductService.list();
             session.setAttribute("productList",list);
         }
        return "index";
    }

    @RequestMapping("/queryAllBydpcChildId")
    public String queryAllBydpcChildId(Integer dpcParentId, Map<String,Object>map, Page page,DangdangProduct product){

        page.setSize(3);
        dangdangProductService.queryAllBydpcChildId(page,product,dpcParentId);
        map.put("productList",page.getRecords());
        map.put("page",page);
        //方便分页查询调用这个方法，类似于摆设
        map.put("dpcParentId",dpcParentId);
        map.put("product",product);
        map.put("dpcChildId",product.getDpcChildId());
        map.put("path","/SpringBootShop/images/product/");
        return "product-list";
    }

    @RequestMapping("/product-view.html")
    public String getByDp_id(Integer dpId,Map<String,Object>map){
        DangdangProduct dangdangProduct = dangdangProductService.getById(dpId);
        map.put("product2",dangdangProduct);
        map.put("path","/SpringBootShop/images/product/");
        return "product-view";
    }

    @RequestMapping("/goShopping.html")
    public String goShopping(Integer dpId,Map<String,Object>map){
        DangdangProduct dangdangProduct = dangdangProductService.getById(dpId);
        map.put("product3",dangdangProduct);
        map.put("path","/SpringBootShop/images/product/");
        return "shopping";
    }

    @RequestMapping("/goAddProductManage")
    public String goAddProductManage(Map<String,Object>map,Model model){
        List<DangdangProductCategory> productCateList = new ArrayList<>();
        List<DangdangProductCategory> list = dangdangProductCategoryService.list();
        for (DangdangProductCategory d:list){
            if (d.getDpcParentId()!=0){
                DangdangProductCategory dangdangProductCategory = new DangdangProductCategory();
                dangdangProductCategory.setDpcName(d.getDpcName());
                dangdangProductCategory.setDpcId(d.getDpcId());
                productCateList.add(dangdangProductCategory);
           }
        }
        map.put("productCateList",productCateList);
        return "manage/product-add";
    }

    @RequestMapping("/addProductManage")
    public String addProductManage(MultipartFile photo, DangdangProduct dangdangProduct,Model model) throws IOException {
        String path = System.getProperty("user.dir")+"/images/user";
        File file = new File(path);
        //判断 ，path 是否存在，如果不在了在则创建
        if(!file.exists()){
            //不存在则创建
            file.mkdirs();
        }
        //获限上传文件的名称
        String fileName1 = photo.getOriginalFilename();

        System.out.println(path+fileName1);

        //完成图片上传
        photo.transferTo(new File(path,fileName1));

        //图片上传进入后，把图片路径set到
        dangdangProduct.setDpFileName(fileName1);
        //dangdangProductService.save(dangdangProduct);
        model.addAttribute("msg",1);
        return "forward:/dangdangProduct/queryAllPage";
    }

    @RequestMapping("/goUpdateProductMange")
    public String goUpdateProductMange(Map<String,Object>map, Integer dpId,Model model){
        List<DangdangProductCategory> productCateList = new ArrayList<>();
        DangdangProduct dangdangProduct = dangdangProductService.getById(dpId);
        model.addAttribute("dangdangProduct",dangdangProduct);
        DangdangProductCategory dangdangProductCategory1 = dangdangProductCategoryService.getById(dangdangProduct.getDpcChildId());
        model.addAttribute("dangdangProductCategory1",dangdangProductCategory1);
        List<DangdangProductCategory> list = dangdangProductCategoryService.list();
        for (DangdangProductCategory d:list){
            if (d.getDpcParentId()!=0){
                DangdangProductCategory dangdangProductCategory = new DangdangProductCategory();
                dangdangProductCategory.setDpcName(d.getDpcName());
                dangdangProductCategory.setDpcId(d.getDpcId());
                productCateList.add(dangdangProductCategory);
            }
        }
        map.put("productCateList",productCateList);
        return "manage/product-modify";
    }

    @RequestMapping("/UpdateProductMange")
    public String goUpdateProductMange(MultipartFile photo,DangdangProduct dangdangProduct,Model model) throws IOException {
        if (photo==null){
            String path = System.getProperty("user.dir")+"/images/user";
            File file = new File(path);
            //判断 ，path 是否存在，如果不在了在则创建
            if(!file.exists()){
                //不存在则创建
                file.mkdirs();
            }
            //获限上传文件的名称
            String fileName1 = photo.getOriginalFilename();

            System.out.println(path+fileName1);

            //完成图片上传
            photo.transferTo(new File(path,fileName1));

            //图片上传进入后，把图片路径set到
            dangdangProduct.setDpFileName(fileName1);
        }
        //dangdangProductService.updateProductManage(dangdangProduct);
        model.addAttribute("msg",2);
        return "forward:/dangdangProduct/queryAllPage";
    }

    @RequestMapping("/deleteProductManage")
    public String deleteProductManage(Integer dpId,Model model){
        //dangdangProductService.removeById(dpId);
        model.addAttribute("msg",3);
        return "forward:/dangdangProduct/queryAllPage";
    }
}

