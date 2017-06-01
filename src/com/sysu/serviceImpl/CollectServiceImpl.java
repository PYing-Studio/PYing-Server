package com.sysu.serviceImpl;
import java.util.List;
import com.sysu.mapper.CollectMapper;
import com.sysu.pojo.Collect;
import com.sysu.common.Assist;
import com.sysu.service.CollectService;
public class CollectServiceImpl implements CollectService{
    private CollectMapper collectMapper;
    @Override
    public long getCollectRowCount(Assist assist){
        return collectMapper.getCollectRowCount(assist);
    }
    @Override
    public List<Collect> selectCollect(Assist assist){
        return collectMapper.selectCollect(assist);
    }
    @Override
    public Collect selectCollectById(Integer id){
        return collectMapper.selectCollectById(id);
    }
    @Override
    public int insertCollect(Collect value){
        return collectMapper.insertCollect(value);
    }
    @Override
    public int insertNonEmptyCollect(Collect value){
        return collectMapper.insertNonEmptyCollect(value);
    }
    @Override
    public int deleteCollectById(Integer id){
        return collectMapper.deleteCollectById(id);
    }
    @Override
    public int deleteCollect(Assist assist){
        return collectMapper.deleteCollect(assist);
    }
    @Override
    public int updateCollectById(Collect enti){
        return collectMapper.updateCollectById(enti);
    }
    @Override
    public int updateCollect(Collect value, Assist assist){
        return collectMapper.updateCollect(value,assist);
    }
    @Override
    public int updateNonEmptyCollectById(Collect enti){
        return collectMapper.updateNonEmptyCollectById(enti);
    }
    @Override
    public int updateNonEmptyCollect(Collect value, Assist assist){
        return collectMapper.updateNonEmptyCollect(value,assist);
    }

    public CollectMapper getCollectMapper() {
        return this.collectMapper;
    }

    public void setCollectMapper(CollectMapper collectMapper) {
        this.collectMapper = collectMapper;
    }

}