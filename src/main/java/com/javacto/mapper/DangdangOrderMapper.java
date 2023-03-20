package com.javacto.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javacto.po.DangdangOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
@Repository
public interface DangdangOrderMapper extends BaseMapper<DangdangOrder> {
    /**
     * 管理员根据id修改订单
     */
    public void updateOrderManage(DangdangOrder dangdangOrder);

    /**
     * 模糊查询订单信息
     * @param dangdangOrder
     * @return
     */
    public List<DangdangOrder> queryNumberAndName(DangdangOrder dangdangOrder);

}
