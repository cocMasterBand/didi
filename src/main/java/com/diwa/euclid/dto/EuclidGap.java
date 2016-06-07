package com.diwa.euclid.dto;

/**
 * Created by di on 7/6/2016.
 */
public class EuclidGap {
    private int request;
    private int response;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EuclidGap{");
        sb.append("request=").append(request);
        sb.append(", response=").append(response);
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
}
