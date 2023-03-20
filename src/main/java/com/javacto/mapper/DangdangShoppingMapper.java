package com.javacto.mapper;

import com.javacto.po.DangdangShopping;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
@Component
public interface DangdangShoppingMapper extends BaseMapper<DangdangShopping> {
    /**
     * 根据商品id查询购物车表以及关联商品表
     * @param doUserId
     * @return
     */
    public List<DangdangShopping> queryByDoUserId(Integer doUserId);

    /**
     *根据商品id修改购买数量以及此商品总价
     */
    public void updateIdAndQuantity(DangdangShopping dangdangShopping);

    /**
     * 添加新的商品到购物车
     */
    public void insertShopping(DangdangShopping dangdangShopping);
    /**
     * 删除购物车
     */
    public void deleteShopping(Integer dpId);
    /**
     * 查询全部包括商品
     */
    public List<DangdangShopping> selectAll();
}
