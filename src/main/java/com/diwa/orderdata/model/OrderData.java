package com.diwa.orderdata.model;

import java.sql.Timestamp;

public class OrderData {
    private Integer id;

    private String orderId;

    private String driverId;

    private String passengerId;

    private String startDistrictHash;

    private String destDistrictHash;

    private Double price;

    private String time;

    private Timestamp orderTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId == null ? null : passengerId.trim();
    }

    public String getStartDistrictHash() {
        return startDistrictHash;
    }

    public void setStartDistrictHash(String startDistrictHash) {
        this.startDistrictHash = startDistrictHash == null ? null : startDistrictHash.trim();
    }

    public String getDestDistrictHash() {
        return destDistrictHash;
    }

    public void setDestDistrictHash(String destDistrictHash) {
        this.destDistrictHash = destDistrictHash == null ? null : destDistrictHash.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderData{");
        sb.append("id=").append(id);
        sb.append(", orderId='").append(orderId).append('\'');
        sb.append(", driverId='").append(driverId).append('\'');
        sb.append(", passengerId='").append(passengerId).append('\'');
        sb.append(", startDistrictHash='").append(startDistrictHash).append('\'');
        sb.append(", destDistrictHash='").append(destDistrictHash).append('\'');
        sb.append(", price=").append(price);
        sb.append(", time='").append(time).append('\'');
        sb.append(", orderTime=").append(orderTime);
        sb.append('}');
        return sb.toString();
    }
}