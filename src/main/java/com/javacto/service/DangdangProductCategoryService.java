package com.javacto.service;

import com.javacto.po.DangdangProductCategory;
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
public interface DangdangProductCategoryService extends IService<DangdangProductCategory> {

    /**
     * 根据parentid查询pid
     */
    public List<DangdangProductCategory> queryDpcParentIdBydpcId(Integer pid);

    /**
     *
     * 添加分类
     */
    public void addProductCateManage(DangdangProductCategory dangdangProductCategory);
    /**
     * 根据父分类id查询子类最大Id
     */
    public int selectMaxDpcId(Integer dpcParentId);
}
