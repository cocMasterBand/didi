package com.diwa.util;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by hanruofei on 16/6/7.
 */
public class TimeSlotUtils {

    public static TimeDimension getPiece(Timestamp timestamp){
        TimeDimension timeDimension = new TimeDimension();

        Time time = new Time(timestamp.getTime());
        timeDimension.setPiece(time.getHours() * 6 + time.getMinutes() / 10 + 1);

        timestamp.setHours(0);
        timestamp.setMinutes(0);
        timestamp.setSeconds(0);
        timestamp.setNanos(0);
        timeDimension.setTimestamp(timestamp);
        return timeDimension;
    }

    public static class TimeDimension{
        private Timestamp timestamp;
        private Integer piece;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TimeDimension)) return false;

            TimeDimension that = (TimeDimension) o;

            if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
            return piece != null ? piece.equals(that.piece) : that.piece == null;

        }

        @Override
        public int hashCode() {
            int result = timestamp != null ? timestamp.hashCode() : 0;
            result = 31 * result + (piece != null ? piece.hashCode() : 0);
            return result;
        }

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
