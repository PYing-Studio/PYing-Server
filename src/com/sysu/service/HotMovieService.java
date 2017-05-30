package com.sysu.service;
import java.util.List;
import com.sysu.pojo.HotMovie;
import com.sysu.common.Assist;
public interface HotMovieService{
    long getHotMovieRowCount(Assist assist);
    List<HotMovie> selectHotMovie(Assist assist);
    HotMovie selectHotMovieById(Integer id);
    int insertHotMovie(HotMovie value);
    int insertNonEmptyHotMovie(HotMovie value);
    int deleteHotMovieById(Integer id);
    int deleteHotMovie(Assist assist);
    int updateHotMovieById(HotMovie enti);
    int updateHotMovie(HotMovie value, Assist assist);
    int updateNonEmptyHotMovieById(HotMovie enti);
    int updateNonEmptyHotMovie(HotMovie value, Assist assist);
}