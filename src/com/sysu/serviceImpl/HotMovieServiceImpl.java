package com.sysu.serviceImpl;
import java.util.List;
import com.sysu.mapper.HotMovieDao;
import com.sysu.pojo.HotMovie;
import com.sysu.common.Assist;
import com.sysu.service.HotMovieService;
public class HotMovieServiceImpl implements HotMovieService{
    private HotMovieDao hotMovieDao;
    @Override
    public long getHotMovieRowCount(Assist assist){
        return hotMovieDao.getHotMovieRowCount(assist);
    }
    @Override
    public List<HotMovie> selectHotMovie(Assist assist){
        return hotMovieDao.selectHotMovie(assist);
    }
    @Override
    public HotMovie selectHotMovieById(Integer id){
        return hotMovieDao.selectHotMovieById(id);
    }
    @Override
    public int insertHotMovie(HotMovie value){
        return hotMovieDao.insertHotMovie(value);
    }
    @Override
    public int insertNonEmptyHotMovie(HotMovie value){
        return hotMovieDao.insertNonEmptyHotMovie(value);
    }
    @Override
    public int deleteHotMovieById(Integer id){
        return hotMovieDao.deleteHotMovieById(id);
    }
    @Override
    public int deleteHotMovie(Assist assist){
        return hotMovieDao.deleteHotMovie(assist);
    }
    @Override
    public int updateHotMovieById(HotMovie enti){
        return hotMovieDao.updateHotMovieById(enti);
    }
    @Override
    public int updateHotMovie(HotMovie value, Assist assist){
        return hotMovieDao.updateHotMovie(value,assist);
    }
    @Override
    public int updateNonEmptyHotMovieById(HotMovie enti){
        return hotMovieDao.updateNonEmptyHotMovieById(enti);
    }
    @Override
    public int updateNonEmptyHotMovie(HotMovie value, Assist assist){
        return hotMovieDao.updateNonEmptyHotMovie(value,assist);
    }

    public HotMovieDao getHotMovieDao() {
        return this.hotMovieDao;
    }

    public void setHotMovieDao(HotMovieDao hotMovieDao) {
        this.hotMovieDao = hotMovieDao;
    }

}