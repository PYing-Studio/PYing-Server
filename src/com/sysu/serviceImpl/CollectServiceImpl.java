package com.sysu.serviceImpl;
import java.util.List;
import com.sysu.mapper.CollectDao;
import com.sysu.pojo.Collect;
import com.sysu.common.Assist;
import com.sysu.service.CollectService;
public class CollectServiceImpl implements CollectService{
    private CollectDao collectDao;
    @Override
    public long getCollectRowCount(Assist assist){
        return collectDao.getCollectRowCount(assist);
    }
    @Override
    public List<Collect> selectCollect(Assist assist){
        return collectDao.selectCollect(assist);
    }
    @Override
    public Collect selectCollectById(Integer id){
        return collectDao.selectCollectById(id);
    }
    @Override
    public int insertCollect(Collect value){
        return collectDao.insertCollect(value);
    }
    @Override
    public int insertNonEmptyCollect(Collect value){
        return collectDao.insertNonEmptyCollect(value);
    }
    @Override
    public int deleteCollectById(Integer id){
        return collectDao.deleteCollectById(id);
    }
    @Override
    public int deleteCollect(Assist assist){
        return collectDao.deleteCollect(assist);
    }
    @Override
    public int updateCollectById(Collect enti){
        return collectDao.updateCollectById(enti);
    }
    @Override
    public int updateCollect(Collect value, Assist assist){
        return collectDao.updateCollect(value,assist);
    }
    @Override
    public int updateNonEmptyCollectById(Collect enti){
        return collectDao.updateNonEmptyCollectById(enti);
    }
    @Override
    public int updateNonEmptyCollect(Collect value, Assist assist){
        return collectDao.updateNonEmptyCollect(value,assist);
    }

    public CollectDao getCollectDao() {
        return this.collectDao;
    }

    public void setCollectDao(CollectDao collectDao) {
        this.collectDao = collectDao;
    }

}