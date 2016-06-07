package com.diwa.bootstrap;

import com.diwa.euclid.mapper.EuclidMapper;
import com.diwa.orderdata.model.OrderData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by di on 4/6/2016.
 */
public class DidiEuclidMain {
    private static final Logger logger = LoggerFactory.getLogger(OrderReader.class);

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/root-context.xml");

    public static void main(String[] args) {

        EuclidMapper euclidMapper = (EuclidMapper) applicationContext.getBean("euclidMapper");

        //先读取内容 , 划分时间片
        BootStrap.getOrderDataFilePath().forEach(path -> {

            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

                String str = "";

                int sum = 0;
                int count = 0;
                List<OrderData> bufferList = new ArrayList<>();

                while ((str = bufferedReader.readLine()) != null) {
                    sum++;

                }

            } catch (Exception e) {
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                    }
                }
            }
        });
    }


}
