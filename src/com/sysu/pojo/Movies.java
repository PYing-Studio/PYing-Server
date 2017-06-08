package com.sysu.pojo;
public class Movies {
    private Integer id;
    private String name;
    private String img;
    private String cat;
    private String star;
    private String sc;
    private String vd;
    private String dir;
    private String dra;
    private String maoyanjson;
    public Movies() {
        super();
    }
    public Movies(Integer id,String name,String img,String cat,String star,String sc,String vd,String dir,String dra,String maoyanjson) {
        super();
        this.id = id;
        this.name = name;
        this.img = img;
        this.cat = cat;
        this.star = star;
        this.sc = sc;
        this.vd = vd;
        this.dir = dir;
        this.dra = dra;
        this.maoyanjson = maoyanjson;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCat() {
        return this.cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getStar() {
        return this.star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getSc() {
        return this.sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getVd() {
        return this.vd;
    }

    public void setVd(String vd) {
        this.vd = vd;
    }

    public String getDir() {
        return this.dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDra() {
        return this.dra;
    }

    public void setDra(String dra) {
        this.dra = dra;
    }

    public String getMaoyanjson() {
        return this.maoyanjson;
    }

    public void setMaoyanjson(String maoyanjson) {
        this.maoyanjson = maoyanjson;
    }

}
