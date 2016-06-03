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
    private D dao;
    private Class clazz;
    private String path;


    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

            String str = "";
            Method insert = dao.getClass().getMethod("insert");
            Assert.notNull(insert, "get dao error!");

            while ((str = bufferedReader.readLine()) != null) {
                P reduce = reduce(str);
                insert.invoke(dao, reduce);
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    protected abstract P reduce(String line);
}
