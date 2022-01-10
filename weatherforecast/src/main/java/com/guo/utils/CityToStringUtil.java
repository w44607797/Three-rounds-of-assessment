package com.guo.utils;

import com.guo.pojos.City;
import com.guo.pojos.CityWeather;

import java.util.List;

public class CityToStringUtil {
    public static String getString(City city){
        StringBuilder sb = new StringBuilder();
        List<CityWeather> cityWeathers = city.getCityWeatherList();
        for(CityWeather cityWeather:cityWeathers){
            sb.append("City{" +
                    "name='" + city.getName() + '\'' +
                    ", id=" + city.getId() +
                    ", lat=" + city.getLat() +
                    ", lon=" + city.getLon() +
                    "  "+cityWeather+
                    '}'+"\n\r");
        }
        return String.valueOf(sb);
    }
}
