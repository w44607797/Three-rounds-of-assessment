package com.guo.mapper;

import com.guo.pojos.City;


public interface CityMapper {
    int getCityIdByName(String cityName);
    int insertCity(City city);
    City getCityWeather(String name);
    //数据库相同城市相同日期的数据只留最新的一个
    void deleteSame();


}
