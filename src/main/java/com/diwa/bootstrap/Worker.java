package com.diwa.bootstrap;

import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

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

            while ((str = bufferedReader.readLine()) != null) {
                P reduce = transLineFunction.deal(str);
                insert.invoke(dao, reduce);
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
