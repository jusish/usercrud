package com.spring.usercrud.classes;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String district;
    private String sector;
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
}
