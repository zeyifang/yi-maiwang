package com.javacto.mapper;

import com.javacto.po.DangdangNews;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface DangdangNewsMapper extends BaseMapper<DangdangNews> {

    /**
     * 修改
     */
    public void updateManage(DangdangNews dangdangNews);
}
