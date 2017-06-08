package com.sysu.service;
import java.util.List;
import com.sysu.pojo.IntheaterMovie;
import com.sysu.common.Assist;
public interface IntheaterMovieService{
    long getIntheaterMovieRowCount(Assist assist);
    List<IntheaterMovie> selectIntheaterMovie(Assist assist);
    IntheaterMovie selectIntheaterMovieById(Integer id);
    int insertIntheaterMovie(IntheaterMovie value);
    int insertNonEmptyIntheaterMovie(IntheaterMovie value);
    int deleteIntheaterMovieById(Integer id);
    int deleteIntheaterMovie(Assist assist);
    int updateIntheaterMovieById(IntheaterMovie enti);
    int updateIntheaterMovie(IntheaterMovie value, Assist assist);
    int updateNonEmptyIntheaterMovieById(IntheaterMovie enti);
    int updateNonEmptyIntheaterMovie(IntheaterMovie value, Assist assist);
    
    List<IntheaterMovie> getIntheaterMovie(Integer cinema_id, Integer movie_id);
}