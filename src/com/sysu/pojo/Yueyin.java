package com.sysu.pojo;
public class Yueyin {
    private Integer id;
    private String username;
    private Integer movieId;
    private String moveName;
    private String cinemaId;
    private String cinemaName;
    private java.util.Date time;
    private Integer num;
    private String friends;
    private Integer statue;
    public Yueyin() {
        super();
    }
    public Yueyin(Integer id,String username,Integer movieId,String moveName,String cinemaId,String cinemaName,java.util.Date time,Integer num,String friends,Integer statue) {
        super();
        this.id = id;
        this.username = username;
        this.movieId = movieId;
        this.moveName = moveName;
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.time = time;
        this.num = num;
        this.friends = friends;
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

    public java.util.Date getTime() {
        return this.time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getFriends() {
        return this.friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public Integer getStatue() {
        return this.statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

}
