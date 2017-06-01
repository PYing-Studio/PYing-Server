package com.sysu.pojo;

import java.io.Serializable;

public class HotMovie implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
    private Integer is3d;
    private String cat;
    private Integer cnms;
    private String director;
    private Integer dur;
    private Integer imax;
    private String img;
    private Integer late;
    private String name;
    private Integer pn;
    private Integer presale;
    private String rt;
    private Double sc;
    private String scm;
    private String showdata;
    private String showinfo;
    private Integer sn;
    private Integer snum;
    private String src;
    private String star;
    private String time;
    private String vd;
    private String ver;
    private Integer wish;
    private String maoyanjson;
    public HotMovie() {
        super();
    }
    public HotMovie(Integer id,Integer is3d,String cat,Integer cnms,String director,Integer dur,Integer imax,String img,Integer late,String name,Integer pn,Integer presale,String rt,Double sc,String scm,String showdata,String showinfo,Integer sn,Integer snum,String src,String star,String time,String vd,String ver,Integer wish,String maoyanjson) {
        super();
        this.id = id;
        this.is3d = is3d;
        this.cat = cat;
        this.cnms = cnms;
        this.director = director;
        this.dur = dur;
        this.imax = imax;
        this.img = img;
        this.late = late;
        this.name = name;
        this.pn = pn;
        this.presale = presale;
        this.rt = rt;
        this.sc = sc;
        this.scm = scm;
        this.showdata = showdata;
        this.showinfo = showinfo;
        this.sn = sn;
        this.snum = snum;
        this.src = src;
        this.star = star;
        this.time = time;
        this.vd = vd;
        this.ver = ver;
        this.wish = wish;
        this.maoyanjson = maoyanjson;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIs3d() {
        return this.is3d;
    }

    public void setIs3d(Integer is3d) {
        this.is3d = is3d;
    }

    public String getCat() {
        return this.cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Integer getCnms() {
        return this.cnms;
    }

    public void setCnms(Integer cnms) {
        this.cnms = cnms;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDur() {
        return this.dur;
    }

    public void setDur(Integer dur) {
        this.dur = dur;
    }

    public Integer getImax() {
        return this.imax;
    }

    public void setImax(Integer imax) {
        this.imax = imax;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getLate() {
        return this.late;
    }

    public void setLate(Integer late) {
        this.late = late;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPn() {
        return this.pn;
    }

    public void setPn(Integer pn) {
        this.pn = pn;
    }

    public Integer getPresale() {
        return this.presale;
    }

    public void setPresale(Integer presale) {
        this.presale = presale;
    }

    public String getRt() {
        return this.rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public Double getSc() {
        return this.sc;
    }

    public void setSc(Double sc) {
        this.sc = sc;
    }

    public String getScm() {
        return this.scm;
    }

    public void setScm(String scm) {
        this.scm = scm;
    }

    public String getShowdata() {
        return this.showdata;
    }

    public void setShowdata(String showdata) {
        this.showdata = showdata;
    }

    public String getShowinfo() {
        return this.showinfo;
    }

    public void setShowinfo(String showinfo) {
        this.showinfo = showinfo;
    }

    public Integer getSn() {
        return this.sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public Integer getSnum() {
        return this.snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public String getSrc() {
        return this.src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getStar() {
        return this.star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVd() {
        return this.vd;
    }

    public void setVd(String vd) {
        this.vd = vd;
    }

    public String getVer() {
        return this.ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public Integer getWish() {
        return this.wish;
    }

    public void setWish(Integer wish) {
        this.wish = wish;
    }

    public String getMaoyanjson() {
        return this.maoyanjson;
    }

    public void setMaoyanjson(String maoyanjson) {
        this.maoyanjson = maoyanjson;
    }

}
