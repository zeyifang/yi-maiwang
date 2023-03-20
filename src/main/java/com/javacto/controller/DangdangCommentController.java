package com.javacto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javacto.po.DangdangComment;
import com.javacto.po.DangdangShopping;
import com.javacto.po.DangdangUser;
import com.javacto.service.DangdangCommentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
@Controller
@RequestMapping("/dangdangComment")
public class DangdangCommentController {

    @Autowired
    DangdangCommentService dangdangCommentService;

    @RequestMapping("/queryAllPage")
    public String queryAllPage(Page page, HttpSession session, Map<String,Object>map){
        page.setSize(1);
        QueryWrapper<DangdangComment> dangdangCommentQueryWrapper = new QueryWrapper<>();
        dangdangCommentService.pageMaps(page,dangdangCommentQueryWrapper);
        session.setAttribute("dangdangCommentsPage",page.getRecords());
        map.put("page",page);
        return "manage/guestbook";
    }

    @RequestMapping("/selectByIdManage")
    public String selectByIdManage(Integer duId,Map<String,Object>map){
        DangdangComment dangdangComment =dangdangCommentService.getById(duId);
        map.put("dangdangCommentGetByID",dangdangComment);
        return "manage/guestbook-modify";
    }

    @RequestMapping("/updateCommentManage")
    public String updateCommentManage(DangdangComment dangdangComment,Model model){
        dangdangCommentService.updateCommentManage(dangdangComment);
        model.addAttribute("msg",2);
        return "forward:/dangdangComment/queryAllPage";
    }

    @RequestMapping("/deleteCommentById")
    public String deleteCommentById(Integer duId,Model model){
        dangdangCommentService.removeById(duId);
        model.addAttribute("msg",2);
        return "forward:/dangdangComment/queryAllPage";
    }

    @RequestMapping("/queryAllComment")
    public String queryAllComment(Page page,HttpSession session,Map<String,Object>map){
        page.setSize(3);
        QueryWrapper<DangdangComment> dangdangCommentQueryWrapper = new QueryWrapper<>();
        dangdangCommentService.pageMaps(page,dangdangCommentQueryWrapper);
        session.setAttribute("CommentAll",page.getRecords());
        map.put("page",page);
        return "guestbook";
    }

    @RequestMapping("/addComment")
    public String addComment(HttpSession session,DangdangComment dangdangComment){
        String check = null;
        DangdangUser dangdangUser = (DangdangUser) session.getAttribute("User");
        if (dangdangUser == null) {
            check = "login";
        } else {
            dangdangCommentService.save(dangdangComment);
            check = "forward:/dangdangComment/queryAllComment";
        }
        return check;
    }
}

