package com.diwa.weatherdata.model;

import java.sql.Timestamp;

public class WeatherData {
    private Integer id;

    private String time;

    private Integer weather;

    private Integer temperature;

    private Integer pm;

    private Timestamp weaterTime;

    //增加天气的时间切片，只为计算数据用
    private Integer weatherPeriod;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WeatherData{");
        sb.append("id=").append(id);
        sb.append(", time='").append(time).append('\'');
        sb.append(", weather=").append(weather);
        sb.append(", temperature=").append(temperature);
        sb.append(", pm=").append(pm);
        sb.append(", weaterTime=").append(weaterTime);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getWeather() {
        return weather;
    }

    public void setWeather(Integer weather) {
        this.weather = weather;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getPm() {
        return pm;
    }

    public void setPm(Integer pm) {
        this.pm = pm;
    }

    public Timestamp getWeaterTime() {
        return weaterTime;
    }

    public void setWeaterTime(Timestamp weaterTime) {
        this.weaterTime = weaterTime;
    }

    public Integer getWeatherPeriod() {
        return weatherPeriod;
    }

    public void setWeatherPeriod(Integer weatherPeriod) {
        this.weatherPeriod = weatherPeriod;
    }
}