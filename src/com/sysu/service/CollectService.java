package com.sysu.service;
import java.util.List;
import com.sysu.pojo.Collect;
import com.sysu.common.Assist;
public interface CollectService{
    long getCollectRowCount(Assist assist);
    List<Collect> selectCollect(Assist assist);
    Collect selectCollectById(Integer id);
    int insertCollect(Collect value);
    int insertNonEmptyCollect(Collect value);
    int deleteCollectById(Integer id);
    int deleteCollect(Assist assist);
    int updateCollectById(Collect enti);
    int updateCollect(Collect value, Assist assist);
    int updateNonEmptyCollectById(Collect enti);
    int updateNonEmptyCollect(Collect value, Assist assist);
}