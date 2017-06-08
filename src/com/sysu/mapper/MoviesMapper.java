package com.sysu.mapper;
import com.sysu.pojo.Movies;
import java.util.List;
import com.sysu.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface MoviesMapper{
    long getMoviesRowCount(Assist assist);
    List<Movies> selectMovies(Assist assist);
    Movies selectMoviesById(Integer id);
    int insertMovies(Movies value);
    int insertNonEmptyMovies(Movies value);
    int deleteMoviesById(Integer id);
    int deleteMovies(Assist assist);
    int updateMoviesById(Movies enti);
    int updateMovies(@Param("enti") Movies value, @Param("assist") Assist assist);
    int updateNonEmptyMoviesById(Movies enti);
    int updateNonEmptyMovies(@Param("enti") Movies value, @Param("assist") Assist assist);
}