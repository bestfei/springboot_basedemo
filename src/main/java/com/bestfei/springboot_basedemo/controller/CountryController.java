package com.bestfei.springboot_basedemo.controller;

import com.bestfei.springboot_basedemo.entity.Country;
import com.bestfei.springboot_basedemo.service.CountryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Country)表控制层
 *
 * @author makejava
 * @since 2020-03-20 13:42:29
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
     */
    @GetMapping("selectOne")
    public Country selectOne(Integer id) {
        return this.countryService.queryById(id);
    }

    @GetMapping("selectAll")
    public List<Country> selectOne(Integer page, Integer pageSize) {
        return this.countryService.queryAllByLimit(page,pageSize);
    }


}