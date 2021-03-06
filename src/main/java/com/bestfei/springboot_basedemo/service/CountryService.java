package com.bestfei.springboot_basedemo.service;

import com.bestfei.springboot_basedemo.entity.Country;
import java.util.List;

/**
 * (Country)表服务接口
 *
 * @author makejava
 * @since 2020-03-20 13:42:24
 */
public interface CountryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Country queryById(Integer id);

    Country queryById2(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Country> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param country 实例对象
     * @return 实例对象
     */
    Country insert(Country country);

    /**
     * 修改数据
     *
     * @param country 实例对象
     * @return 实例对象
     */
    Country update(Country country);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}