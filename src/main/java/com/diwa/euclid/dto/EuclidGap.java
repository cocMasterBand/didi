package com.diwa.euclid.dto;

/**
 * Created by di on 7/6/2016.
 */
public class EuclidGap {
    private int request;
    private int response;
    private String start_from_hash;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EuclidGap{");
        sb.append("request=").append(request);
        sb.append(", response=").append(response);
        sb.append(", start_from_hash='").append(start_from_hash).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public String getStart_from_hash() {
        return start_from_hash;
    }

    public void setStart_from_hash(String start_from_hash) {
        this.start_from_hash = start_from_hash;
    }
}
