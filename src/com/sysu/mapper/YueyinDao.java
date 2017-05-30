package com.sysu.mapper;
import com.sysu.pojo.Yueyin;
import java.util.List;
import com.sysu.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface YueyinDao{
    long getYueyinRowCount(Assist assist);
    List<Yueyin> selectYueyin(Assist assist);
    Yueyin selectYueyinById(Integer id);
    int insertYueyin(Yueyin value);
    int insertNonEmptyYueyin(Yueyin value);
    int deleteYueyinById(Integer id);
    int deleteYueyin(Assist assist);
    int updateYueyinById(Yueyin enti);
    int updateYueyin(@Param("enti") Yueyin value, @Param("assist") Assist assist);
    int updateNonEmptyYueyinById(Yueyin enti);
    int updateNonEmptyYueyin(@Param("enti") Yueyin value, @Param("assist") Assist assist);
}