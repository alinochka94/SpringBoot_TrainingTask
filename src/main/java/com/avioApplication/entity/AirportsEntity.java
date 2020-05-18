package com.avioApplication.entity;

import java.util.List;

public class AirportsEntity {
    Object pagination;
    List<AirportData> data;

    public AirportsEntity(){

    }

    public AirportsEntity(Object pagination, List<AirportData> data) {
        this.pagination = pagination;
        this.data = data;
    }

    public Object getPagination() {
        return pagination;
    }

    public void setPagination(Object pagination) {
        this.pagination = pagination;
    }

    public List<AirportData> getData() {
        return data;
    }

    public void setData(List<AirportData> data) {
        this.data = data;
    }
}
