package com.diwa.bootstrap;

import com.diwa.euclid.mapper.EuclidMapper;
import com.diwa.euclid.model.Euclid;
import com.diwa.util.TimeSlotUtils;
import com.diwa.weatherdata.mapper.WeatherDataMapper;
import com.diwa.weatherdata.model.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by leo on 16/6/12.
 */
public class HandleWeatherDatas {

    private static final Logger logger = LoggerFactory.getLogger(HandleWeatherDatas.class);

    private static final SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static final SimpleDateFormat dateFormater1 = new SimpleDateFormat("yyyy-MM-dd");

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        EuclidMapper euclidMapper = (EuclidMapper) applicationContext.getBean("euclidMapper");

        WeatherDataMapper weatherDataMapper = (WeatherDataMapper) applicationContext.getBean("weatherDataMapper");

        int i = 1;
        while (true) {
            System.out.println("开始处理第" + i + "批数据：");
            List<Euclid> toDoEuclid = euclidMapper.selectToDoEuclids();
            System.out.println("数据量：" + toDoEuclid.size());
            toDoEuclid.stream().forEach(param -> {
                List<WeatherData> weatherDataList = weatherDataMapper.selectByDate(param.getDate().toString());
                Integer period = param.getTimePiece();
                WeatherData weatherData = getWeatherData(weatherDataList, period);
                if (weatherData != null) {
                    param.setWeather(weatherData.getWeather());
                    param.setPm(weatherData.getPm());
                    param.setTemperature(weatherData.getTemperature());
                }
                euclidMapper.updateByPrimaryKey(param);
            });
            System.out.println("第一批数据处理结束");
            if (toDoEuclid.size() == 0) {
                break;
            }
            i++;
        }
    }

    static WeatherData getWeatherData(List<WeatherData> weatherDatas, Integer period) {
        WeatherData weatherData = null;
        weatherDatas.stream().forEach(param -> {
            TimeSlotUtils.TimeDimension timeDimension = TimeSlotUtils.getPiece(param.getWeaterTime());
            Integer weatherPeriod = timeDimension.getPiece();
            param.setWeatherPeriod(weatherPeriod);
        });

        for (int i = 0, len = weatherDatas.size(); i < len; i++) {
            int addOne = 0;
            while (weatherData == null) {
                Integer weatherPeriod = weatherDatas.get(i).getWeatherPeriod();
                Integer index = period + addOne;
                Integer outIndex = period - addOne;
                if (period.equals(weatherPeriod)) {
                    weatherData = weatherDatas.get(i);
                } else if (index.equals(weatherPeriod)) {
                    weatherData = weatherDatas.get(i);
                } else if (outIndex.equals(weatherPeriod)) {
                    weatherData = weatherDatas.get(i);
                }
                addOne++;
            }
        }
        return weatherData;
    }

    static Long getTimePeriod(String time) throws ParseException {
        return (dateFormater.parse(time).getTime() - dateFormater1.parse(time).getTime()) / 600000 + 1;
    }


}
