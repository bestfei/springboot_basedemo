package com.bestfei.springboot_basedemo.dao;

import com.bestfei.springboot_basedemo.entity.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Country)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-20 11:50:57
 */
@Repository
public interface CountryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select({
            " select " +
                    "  id, countryame, createdAt, updatedAt, currency " +
                    "  from appashman.country " +
                    "  where id = #{id} " +
                    "  group by id"
    })
    Country queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Select({
            " select " +
                    "  id, countryame, createdAt, updatedAt, currency, count(*) as count " +
                    "  from appashman.country " +
                    "  group by id"
    })
    List<Country> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param country 实例对象
     * @return 对象列表
     */
    List<Country> queryAll(Country country);

    /**
     * 新增数据
     *
     * @param country 实例对象
     * @return 影响行数
     */
    int insert(Country country);

    /**
     * 修改数据
     *
     * @param country 实例对象
     * @return 影响行数
     */
    int update(Country country);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}