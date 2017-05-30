package com.sysu.serviceImpl;
import java.util.List;
import com.sysu.mapper.YueyinDao;
import com.sysu.pojo.Yueyin;
import com.sysu.common.Assist;
import com.sysu.service.YueyinService;
public class YueyinServiceImpl implements YueyinService{
    private YueyinDao yueyinDao;
    @Override
    public long getYueyinRowCount(Assist assist){
        return yueyinDao.getYueyinRowCount(assist);
    }
    @Override
    public List<Yueyin> selectYueyin(Assist assist){
        return yueyinDao.selectYueyin(assist);
    }
    @Override
    public Yueyin selectYueyinById(Integer id){
        return yueyinDao.selectYueyinById(id);
    }
    @Override
    public int insertYueyin(Yueyin value){
        return yueyinDao.insertYueyin(value);
    }
    @Override
    public int insertNonEmptyYueyin(Yueyin value){
        return yueyinDao.insertNonEmptyYueyin(value);
    }
    @Override
    public int deleteYueyinById(Integer id){
        return yueyinDao.deleteYueyinById(id);
    }
    @Override
    public int deleteYueyin(Assist assist){
        return yueyinDao.deleteYueyin(assist);
    }
    @Override
    public int updateYueyinById(Yueyin enti){
        return yueyinDao.updateYueyinById(enti);
    }
    @Override
    public int updateYueyin(Yueyin value, Assist assist){
        return yueyinDao.updateYueyin(value,assist);
    }
    @Override
    public int updateNonEmptyYueyinById(Yueyin enti){
        return yueyinDao.updateNonEmptyYueyinById(enti);
    }
    @Override
    public int updateNonEmptyYueyin(Yueyin value, Assist assist){
        return yueyinDao.updateNonEmptyYueyin(value,assist);
    }

    public YueyinDao getYueyinDao() {
        return this.yueyinDao;
    }

    public void setYueyinDao(YueyinDao yueyinDao) {
        this.yueyinDao = yueyinDao;
    }

}