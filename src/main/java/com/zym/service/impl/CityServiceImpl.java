package com.zym.service.impl;

import com.zym.beans.City;
import com.zym.dao.CityDao;
import com.zym.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"com.zym"})
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;


    /**
     * 获取城市信息列表
     *
     * @return
     */
    @Override
    public List<City> findAllCity() {
        return cityDao.findAllCity();
    }

    /**
     * 根据城市 ID,获取城市信息
     *
     * @param id
     * @return
     */
    @Override
    public City findCityById(Long id) {
        return cityDao.findById(id);
    }

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    @Override
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    @Override
    public Long updateCity(City city) {
        return cityDao.updateCity(city);
    }

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    @Override
    public Long deleteCity(Long id) {
        return cityDao.deleteCity(id);
    }
}
