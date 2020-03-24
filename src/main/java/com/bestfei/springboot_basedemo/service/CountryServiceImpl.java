package com.bestfei.springboot_basedemo.service;

import com.bestfei.springboot_basedemo.entity.Country;
import com.bestfei.springboot_basedemo.dao.CountryDao;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Country)表服务实现类
 *
 * @author makejava
 * @since 2020-03-20 13:42:27
 */
@Service("countryService")
public class CountryServiceImpl implements CountryService {
    @Resource
    private CountryDao countryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Country queryById(Integer id) {
        return this.countryDao.queryById(id);
    }

    @Override
    public Country queryById2(Integer id) {
        return this.countryDao.queryById2(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Country> queryAllByLimit(int offset, int limit) {
        List<Country> result = null;
        try {
            // 调用pagehelper分页，采用starPage方式。starPage应放在Mapper查询函数之前,sql语句必须加 count(*) as count
            PageHelper.startPage(offset, limit); //每页的大小为pageSize，查询第page页的结果
            PageHelper.orderBy("count DESC "); //进行分页结果的排序
            return this.countryDao.queryAllByLimit(offset, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 新增数据
     *
     * @param country 实例对象
     * @return 实例对象
     */
    @Override
    public Country insert(Country country) {
        this.countryDao.insert(country);
        return country;
    }

    /**
     * 修改数据
     *
     * @param country 实例对象
     * @return 实例对象
     */
    @Override
    public Country update(Country country) {
        this.countryDao.update(country);
        return this.queryById(country.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.countryDao.deleteById(id) > 0;
    }
}