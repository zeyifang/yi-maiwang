package com.javacto.service;

import com.javacto.po.DangdangShopping;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
public interface DangdangShoppingService extends IService<DangdangShopping> {

    /**
     * 根据用户id查询购物车
     */
    public List<DangdangShopping> queryAllById(Integer doUserId);

    public List<DangdangShopping> queryByDoUserId(Integer doUserId,Integer dpId);
    /**
     *根据商品id修改购买数量以及此商品总价
     */
    public void updateIdAndQuantity(DangdangShopping dangdangShopping);

    public void deleteShopping(Integer dpId);

    /**
     * 查询全部包括商品
     */
    public List<DangdangShopping> selectAll();

}
