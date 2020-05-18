package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {
    /**
     * 条件加分页
     */
    PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);

    /**
     * 分页
     * @param page：当前
     * @param size：每页显示条数
     */
    PageInfo<Brand> findPage(Integer page,Integer size);

    /**
     *根据品牌信息多条件搜索
     */
    List<Brand> findList(Brand brand);

    /**
     * 删除
     */
    void delete(Integer id);
    /**
     * 修改
     */
    void update(Brand brand);

    /**
     * 增加品牌
     */
    void add(Brand brand);


    /**
     * 根据id查询所有品牌
     */
    Brand findById(Integer id);


    /**
     * 查询所有品牌
     * @return
     */
    List<Brand> findAll();
}
