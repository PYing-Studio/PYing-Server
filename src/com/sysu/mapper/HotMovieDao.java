package com.sysu.mapper;
import com.sysu.pojo.HotMovie;
import java.util.List;
import com.sysu.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface HotMovieDao{
    long getHotMovieRowCount(Assist assist);
    List<HotMovie> selectHotMovie(Assist assist);
    HotMovie selectHotMovieById(Integer id);
    int insertHotMovie(HotMovie value);
    int insertNonEmptyHotMovie(HotMovie value);
    int deleteHotMovieById(Integer id);
    int deleteHotMovie(Assist assist);
    int updateHotMovieById(HotMovie enti);
    int updateHotMovie(@Param("enti") HotMovie value, @Param("assist") Assist assist);
    int updateNonEmptyHotMovieById(HotMovie enti);
    int updateNonEmptyHotMovie(@Param("enti") HotMovie value, @Param("assist") Assist assist);
}