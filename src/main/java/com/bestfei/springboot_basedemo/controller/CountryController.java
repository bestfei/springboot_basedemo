package com.bestfei.springboot_basedemo.controller;

import com.bestfei.springboot_basedemo.entity.Country;
import com.bestfei.springboot_basedemo.service.CountryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Country)表控制层
 *
 */
@RestController
@RequestMapping("country")
public class CountryController {
    /**
     * 服务对象
     */
    @Resource
    private CountryService countryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     * http://127.0.0.1:8081/country/selectOne?id=1000
     * 写法一 映射xml文件
     */
    @GetMapping("selectOne")
    public Country selectOne(Integer id) {
        return this.countryService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     * http://127.0.0.1:8081/country/selectOne?id=1000
     * 写法二 映射xml文件
     */
    @GetMapping("selectOne2")
    public Country selectOne2(Integer id) {
        return this.countryService.queryById2(id);
    }

    // http://127.0.0.1:8081/country/selectAll?page=1&pageSize=2
    @GetMapping("selectAll")
    public List<Country> selectOne(Integer page, Integer pageSize) {
        return this.countryService.queryAllByLimit(page,pageSize);
    }


}