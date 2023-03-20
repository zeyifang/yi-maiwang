package com.javacto.mapper;

import com.javacto.po.DangdangUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javacto.service.DangdangUserService;
import org.springframework.stereotype.Component;
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
public interface DangdangUserMapper extends BaseMapper<DangdangUser> {

    /**
     * 校验用户名和验证码
     * @return
     */
    public DangdangUser checkNameAndPwd(DangdangUser dangdangUser);

    /**
     * 根据ID修改
     * @param dangdangUser
     */
    public void updateByUsrId(DangdangUser dangdangUser);


}
