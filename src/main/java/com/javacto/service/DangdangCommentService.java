package com.javacto.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javacto.mapper.DangdangCommentMapper;
import com.javacto.po.DangdangComment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
public interface DangdangCommentService extends IService<DangdangComment> {


    /**
     * 查询全部加分页
     * @return
     */
    public IPage<DangdangComment> queryCommentAllPage(IPage<DangdangComment>page ,DangdangComment dangdangComment);

    /**
     * 根据id更改留言信息
     * @param dangdangComment
     */
    public void updateCommentManage(DangdangComment dangdangComment);
}


