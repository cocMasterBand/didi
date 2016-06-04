package com.diwa.bootstrap;

import com.diwa.orderdata.mapper.OrderDataMapper;
import com.diwa.orderdata.model.OrderData;
import com.diwa.util.ConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by di on 3/6/2016.
 */
public class BootStrap {
    private static final Logger logger = LoggerFactory.getLogger(BootStrap.class);

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/root-context.xml");

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        logger.info("BootStrap Main begin.");

        OrderDataMapper orderDataMapper = (OrderDataMapper) applicationContext.getBean("orderDataMapper");

        //        sample 4 OrderData
        getOrderDataFilePath().forEach(path -> {
            new Thread(new Worker<OrderDataMapper, OrderData>(
                    orderDataMapper,
                    "insertBatch",
                    path,
                    new TransLineFunction<OrderData>() {
                        @Override
                        OrderData deal(String line) {
                            String[] split = line.split("\\t");
                            OrderData orderData = new OrderData();
                            orderData.setOrderId(split[0]);
                            orderData.setDriverId("NULL".equals(split[1]) ? null : split[1]);
                            orderData.setPassengerId(split[2]);
                            orderData.setStartDistrictHash(split[3]);
                            orderData.setDestDistrictHash(split[4]);
                            orderData.setPrice(Double.parseDouble(split[5]));
                            orderData.setTime(split[6]);
                            orderData.setOrderTime(getTimeByStr(split[6]));
                            return orderData;
                        }
                    }
            ) {
            }).start();
        });
    }

    private static Timestamp getTimeByStr(String string) {
        Timestamp timestamp;
        Date parse = new Date();
        try {
            parse = sdf.parse(string);
        } catch (ParseException e) {

        }
        timestamp = new Timestamp(parse.getTime());

        return timestamp;
    }

    private static List<String> getOrderDataFilePath() {
        return new ArrayList<>(Arrays.asList("/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-01",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-02",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-03",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-04",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-05",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-06",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-07",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-08",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-09",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-10",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-11",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-12",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-13",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-14",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-15",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-16",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-17",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-18",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-19",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-20",
                "/Users/di/Desktop/didi/season_1/training_data/order_data/order_data_2016-01-21"));
    }
}
