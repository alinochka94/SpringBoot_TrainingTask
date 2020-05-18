package com.avioApplication.entity;

public class AirportData {
    private String airport_name;
    private String iata_code;
    private String icao_code;
    private String latitude;
    private String longitude;
    private String geoname_id;
    private String timezone;
    private String gmt;
    private Object phone_number;
    private String country_name;
    private String country_iso2;
    private String city_iata_code;

    public AirportData(){

    }

    public AirportData(String airport_name, String iata_code, String icao_code,
                          String latitude, String longitude, String geoname_id, String timezone,
                          String gmt, Object phone_number, String country_name, String country_iso2,
                          String city_iata_code) {
        this.airport_name = airport_name;
        this.iata_code = iata_code;
        this.icao_code = icao_code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.geoname_id = geoname_id;
        this.timezone = timezone;
        this.gmt = gmt;
        this.phone_number = phone_number;
        this.country_name = country_name;
        this.country_iso2 = country_iso2;
        this.city_iata_code = city_iata_code;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    public String getIcao_code() {
        return icao_code;
    }

    public void setIcao_code(String icao_code) {
        this.icao_code = icao_code;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getGeoname_id() {
        return geoname_id;
    }

    public void setGeoname_id(String geoname_id) {
        this.geoname_id = geoname_id;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getGmt() {
        return gmt;
    }

    public void setGmt(String gmt) {
        this.gmt = gmt;
    }

    public Object getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Object phone_number) {
        this.phone_number = phone_number;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_iso2() {
        return country_iso2;
    }

    public void setCountry_iso2(String country_iso2) {
        this.country_iso2 = country_iso2;
    }

    public String getCity_iata_code() {
        return city_iata_code;
    }

    public void setCity_iata_code(String city_iata_code) {
        this.city_iata_code = city_iata_code;
    }
}
