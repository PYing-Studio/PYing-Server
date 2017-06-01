package com.sysu.pojo;
public class Order {
    private Integer id;
    private String username;
    private Integer movieId;
    private String moveName;
    private Integer cinemaId;
    private String cinemaName;
    private java.util.Date showTime;
    private java.util.Date payTime;
    private java.util.Date makeTime;
    private Integer num;
    private String seat;
    private Integer statue;
    public Order() {
        super();
    }
    public Order(Integer id,String username,Integer movieId,String moveName,Integer cinemaId,String cinemaName,java.util.Date showTime,java.util.Date payTime,java.util.Date makeTime,Integer num,String seat,Integer statue) {
        super();
        this.id = id;
        this.username = username;
        this.movieId = movieId;
        this.moveName = moveName;
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.showTime = showTime;
        this.payTime = payTime;
        this.makeTime = makeTime;
        this.num = num;
        this.seat = seat;
        this.statue = statue;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getMovieId() {
        return this.movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMoveName() {
        return this.moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
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

    public Integer getStatue() {
        return this.statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

}
