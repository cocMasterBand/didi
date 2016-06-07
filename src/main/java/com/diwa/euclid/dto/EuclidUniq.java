package com.diwa.euclid.dto;

import java.sql.Timestamp;

/**
 * Created by di on 8/6/2016.
 */
public class EuclidUniq {
    private Timestamp date;
    private int piece;
    private String hash;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EuclidUniq)) return false;

        EuclidUniq that = (EuclidUniq) o;

        if (piece != that.piece) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return hash != null ? hash.equals(that.hash) : that.hash == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + piece;
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EuclidUniq{");
        sb.append("date=").append(date);
        sb.append(", piece=").append(piece);
        sb.append(", hash='").append(hash).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
