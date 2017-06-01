package com.sysu.mapper;
import com.sysu.pojo.Collect;
import java.util.List;
import com.sysu.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface CollectMapper{
    long getCollectRowCount(Assist assist);
    List<Collect> selectCollect(Assist assist);
    Collect selectCollectById(Integer id);
    int insertCollect(Collect value);
    int insertNonEmptyCollect(Collect value);
    int deleteCollectById(Integer id);
    int deleteCollect(Assist assist);
    int updateCollectById(Collect enti);
    int updateCollect(@Param("enti") Collect value, @Param("assist") Assist assist);
    int updateNonEmptyCollectById(Collect enti);
    int updateNonEmptyCollect(@Param("enti") Collect value, @Param("assist") Assist assist);
}