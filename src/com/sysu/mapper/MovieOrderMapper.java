package com.sysu.mapper;
import com.sysu.pojo.MovieOrder;
import java.util.List;
import com.sysu.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface MovieOrderMapper{
    long getMovieOrderRowCount(Assist assist);
    List<MovieOrder> selectMovieOrder(Assist assist);
    MovieOrder selectMovieOrderById(Integer id);
    int insertMovieOrder(MovieOrder value);
    int insertNonEmptyMovieOrder(MovieOrder value);
    int deleteMovieOrderById(Integer id);
    int deleteMovieOrder(Assist assist);
    int updateMovieOrderById(MovieOrder enti);
    int updateMovieOrder(@Param("enti") MovieOrder value, @Param("assist") Assist assist);
    int updateNonEmptyMovieOrderById(MovieOrder enti);
    int updateNonEmptyMovieOrder(@Param("enti") MovieOrder value, @Param("assist") Assist assist);
}