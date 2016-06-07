package com.diwa.bootstrap;

import com.diwa.euclid.dto.EuclidGap;
import com.diwa.euclid.dto.EuclidUniq;
import com.diwa.euclid.mapper.EuclidMapper;
import com.diwa.euclid.model.Euclid;
import com.diwa.orderdata.model.OrderData;
import com.diwa.util.TimeSlotUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by di on 4/6/2016.
 */
public class DidiEuclidMain {
    private static final Logger logger = LoggerFactory.getLogger(OrderReader.class);

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/root-context.xml");

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        EuclidMapper euclidMapper = (EuclidMapper) applicationContext.getBean("euclidMapper");

        //先读取内容 , 划分时间片
        Map<EuclidUniq, EuclidGap> allMap = new HashMap<>();

        BootStrap.getOrderDataFilePath().forEach(path -> {

            System.out.println("path" + path + "begin");
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

                String str = "";

                int count = 0;
                while ((str = bufferedReader.readLine()) != null) {
                    count++;
                    if (count % 100000 == 0) System.out.println(String.format("file:%s, count:%s", path, count));
                    OrderData reduce = deal(str);
                    TimeSlotUtils.TimeDimension piece = TimeSlotUtils.getPiece(reduce.getOrderTime());
                    EuclidUniq uniq = new EuclidUniq();
                    uniq.setDate(piece.getTimestamp());
                    uniq.setPiece(piece.getPiece());
                    uniq.setHash(reduce.getStartDistrictHash());

                    if (allMap.containsKey(uniq)) {
                        EuclidGap euclidGap = allMap.get(uniq);
                        if (reduce.getDriverId() != null) {
                            euclidGap.setRequest(euclidGap.getRequest() + 1);
                            euclidGap.setResponse(euclidGap.getResponse() + 1);
                        } else {
                            euclidGap.setRequest(euclidGap.getRequest() + 1);
                        }
                    } else {
                        EuclidGap gap = new EuclidGap();
                        gap.setRequest(1);
                        gap.setResponse(reduce.getDriverId() == null ? 0 : 1);

                        allMap.put(uniq, gap);
                    }
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
            System.out.println("path" + path + "end");
        });

        List<Euclid> euclids = new ArrayList<>();
        int count = 0;
        for (Map.Entry<EuclidUniq, EuclidGap> entry : allMap.entrySet()) {
            count ++;
            Euclid euclid = new Euclid();
            euclid.setDate(entry.getKey().getDate());
            euclid.setTimePiece(entry.getKey().getPiece());

            euclid.setRequest(entry.getValue().getRequest());
            euclid.setResponse(entry.getValue().getResponse());
            euclid.setStartHash(entry.getKey().getHash());

            euclids.add(euclid);

            if (count == 1000){
                System.out.println("1k, insert" );

                try {
                    euclidMapper.insertBatch(euclids);
                }catch (Exception e){
                    e.printStackTrace();
                }
                euclids = new ArrayList<>();
                count = 0;
            }
        }
        //剩余所有
        euclidMapper.insertBatch(euclids);



    }

    private static OrderData deal(String line) {
        String[] split = line.split("\\t");
        OrderData orderData = new OrderData();
        orderData.setOrderId(split[0]);
        orderData.setDriverId("NULL".equals(split[1]) ? null : split[1]);
        orderData.setPassengerId(split[2]);
        orderData.setStartDistrictHash(split[3]);
        orderData.setDestDistrictHash(split[4]);
        double parseDouble = 0D;
        try {
            parseDouble = Double.parseDouble(split[5]);
        } catch (Exception e) {
        }
        orderData.setPrice(parseDouble);
        orderData.setTime(split[6]);
        orderData.setOrderTime(getTimeByStr(split[6]));
        return orderData;
    }

    private static Timestamp getTimeByStr(String string) {
        Timestamp timestamp;
        Date parse = new Date();
        try {
            parse = sdf.parse(string);
        } catch (Exception e) {

        }
        timestamp = new Timestamp(parse.getTime());

        return timestamp;
    }

}
