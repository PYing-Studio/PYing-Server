package com.sysu.pojo;
public class Cinema {
    private Integer id;
    private String city;
    private String area;
    private String addr;
    private String name;
    private String maoyanjson;
    public Cinema() {
        super();
    }
    public Cinema(Integer id,String city,String area,String addr,String name,String maoyanjson) {
        super();
        this.id = id;
        this.city = city;
        this.area = area;
        this.addr = addr;
        this.name = name;
        this.maoyanjson = maoyanjson;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getMaoyanjson() {
        return this.maoyanjson;
    }

    public void setMaoyanjson(String maoyanjson) {
        this.maoyanjson = maoyanjson;
    }

}
