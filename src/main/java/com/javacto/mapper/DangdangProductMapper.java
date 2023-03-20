package com.javacto.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javacto.po.DangdangProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

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
public interface DangdangProductMapper extends BaseMapper<DangdangProduct> {

    /**
     * 查询产品全部
     * @return
     */
    public IPage<DangdangProduct> queryAll(IPage<DangdangProduct>page);
    /**
     * 根据dpcChildId找到该分类下的数据
     * @param dpcParentId
     * @return
     */
    public IPage<DangdangProduct> queryAllBydpcChildId(IPage<DangdangProduct> page,@Param("product")DangdangProduct dangdangProduct,@Param("dpcParentId")Integer dpcParentId);

    /**
     * 修改管理中的商品
     * @param dangdangProduct
     */
    public void updateProductManage(DangdangProduct dangdangProduct);
}
