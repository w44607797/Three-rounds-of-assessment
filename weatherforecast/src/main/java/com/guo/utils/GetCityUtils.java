package com.guo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.guo.pojos.City;

import java.io.IOException;
import java.util.List;

public class GetCityUtils {
    private static OkHttpApi api;
    static {
        api = new OkHttpApi();
    }
    public static City getLocation(String cityName) throws IOException {
        String run = api.run("https://geoapi.qweather.com/v2/city/lookup?location="+cityName+"&number=1&key=fd5bf61e7716410dbb0d7968186793c1");
        JSONObject jsonObject = JSONObject.parseObject(run);
        String message = jsonObject.getString("location");
        List<City> cities = JSON.parseArray(message, City.class);
        return cities.get(0);
    }
}
