package com.javacto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javacto.po.DangdangNews;
import com.javacto.service.DangdangNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/dangdangNews")
public class DangdangNewsController {

    @Autowired
    DangdangNewsService dangdangNewsService;

    @RequestMapping("/queryAllPage")
    public String queryAllPage(Page page, HttpSession session, Map<String,Object>map){
        page.setSize(3);
        QueryWrapper<DangdangNews> dangdangNewsQueryWrapper = new QueryWrapper<>();
        dangdangNewsService.pageMaps(page,dangdangNewsQueryWrapper);
        session.setAttribute("newsListPage",page.getRecords());
        map.put("page",page);
        return "manage/news";

    }

    @RequestMapping("/goAddManage")
    public String goAddManage(){
        return "manage/news-add";
    }

    @RequestMapping("/addManage")
    public String addManage(DangdangNews dangdangNews, Model model){
        dangdangNewsService.save(dangdangNews);
        model.addAttribute("msg",1);
        return "redirect:/dangdangNews/queryAllPage";
    }

    @RequestMapping("/seletById")
    public String seletById(Integer dnId,Model model){
        DangdangNews dangdangNews = dangdangNewsService.getById(dnId);
        model.addAttribute("dangdangNews",dangdangNews);
        return "manage/news-modify";
    }

    @RequestMapping("/updateManage")
    public String updateManage(DangdangNews dangdangNews,Model model){
        dangdangNewsService.updateManage(dangdangNews);
        model.addAttribute("msg",2);
        return "forward:/dangdangNews/queryAllPage";
    }

    @RequestMapping("/deleteMnageById")
    public String deleteMnageById(Integer dnId,Model model){
        dangdangNewsService.removeById(dnId);
        model.addAttribute("msg",3);
        return "forward:/dangdangNews/queryAllPage";
    }
}

