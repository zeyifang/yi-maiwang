package com.javacto.service.impl;

import com.javacto.po.DangdangProductCategory;
import com.javacto.mapper.DangdangProductCategoryMapper;
import com.javacto.service.DangdangProductCategoryService;
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
public class DangdangProductCategoryServiceImpl extends ServiceImpl<DangdangProductCategoryMapper, DangdangProductCategory> implements DangdangProductCategoryService {

    @Autowired
    private DangdangProductCategoryMapper productCategoryMapper;

    @Override
    public List<DangdangProductCategory> queryDpcParentIdBydpcId(Integer pid) {
        return productCategoryMapper.queryDpcParentIdBydpcId(pid);
    }

    public void addProductCateManage(DangdangProductCategory dangdangProductCategory){
        productCategoryMapper.addProductCateManage(dangdangProductCategory);
    }

    public int selectMaxDpcId(Integer dpcParentId){
        return productCategoryMapper.selectMaxDpcId(dpcParentId);
    }
}
