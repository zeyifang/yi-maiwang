package com.javacto.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javacto.po.DangdangComment;
import com.javacto.mapper.DangdangCommentMapper;
import com.javacto.service.DangdangCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
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
public class DangdangCommentServiceImpl extends ServiceImpl<DangdangCommentMapper, DangdangComment> implements DangdangCommentService {

    @Autowired
    DangdangCommentMapper dangdangComnentMapper;

    public IPage<DangdangComment> queryCommentAllPage(IPage<DangdangComment>page, DangdangComment dangdangComment){

        return dangdangComnentMapper.queryCommentAllPage(page,dangdangComment);
    }

    public void updateCommentManage(DangdangComment dangdangComment){
        dangdangComnentMapper.updateCommentManage(dangdangComment);
    }
}
