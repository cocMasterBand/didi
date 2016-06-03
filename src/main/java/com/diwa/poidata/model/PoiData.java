package com.diwa.poidata.model;

public class PoiData {
    private Integer id;

    private String districtHash;

    private String poiClass;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PoiData{");
        sb.append("id=").append(id);
        sb.append(", districtHash='").append(districtHash).append('\'');
        sb.append(", poiClass='").append(poiClass).append('\'');
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
        this.districtHash = districtHash == null ? null : districtHash.trim();
    }

    public String getPoiClass() {
        return poiClass;
    }

    public void setPoiClass(String poiClass) {
        this.poiClass = poiClass == null ? null : poiClass.trim();
    }
}