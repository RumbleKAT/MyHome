package com.rumblekat.myhome.Home;

import java.util.Objects;

public class HomeDto {
    private String startDt;
    private String endDt;
    private String houseSecd;
    private String sido;
    private String houseName;
    private String rentSecd;

    public HomeDto(String startDt, String endDt, String houseSecd, String sido, String houseName, String rentSecd) {
        this.startDt = startDt;
        this.endDt = endDt;
        this.houseSecd = houseSecd;
        this.sido = sido;
        this.houseName = houseName;
        this.rentSecd = rentSecd;
    }

    public String getStartDt() {
        return startDt;
    }

    public String getEndDt() {
        return endDt;
    }

    public String getHouseSecd() {
        return houseSecd;
    }

    public String getSido() {
        return sido;
    }

    public String getHouseName() {
        return houseName;
    }

    public String getRentSecd() {
        return rentSecd;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public void setHouseSecd(String houseSecd) {
        this.houseSecd = houseSecd;
    }

    public void setSido(String sido) {
        this.sido = sido;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public void setRentSecd(String rentSecd) {
        this.rentSecd = rentSecd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeDto homeDto = (HomeDto) o;
        return Objects.equals(startDt, homeDto.startDt) && Objects.equals(endDt, homeDto.endDt) && Objects.equals(houseSecd, homeDto.houseSecd) && Objects.equals(sido, homeDto.sido) && Objects.equals(houseName, homeDto.houseName) && Objects.equals(rentSecd, homeDto.rentSecd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDt, endDt, houseSecd, sido, houseName, rentSecd);
    }
}
