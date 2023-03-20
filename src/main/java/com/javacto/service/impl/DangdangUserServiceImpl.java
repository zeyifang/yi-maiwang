package com.javacto.service.impl;

import com.javacto.po.DangdangUser;
import com.javacto.mapper.DangdangUserMapper;
import com.javacto.service.DangdangUserService;
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
public class DangdangUserServiceImpl extends ServiceImpl<DangdangUserMapper, DangdangUser> implements DangdangUserService {

    @Autowired
    DangdangUserMapper dangdangUserMapper;

    public DangdangUser checkNameAndPwd(DangdangUser dangdangUser){
        return dangdangUserMapper.checkNameAndPwd(dangdangUser);
    }

    public void updateByUsrId(DangdangUser dangdangUser){
        dangdangUserMapper.updateByUsrId(dangdangUser);
    }
}
