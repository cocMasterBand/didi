package com.diwa.bootstrap;

import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by di on 3/6/2016.
 */
public abstract class Worker<D, P> implements Runnable {
    private D dao;  //PO的dao
    private String methodName = "insert";  //对应dao的方法 默认insert
    private String path;    //文件路径
    private TransLineFunction<P> transLineFunction;     //将文件的一行, 变成一个PO的方法

    public Worker() {
    }

    public Worker(D dao, String methodName, String path, TransLineFunction<P> transLineFunction) {
        this.dao = dao;
        this.methodName = methodName;
        this.path = path;
        this.transLineFunction = transLineFunction;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

            String str = "";
            Method insert = dao.getClass().getMethod(methodName);
            Assert.notNull(insert, "get dao error!");

            int count = 0;
            List<P> bufferList = new ArrayList<>();

            //1000个一批, 写入db
            while ((str = bufferedReader.readLine()) != null) {
                P reduce = transLineFunction.deal(str);
                count++;

                if (count == 1000){
                    this.putInDb(bufferList);
                    bufferList = Collections.emptyList();
                }
            }

            //将剩余的加入
            this.putInDb(bufferList);

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    private void putInDb(List<P> bufferList){

    }
}
