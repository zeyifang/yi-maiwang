package com.javacto.service.impl;

import com.javacto.mapper.DangdangOrderDetailMapper;
import com.javacto.mapper.DangdangProductMapper;
import com.javacto.po.DangdangOrder;
import com.javacto.mapper.DangdangOrderMapper;
import com.javacto.po.DangdangOrderDetail;
import com.javacto.po.DangdangProduct;
import com.javacto.po.DangdangUser;
import com.javacto.service.DangdangOrderDetailService;
import com.javacto.service.DangdangOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javacto.service.DangdangProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
@Service
@Transactional
public class DangdangOrderServiceImpl extends ServiceImpl<DangdangOrderMapper, DangdangOrder> implements DangdangOrderService {

    @Autowired
    DangdangOrderMapper dangdangOrderMapper;

    @Autowired
    DangdangOrderDetailMapper dangdangOrderDetailMapper;

    @Autowired
    DangdangProductMapper dangdangProductMapper;

    /**
     * 添加订单和订单详情
     */
    public void addOrderAndDetail(Integer dpId, DangdangUser dangdangUser){

        //查询该商品信息
        DangdangProduct dangdangProduct = dangdangProductMapper.selectById(dpId);
        //加入订单
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        DangdangOrder dangdangOrder = new DangdangOrder();
        dangdangOrder.setDoNumber(uuid);
        dangdangOrder.setDoUserId(dangdangUser.getDuUserId().toString());
        dangdangOrder.setDoUserName(dangdangUser.getDuUserName());
        dangdangOrder.setDoUserTel(dangdangUser.getDuMobile());
        dangdangOrder.setDoUserAddress(dangdangUser.getDuAddress());
        dangdangOrder.setDoCost(dangdangProduct.getDpPrice());
        java.util.Date date = new Date();//获得当前时间
        //Timestamp t = new Timestamp(date.getTime());//将时间转换成Timestamp类型，这样便可以存入到Mysql数据库中
        dangdangOrder.setDoCreateTime(date);
        dangdangOrder.setDoStatus(1);
        dangdangOrder.setDoType(1);
        dangdangOrderMapper.insert(dangdangOrder);
        //添加订单详情
        DangdangOrderDetail dangdangOrderDetail = new DangdangOrderDetail();
        dangdangOrderDetail.setOrderId(dangdangOrder.getDoId());
        dangdangOrderDetail.setProductId(dpId);
        dangdangOrderDetail.setProductNum(1);
        dangdangOrderDetail.setPrice(dangdangProduct.getDpPrice());
        dangdangOrderDetailMapper.insert(dangdangOrderDetail);
    }

    public void updateOrderManage(DangdangOrder dangdangOrder){
        dangdangOrderMapper.updateOrderManage(dangdangOrder);
    }

    public List<DangdangOrder> queryNumberAndName(DangdangOrder dangdangOrder){
        return dangdangOrderMapper.queryNumberAndName(dangdangOrder);
    }
}
