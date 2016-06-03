package com.diwa.trafficdata.model;

import java.sql.Timestamp;

public class TrafficData {
    private Integer id;

    private String districtHash;

    private String tjLevel;

    private String tjTime;

    private Timestamp trafficTime;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TrafficData{");
        sb.append("id=").append(id);
        sb.append(", districtHash='").append(districtHash).append('\'');
        sb.append(", tjLevel='").append(tjLevel).append('\'');
        sb.append(", tjTime='").append(tjTime).append('\'');
        sb.append(", trafficTime=").append(trafficTime);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrictHash() {
        return districtHash;
    }

    public void setDistrictHash(String districtHash) {
        this.districtHash = districtHash;
    }

    public String getTjLevel() {
        return tjLevel;
    }

    public void setTjLevel(String tjLevel) {
        this.tjLevel = tjLevel;
    }

    public String getTjTime() {
        return tjTime;
    }

    public void setTjTime(String tjTime) {
        this.tjTime = tjTime;
    }

    public Timestamp getTrafficTime() {
        return trafficTime;
    }

    public void setTrafficTime(Timestamp trafficTime) {
        this.trafficTime = trafficTime;
    }
}