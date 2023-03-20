package com.javacto.service.impl;

import com.javacto.po.DangdangProduct;
import com.javacto.po.DangdangShopping;
import com.javacto.mapper.DangdangShoppingMapper;
import com.javacto.service.DangdangProductService;
import com.javacto.service.DangdangShoppingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
@Service
public class DangdangShoppingServiceImpl extends ServiceImpl<DangdangShoppingMapper, DangdangShopping> implements DangdangShoppingService {

    @Autowired
    DangdangShoppingMapper dangdangShoppingMapper;

    @Autowired
    DangdangProductService dangdangProductService;

    /**
     * 根据用户id查询购物车
     */
    public List<DangdangShopping> queryAllById(Integer doUserId){
        return dangdangShoppingMapper.queryByDoUserId(doUserId);
    }
    /**
     * 将物品添加到购物车
     *
     * @param doUserId
     * @param dpId
     * @return
     */
    public List<DangdangShopping> queryByDoUserId(Integer doUserId, Integer dpId) {
        //把所有购物车中商品集合查询出来
        List<DangdangShopping> dangdangShoppings = dangdangShoppingMapper.queryByDoUserId(doUserId);
        for (int i = 0; i < dangdangShoppings.size(); i++) {
            //把每次循环出来的dangdangShoppings存起来
            DangdangShopping c = dangdangShoppings.get(i);
            //如果之前添加过这个商品，加一
            if (dpId.equals(c.getDpId())) {
                c.setDodQuantity(c.getDodQuantity() + 1);
                c.setDodCost(c.getDodQuantity() * c.getProduct().getDpPrice());
                //修改dangdangShoppings中的值
                dangdangShoppings.set(i, c);
                //在这里在数据库添加购买数量和价格 根据商品id
                dangdangShoppingMapper.updateIdAndQuantity(c);
                return dangdangShoppingMapper.queryByDoUserId(doUserId);
            }
        }
        DangdangProduct dangdangProduct = dangdangProductService.getById(dpId);

        DangdangShopping dangdangShopping1 = new DangdangShopping();
        dangdangShopping1.setDoUserId(doUserId);
        dangdangShopping1.setDpId(dpId);
        dangdangShopping1.setDodQuantity(1);
        dangdangShopping1.setDodCost(dangdangProduct.getDpPrice());
        dangdangShopping1.setDoState(1);

        dangdangShoppingMapper.insertShopping(dangdangShopping1);

        return dangdangShoppingMapper.queryByDoUserId(doUserId);
    }

    public void updateIdAndQuantity(DangdangShopping dangdangShopping){
        dangdangShoppingMapper.updateIdAndQuantity(dangdangShopping);
    }

    public void deleteShopping(Integer dpId){
        dangdangShoppingMapper.deleteShopping(dpId);
    }

    public List<DangdangShopping> selectAll(){
        return dangdangShoppingMapper.selectAll();
    }
}
