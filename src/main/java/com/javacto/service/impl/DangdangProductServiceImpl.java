package com.javacto.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javacto.po.DangdangProduct;
import com.javacto.mapper.DangdangProductMapper;
import com.javacto.service.DangdangProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
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
public class DangdangProductServiceImpl extends ServiceImpl<DangdangProductMapper, DangdangProduct> implements DangdangProductService {

    @Autowired
    DangdangProductMapper dangdangProductMapper;

    public IPage<DangdangProduct> queryAll(IPage<DangdangProduct> page){
        return dangdangProductMapper.queryAll(page);
    }

    /**
     * 根据pcChildId查询全部
     * @param page
     * @param dangdangProduct
     * @param dpcParentId
     * @return
     */
    public IPage<DangdangProduct> queryAllBydpcChildId(IPage<DangdangProduct> page,@Param("product")DangdangProduct dangdangProduct,@Param("dpcParentId")Integer dpcParentId){
        return dangdangProductMapper.queryAllBydpcChildId(page,dangdangProduct,dpcParentId);
    }

    public void updateProductManage(DangdangProduct dangdangProduct){
        dangdangProductMapper.updateProductManage(dangdangProduct);
    }
}
