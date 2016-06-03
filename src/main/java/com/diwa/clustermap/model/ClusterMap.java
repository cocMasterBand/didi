package com.diwa.clustermap.model;

public class ClusterMap {
    private Integer id;

    private String districtHash;

    private String districtId;

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

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId == null ? null : districtId.trim();
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuffer sb = new java.lang.StringBuffer("ClusterMap{");
        sb.append("id=").append(id);
        sb.append(", districtHash='").append(districtHash).append('\'');
        sb.append(", districtId='").append(districtId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}