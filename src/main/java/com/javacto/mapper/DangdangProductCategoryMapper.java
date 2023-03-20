package com.javacto.mapper;

import com.javacto.po.DangdangProductCategory;
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
public interface DangdangProductCategoryMapper extends BaseMapper<DangdangProductCategory> {

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
