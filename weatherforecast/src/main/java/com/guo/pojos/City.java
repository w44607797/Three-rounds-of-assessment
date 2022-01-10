package com.guo.pojos;


import com.guo.utils.CityToStringUtil;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("City")
public class City {
    private String name;
    private int id;
    private double lat;
    private double lon;
    private List<CityWeather> cityWeatherList;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public List<CityWeather> getCityWeatherList() {
        return cityWeatherList;
    }

    public void setCityWeatherList(List<CityWeather> cityWeatherList) {
        this.cityWeatherList = cityWeatherList;
    }

    @Override
    public String toString() {
        return CityToStringUtil.getString(this);
    }
}
