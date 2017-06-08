package com.sysu.pojo;
public class IntheaterMovie {
    private Integer id;
    private Integer movieId;
    private Integer cinemaId;
    private String cinemaName;
    private String movieName;
    private Integer num;
    private Integer leaveNum;
    private String seat;
    private java.util.Date showTime;
    private String maoyanjson;
    public IntheaterMovie() {
        super();
    }
    public IntheaterMovie(Integer id,Integer movieId,Integer cinemaId,String cinemaName,String movieName,Integer num,Integer leaveNum,String seat,java.util.Date showTime,String maoyanjson) {
        super();
        this.id = id;
        this.movieId = movieId;
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.movieName = movieName;
        this.num = num;
        this.leaveNum = leaveNum;
        this.seat = seat;
        this.showTime = showTime;
        this.maoyanjson = maoyanjson;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return this.movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getCinemaId() {
        return this.cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return this.cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getLeaveNum() {
        return this.leaveNum;
    }

    public void setLeaveNum(Integer leaveNum) {
        this.leaveNum = leaveNum;
    }

    public String getSeat() {
        return this.seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public java.util.Date getShowTime() {
        return this.showTime;
    }

    public void setShowTime(java.util.Date showTime) {
        this.showTime = showTime;
    }

    public String getMaoyanjson() {
        return this.maoyanjson;
    }

    public void setMaoyanjson(String maoyanjson) {
        this.maoyanjson = maoyanjson;
    }

}
