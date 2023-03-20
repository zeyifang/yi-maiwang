package com.javacto.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javacto.po.DangdangProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
public interface DangdangProductService extends IService<DangdangProduct> {

    /**
     * 查询全部产品
     * @return
     */
    public IPage<DangdangProduct> queryAll(IPage<DangdangProduct> page);


    /**
     *根据dpcChildId查询产品信息
     * @param page
     * @return
     */
    public IPage<DangdangProduct> queryAllBydpcChildId(IPage<DangdangProduct> page,@Param("product")DangdangProduct dangdangProduct,@Param("dpcParentId")Integer dpcParentId);

    /**
     * 修改管理中的商品
     * @param dangdangProduct
     */
    public void updateProductManage(DangdangProduct dangdangProduct);
}
