package com.sysu.mapper;
import com.sysu.pojo.Cinema;
import java.util.List;
import com.sysu.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface CinemaMapper{
    long getCinemaRowCount(Assist assist);
    List<Cinema> selectCinema(Assist assist);
    Cinema selectCinemaById(Integer id);
    int insertCinema(Cinema value);
    int insertNonEmptyCinema(Cinema value);
    int deleteCinemaById(Integer id);
    int deleteCinema(Assist assist);
    int updateCinemaById(Cinema enti);
    int updateCinema(@Param("enti") Cinema value, @Param("assist") Assist assist);
    int updateNonEmptyCinemaById(Cinema enti);
    int updateNonEmptyCinema(@Param("enti") Cinema value, @Param("assist") Assist assist);
}