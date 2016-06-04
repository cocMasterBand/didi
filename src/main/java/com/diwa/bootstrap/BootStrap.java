package com.diwa.bootstrap;

import com.diwa.constant.FileNameConstant;
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
import java.util.Date;
import java.util.List;

/**
 * Created by di on 3/6/2016.
 */
public class BootStrap {
    private static final Logger logger = LoggerFactory.getLogger(BootStrap.class);

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/root-context.xml");

    private static ConfigUtils configUtils = applicationContext.getBean(ConfigUtils.class);

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        logger.info("BootStrap Main begin.");


        OrderDataMapper orderDataMapper = applicationContext.getBean(OrderDataMapper.class);


        List list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            OrderData orderData = new OrderData();
            orderData.setDriverId(i + "");
            orderData.setOrderId(i + "");
            orderData.setPassengerId(i + "");
            orderData.setDestDistrictHash(i + "");
            orderData.setStartDistrictHash(i + "");
            orderData.setPrice((double) i);
            orderData.setTime("2016-06-03 18:06:0" + i);
            orderData.setOrderTime(new Timestamp(System.currentTimeMillis()));
            list.add(orderData);
        }

        orderDataMapper.insertBatch(list);

//        sample 4 OrderData
        new Thread(new Worker<OrderDataMapper, OrderData>(
                orderDataMapper,
                "insert",
                configUtils.getString(FileNameConstant.ORDER_DATA_PATH),
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
}
