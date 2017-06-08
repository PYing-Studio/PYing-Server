package com.sysu.pojo;
public class MovieOrder {
    private Integer id;
    private Integer status;
    private Integer hasYueyin;
    private String username;
    private Integer showTimeId;
    private Integer movieId;
    private String movieName;
    private Integer cinemaId;
    private String cinemaName;
    private java.util.Date showTime;
    private java.util.Date payTime;
    private java.util.Date makeTime;
    private Integer num;
    private String seat;
    public MovieOrder() {
        super();
    }
    public MovieOrder(Integer id,Integer status,Integer hasYueyin,String username,Integer showTimeId,Integer movieId,String movieName,Integer cinemaId,String cinemaName,java.util.Date showTime,java.util.Date payTime,java.util.Date makeTime,Integer num,String seat) {
        super();
        this.id = id;
        this.status = status;
        this.hasYueyin = hasYueyin;
        this.username = username;
        this.showTimeId = showTimeId;
        this.movieId = movieId;
        this.movieName = movieName;
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.showTime = showTime;
        this.payTime = payTime;
        this.makeTime = makeTime;
        this.num = num;
        this.seat = seat;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHasYueyin() {
        return this.hasYueyin;
    }

    public void setHasYueyin(Integer hasYueyin) {
        this.hasYueyin = hasYueyin;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getShowTimeId() {
        return this.showTimeId;
    }

    public void setShowTimeId(Integer showTimeId) {
        this.showTimeId = showTimeId;
    }

    public Integer getMovieId() {
        return this.movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public java.util.Date getShowTime() {
        return this.showTime;
    }

    public void setShowTime(java.util.Date showTime) {
        this.showTime = showTime;
    }

    public java.util.Date getPayTime() {
        return this.payTime;
    }

    public void setPayTime(java.util.Date payTime) {
        this.payTime = payTime;
    }

    public java.util.Date getMakeTime() {
        return this.makeTime;
    }

    public void setMakeTime(java.util.Date makeTime) {
        this.makeTime = makeTime;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSeat() {
        return this.seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

}
