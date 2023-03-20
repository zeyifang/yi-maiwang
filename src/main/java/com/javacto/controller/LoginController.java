package com.javacto.controller;

import com.javacto.po.DangdangUser;
import com.javacto.service.DangdangProductService;
import com.javacto.service.DangdangUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: zj
 * @Date: 2023-02-09 - 02 - 09 - 18:20
 * @Description: com.javacto.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    DangdangUserService dangdangUserService;

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String userName, String passWord, Model model,HttpSession session,Map<String,Object>map){
        DangdangUser dangdangUser = new DangdangUser();
        dangdangUser.setDuUserName(userName);
        dangdangUser.setDuPassword(passWord);
        DangdangUser dangdangUser1 = dangdangUserService.checkNameAndPwd(dangdangUser);
        String check = "login";
        if (dangdangUser1!=null){
            session.setAttribute("User",dangdangUser1);
            model.addAttribute("login",1);
            check = "forward:/dangdangProductCategory/queryAll";
        }
        /*model.addAttribute("check",2);*/
        model.addAttribute("check",2);
        return check;
    }

    @RequestMapping("/goManage")
    public String goManager(HttpSession session,Model model){
        DangdangUser dangdangUser = (DangdangUser) session.getAttribute("User");
        model.addAttribute("userName",dangdangUser.getDuUserName());
        return "manage/index";
    }

    @RequestMapping("/goRegister")
    public String goRegister() {
        return "register";
    }


    @RequestMapping("/register")
    public String register(String userName, String passWord,DangdangUser dangdangUser,Model model){
        dangdangUser.setDuUserName(userName);
        dangdangUser.setDuPassword(passWord);
        dangdangUserService.save(dangdangUser);
        model.addAttribute("message",3);
        return "login";
    }
}
