package com.javacto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javacto.po.DangdangProductCategory;
import com.javacto.po.DangdangUser;
import com.javacto.service.DangdangProductCategoryService;
import com.javacto.service.DangdangProductService;
import com.javacto.service.DangdangUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
@RequestMapping("/dangdangUser")
public class DangdangUserController {

    @Autowired
    DangdangUserService dangdangUserService;



    @RequestMapping("/queryUserManger")
    public String queryUserManger(Page page,Map<String,Object>map){
        page.setSize(1);
        QueryWrapper<DangdangUser> dangdangUserQueryWrapper = new QueryWrapper<DangdangUser>();
        //加入条件，性别要为1
        dangdangUserQueryWrapper.eq("DU_SEX","1");
        //调用查询的方法
        dangdangUserService.pageMaps(page,dangdangUserQueryWrapper);
        map.put("page",page);
        return "manage/user";
    }

    @RequestMapping("/selectUserById")
    public String selectUserById(Integer duUserId,Map<String,Object>map){
        DangdangUser dangdangUser = dangdangUserService.getById(duUserId);
        map.put("dangdangUser",dangdangUser);
        return "manage/user-modify";
    }

    @RequestMapping("/updateUserById")
    public String updateUserById(DangdangUser dangdangUser,MultipartFile photo,Model model) throws IOException {
        String fileName2 = photo.getOriginalFilename();
        if (fileName2!=dangdangUser.getDuNew3()) {
            String path = System.getProperty("user.dir")+"/images/user";
            File file = new File(path);
            //判断 ，path 是否存在，如果不在了在则创建
            if(!file.exists()){
                //不存在则创建
                file.mkdirs();
            }
            //完成图片上传
            photo.transferTo(new File(path,fileName2));
            //图片上传进入后，把图片路径set到
            dangdangUser.setDuNew3(fileName2);
        }
        dangdangUserService.updateByUsrId(dangdangUser);
        model.addAttribute("msg",2);
        return "forward:/dangdangUser/queryUserManger";
    }

    @RequestMapping("/goUser-add")
    public String goAdd(){
        return "manage/user-add";
    }

    @RequestMapping("/addUser")
    public String addUser(DangdangUser dangdangUser,Model model,MultipartFile photo) throws IOException {
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
        dangdangUser.setDuNew3(fileName1);
        dangdangUserService.save(dangdangUser);
        model.addAttribute("msg",1);
        return "forward:/dangdangUser/queryUserManger";
    }

    @RequestMapping("/deleteUserById")
    public String deleteUser(Integer duUserId,Model model){
        dangdangUserService.removeById(duUserId);
        model.addAttribute("msg",3);
        return "forward:/dangdangUser/queryUserManger";
    }
}

