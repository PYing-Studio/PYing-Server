package com.sysu.pojo;

import java.io.Serializable;

public class Collect implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
    private String username;
    private Integer movieId;
    private String movieName;
    public Collect() {
        super();
    }
    public Collect(Integer id,String username,Integer movieId,String movieName) {
        super();
        this.id = id;
        this.username = username;
        this.movieId = movieId;
        this.movieName = movieName;
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

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

}
