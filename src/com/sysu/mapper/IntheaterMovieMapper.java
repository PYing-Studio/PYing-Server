package com.sysu.mapper;
import com.sysu.pojo.IntheaterMovie;
import java.util.List;
import com.sysu.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface IntheaterMovieMapper{
    long getIntheaterMovieRowCount(Assist assist);
    List<IntheaterMovie> selectIntheaterMovie(Assist assist);
    IntheaterMovie selectIntheaterMovieById(Integer id);
    int insertIntheaterMovie(IntheaterMovie value);
    int insertNonEmptyIntheaterMovie(IntheaterMovie value);
    int deleteIntheaterMovieById(Integer id);
    int deleteIntheaterMovie(Assist assist);
    int updateIntheaterMovieById(IntheaterMovie enti);
    int updateIntheaterMovie(@Param("enti") IntheaterMovie value, @Param("assist") Assist assist);
    int updateNonEmptyIntheaterMovieById(IntheaterMovie enti);
    int updateNonEmptyIntheaterMovie(@Param("enti") IntheaterMovie value, @Param("assist") Assist assist);
}