package com.avioApplication.entity;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class CitiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long city_id;

    @Column(name = "city_name")
    private String city_name;

    @Column(name = "country_name")
    private String country_name;

    public CitiesEntity(Long city_id, String city_name, String country_name) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.country_name = country_name;
    }

    public CitiesEntity(){

    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
