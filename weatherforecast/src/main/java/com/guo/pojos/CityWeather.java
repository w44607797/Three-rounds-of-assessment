package com.guo.pojos;

import org.apache.ibatis.type.Alias;



@Alias("CityWeather")
public class CityWeather {
    private String fxDate;
    private int tempMax;
    private int tempMin;
    private String textDay;
    private int cityId;

    public CityWeather(String fxDate,int tempMax,int tempMin,String textDay,int cityId){
        this.fxDate = fxDate;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.textDay = textDay;
        this.cityId = cityId;
    }
    public CityWeather(){
    }


    public String getFxDate() {
        return fxDate;
    }

    public void setFxDate(String fxDate) {
        this.fxDate = fxDate;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }

    @Override
    public String toString() {
        return "CityWeather{" +
                "fxDate=" + fxDate +
                ", tempMax=" + tempMax +
                ", tempMin=" + tempMin +
                ", textDay='" + textDay + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
