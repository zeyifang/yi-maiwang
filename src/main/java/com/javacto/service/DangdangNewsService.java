package com.javacto.service;

import com.javacto.po.DangdangNews;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
public interface DangdangNewsService extends IService<DangdangNews> {


    /**
     * 修改
     */
    public void updateManage(DangdangNews dangdangNews);
}
