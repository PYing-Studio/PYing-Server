package com.sysu.pojo;
public class Yueyin {
    private Integer id;
    private String username;
    private Integer orderId;
    private Integer num;
    private Integer leaveNum;
    private String friends;
    private Integer status;
    private Integer movieId;
    private String movieName;
    private String cinemaId;
    private String cinemaName;
    private java.util.Date showTime;
    public Yueyin() {
        super();
    }
    public Yueyin(Integer id,String username,Integer orderId,Integer num,Integer leaveNum,String friends,Integer status,Integer movieId,String movieName,String cinemaId,String cinemaName,java.util.Date showTime) {
        super();
        this.id = id;
        this.username = username;
        this.orderId = orderId;
        this.num = num;
        this.leaveNum = leaveNum;
        this.friends = friends;
        this.status = status;
        this.movieId = movieId;
        this.movieName = movieName;
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.showTime = showTime;
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

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public String getFriends() {
        return this.friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getCinemaId() {
        return this.cinemaId;
    }

    public void setCinemaId(String cinemaId) {
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

}
