package com.sysu.pojo;
public class HotMovie {
    private Integer id;
    private String name;
    private String img;
    private String cat;
    private String star;
    private String sc;
    private String vd;
    private String dir;
    private Integer statue;
    private java.util.Date inserttime;
    private String maoyanjson;
    public HotMovie() {
        super();
    }
    public HotMovie(Integer id,String name,String img,String cat,String star,String sc,String vd,String dir,Integer statue,java.util.Date inserttime,String maoyanjson) {
        super();
        this.id = id;
        this.name = name;
        this.img = img;
        this.cat = cat;
        this.star = star;
        this.sc = sc;
        this.vd = vd;
        this.dir = dir;
        this.statue = statue;
        this.inserttime = inserttime;
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

    public Integer getStatue() {
        return this.statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public java.util.Date getInserttime() {
        return this.inserttime;
    }

    public void setInserttime(java.util.Date inserttime) {
        this.inserttime = inserttime;
    }

    public String getMaoyanjson() {
        return this.maoyanjson;
    }

    public void setMaoyanjson(String maoyanjson) {
        this.maoyanjson = maoyanjson;
    }

}
