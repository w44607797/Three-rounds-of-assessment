package com.guo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.guo.pojos.CityWeather;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class GetCityWeatherUtil {
    private static OkHttpApi api;
    static {
        api = new OkHttpApi();
    }
        public static List<CityWeather> getCityWeather(String cityName) throws IOException, ParseException {
        int cityId = getCityId(cityName);
        String run = api.run("https://devapi.qweather.com/v7/weather/3d?location=" + cityId + "&key=fd5bf61e7716410dbb0d7968186793c1");
        JSONObject jsonObject = JSONObject.parseObject(run);
        JSONArray jsonArray = jsonObject.getJSONArray("daily");
        List<CityWeather> cityWeathersList = new ArrayList<>();
        for(int i = 0;i<jsonArray.size();i++){
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            cityWeathersList.add(new CityWeather(
                    jsonObject2.getString("fxDate"),
                    Integer.parseInt(jsonObject2.getString("tempMax")),
                    Integer.parseInt(jsonObject2.getString("tempMin")),
                    jsonObject2.getString("textDay"),
                    cityId
            ));
        }
        return cityWeathersList;
    }
    private static int getCityId(String cityName) throws IOException {
        String run = api.run("https://geoapi.qweather.com/v2/city/lookup?location="+cityName+"&number=1&key=fd5bf61e7716410dbb0d7968186793c1");
        JSONObject jsonObject = JSONObject.parseObject(run);
        JSONArray locationArr = jsonObject.getJSONArray("location");
        JSONObject jsonObject2 = locationArr.getJSONObject(0);
        String CityId = jsonObject2.getString("id");
        return Integer.parseInt(CityId);
    }
}
