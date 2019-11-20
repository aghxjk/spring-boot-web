package com.zym.dao;

import com.zym.beans.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CREATE TABLE `city` (
 *   `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
 *   `province_id` int(10) unsigned NOT NULL COMMENT '省份编号',
 *   `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
 *   `description` varchar(25) DEFAULT NULL COMMENT '描述',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
 */

public interface CityDao {

    /**
     * 获取城市信息列表
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID,获取城市信息
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
