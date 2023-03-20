package com.javacto.service.impl;

import com.javacto.po.DangdangNews;
import com.javacto.mapper.DangdangNewsMapper;
import com.javacto.service.DangdangNewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
@Service
public class DangdangNewsServiceImpl extends ServiceImpl<DangdangNewsMapper, DangdangNews> implements DangdangNewsService {

    @Autowired
    DangdangNewsMapper dangdangNewsMapper;

    public void updateManage(DangdangNews dangdangNews){
        dangdangNewsMapper.updateManage(dangdangNews);
    }
}
