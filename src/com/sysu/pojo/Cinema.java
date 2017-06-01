package com.sysu.pojo;

import java.io.Serializable;

public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
    private Integer cityId;
    private String cityName;
    private String addr;
    private String name;
    private Double lat;
    private Double lng;
    private String maoyanjson;
    public Cinema() {
        super();
    }
    public Cinema(Integer id,Integer cityId,String cityName,String addr,String name,Double lat,Double lng,String maoyanjson) {
        super();
        this.id = id;
        this.cityId = cityId;
        this.cityName = cityName;
        this.addr = addr;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.maoyanjson = maoyanjson;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return this.cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddr() {
        return this.addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return this.lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return this.lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getMaoyanjson() {
        return this.maoyanjson;
    }

    public void setMaoyanjson(String maoyanjson) {
        this.maoyanjson = maoyanjson;
    }

}
