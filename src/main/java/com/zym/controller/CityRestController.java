package com.zym.controller;

import com.zym.beans.City;
import com.zym.service.CityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @ApiOperation(value = "根据城市id获取城市信息", notes = "")
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @ApiOperation(value = "获取所有城市信息列表", notes = "GET请求")
    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @ApiOperation(value = "保存城市接口", notes = "POST请求")
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @ApiOperation(value = "更新城市接口", notes = "PUT请求")
    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @ApiOperation(value = "删除城市接口", notes = "DELETE请求")
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
