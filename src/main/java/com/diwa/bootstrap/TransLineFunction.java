package com.diwa.bootstrap;

/**
 * Created by di on 3/6/2016.
 *
 * 将一行数据 line
 * 变成一个结构体PO
 */
public abstract class TransLineFunction<T> {
    abstract T deal(String line);
}
