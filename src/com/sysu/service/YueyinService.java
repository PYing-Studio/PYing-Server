package com.sysu.service;
import java.util.List;
import com.sysu.pojo.Yueyin;
import com.sysu.common.Assist;
public interface YueyinService{
    public List<Yueyin> getYueyinByUserName(String username);
    public List<Yueyin> getAllYueyin();
    
    long getYueyinRowCount(Assist assist);
    List<Yueyin> selectYueyin(Assist assist);
    Yueyin selectYueyinById(Integer id);
    int insertYueyin(Yueyin value);
    int insertNonEmptyYueyin(Yueyin value);
    int deleteYueyinById(Integer id);
    int deleteYueyin(Assist assist);
    int updateYueyinById(Yueyin enti);
    int updateYueyin(Yueyin value, Assist assist);
    int updateNonEmptyYueyinById(Yueyin enti);
    int updateNonEmptyYueyin(Yueyin value, Assist assist);
}