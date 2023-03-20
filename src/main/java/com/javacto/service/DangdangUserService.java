package com.javacto.service;

import com.javacto.po.DangdangUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
public interface DangdangUserService extends IService<DangdangUser> {

    /**
     * 登录校验
     * @param dangdangUser
     * @return
     */
    public DangdangUser checkNameAndPwd(DangdangUser dangdangUser);

    /**
     * 修改
     * @param dangdangUser
     */
    public void updateByUsrId(DangdangUser dangdangUser);
}
