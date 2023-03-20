package com.javacto.service;

import com.javacto.po.DangdangOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javacto.po.DangdangUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
public interface DangdangOrderService extends IService<DangdangOrder> {
    /**
     * 添加订单和订单详情
     */
    public void addOrderAndDetail(Integer dpId, DangdangUser dangdangUser);

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
