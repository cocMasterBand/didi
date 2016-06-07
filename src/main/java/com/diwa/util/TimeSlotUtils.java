package com.diwa.util;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hanruofei on 16/6/7.
 */
public class TimeSlotUtils {

    public static TimeDimension getPiece(Timestamp timestamp){
        TimeDimension timeDimension = new TimeDimension();
        timeDimension.setTimestamp(timestamp);

        Time time = new Time(timestamp.getTime());
        timeDimension.setPiece(time.getHours() * 6 + time.getMinutes() / 10 + 1);

        return timeDimension;
    }

    private static class TimeDimension{
        private Timestamp timestamp;
        private Integer piece;

        public Timestamp getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
        }

        public Integer getPiece() {
            return piece;
        }

        public void setPiece(Integer piece) {
            this.piece = piece;
        }
    }

    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

//        Time time = new Time(timestamp.getTime());
        Time time = java.sql.Time.valueOf("00:12:40");

        int hours = time.getHours();
        int minutes = time.getMinutes();

        int i = hours * 6 + minutes / 10 + 1;

        System.out.println(i);

        System.out.println(ToStringBuilder.reflectionToString(TimeSlotUtils.getPiece(new Timestamp(System.currentTimeMillis()))));
    }
}
