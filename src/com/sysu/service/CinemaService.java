package com.sysu.service;
import java.util.List;
import com.sysu.pojo.Cinema;
import com.sysu.common.Assist;
public interface CinemaService{
    long getCinemaRowCount(Assist assist);
    List<Cinema> selectCinema(Assist assist);
    Cinema selectCinemaById(Integer id);
    int insertCinema(Cinema value);
    int insertNonEmptyCinema(Cinema value);
    int deleteCinemaById(Integer id);
    int deleteCinema(Assist assist);
    int updateCinemaById(Cinema enti);
    int updateCinema(Cinema value, Assist assist);
    int updateNonEmptyCinemaById(Cinema enti);
    int updateNonEmptyCinema(Cinema value, Assist assist);
    
    List<Cinema> getCinemas(String city, String area);
}