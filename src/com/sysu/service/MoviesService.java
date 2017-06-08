package com.sysu.service;
import java.util.List;
import com.sysu.pojo.Movies;
import com.sysu.common.Assist;
public interface MoviesService{
    List<Movies> searchMovies(String keyWord);
    
    long getMoviesRowCount(Assist assist);
    List<Movies> selectMovies(Assist assist);
    Movies selectMoviesById(Integer id);
    int insertMovies(Movies value);
    int insertNonEmptyMovies(Movies value);
    int deleteMoviesById(Integer id);
    int deleteMovies(Assist assist);
    int updateMoviesById(Movies enti);
    int updateMovies(Movies value, Assist assist);
    int updateNonEmptyMoviesById(Movies enti);
    int updateNonEmptyMovies(Movies value, Assist assist);
}