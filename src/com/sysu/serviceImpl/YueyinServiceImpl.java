package com.sysu.serviceImpl;
import java.util.List;
import com.sysu.mapper.YueyinMapper;
import com.sysu.pojo.Yueyin;
import com.sysu.common.Assist;
import com.sysu.service.YueyinService;
public class YueyinServiceImpl implements YueyinService{
    private YueyinMapper yueyinMapper;
    @Override
    public long getYueyinRowCount(Assist assist){
        return yueyinMapper.getYueyinRowCount(assist);
    }
    @Override
    public List<Yueyin> selectYueyin(Assist assist){
        return yueyinMapper.selectYueyin(assist);
    }
    @Override
    public Yueyin selectYueyinById(Integer id){
        return yueyinMapper.selectYueyinById(id);
    }
    @Override
    public int insertYueyin(Yueyin value){
        return yueyinMapper.insertYueyin(value);
    }
    @Override
    public int insertNonEmptyYueyin(Yueyin value){
        return yueyinMapper.insertNonEmptyYueyin(value);
    }
    @Override
    public int deleteYueyinById(Integer id){
        return yueyinMapper.deleteYueyinById(id);
    }
    @Override
    public int deleteYueyin(Assist assist){
        return yueyinMapper.deleteYueyin(assist);
    }
    @Override
    public int updateYueyinById(Yueyin enti){
        return yueyinMapper.updateYueyinById(enti);
    }
    @Override
    public int updateYueyin(Yueyin value, Assist assist){
        return yueyinMapper.updateYueyin(value,assist);
    }
    @Override
    public int updateNonEmptyYueyinById(Yueyin enti){
        return yueyinMapper.updateNonEmptyYueyinById(enti);
    }
    @Override
    public int updateNonEmptyYueyin(Yueyin value, Assist assist){
        return yueyinMapper.updateNonEmptyYueyin(value,assist);
    }

    public YueyinMapper getYueyinMapper() {
        return this.yueyinMapper;
    }

    public void setYueyinMapper(YueyinMapper yueyinMapper) {
        this.yueyinMapper = yueyinMapper;
    }

}