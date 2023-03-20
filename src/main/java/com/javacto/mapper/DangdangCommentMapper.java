package com.javacto.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javacto.po.DangdangComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
@Repository
public interface DangdangCommentMapper extends BaseMapper<DangdangComment> {
    /**
     * 查询全部加分页
     * @param page
     * @return
     */
    IPage<DangdangComment> queryCommentAllPage(IPage<DangdangComment> page, @Param("dangdangComment") DangdangComment dangdangComment);

    /**
     * 根据id更改留言信息
     * @param dangdangComment
     */
    public void updateCommentManage(DangdangComment dangdangComment);
}
