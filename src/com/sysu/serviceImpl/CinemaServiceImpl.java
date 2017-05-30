package com.sysu.serviceImpl;
import java.util.List;
import com.sysu.mapper.CinemaDao;
import com.sysu.pojo.Cinema;
import com.sysu.common.Assist;
import com.sysu.service.CinemaService;
public class CinemaServiceImpl implements CinemaService{
    private CinemaDao cinemaDao;
    @Override
    public long getCinemaRowCount(Assist assist){
        return cinemaDao.getCinemaRowCount(assist);
    }
    @Override
    public List<Cinema> selectCinema(Assist assist){
        return cinemaDao.selectCinema(assist);
    }
    @Override
    public Cinema selectCinemaById(Integer id){
        return cinemaDao.selectCinemaById(id);
    }
    @Override
    public int insertCinema(Cinema value){
        return cinemaDao.insertCinema(value);
    }
    @Override
    public int insertNonEmptyCinema(Cinema value){
        return cinemaDao.insertNonEmptyCinema(value);
    }
    @Override
    public int deleteCinemaById(Integer id){
        return cinemaDao.deleteCinemaById(id);
    }
    @Override
    public int deleteCinema(Assist assist){
        return cinemaDao.deleteCinema(assist);
    }
    @Override
    public int updateCinemaById(Cinema enti){
        return cinemaDao.updateCinemaById(enti);
    }
    @Override
    public int updateCinema(Cinema value, Assist assist){
        return cinemaDao.updateCinema(value,assist);
    }
    @Override
    public int updateNonEmptyCinemaById(Cinema enti){
        return cinemaDao.updateNonEmptyCinemaById(enti);
    }
    @Override
    public int updateNonEmptyCinema(Cinema value, Assist assist){
        return cinemaDao.updateNonEmptyCinema(value,assist);
    }

    public CinemaDao getCinemaDao() {
        return this.cinemaDao;
    }

    public void setCinemaDao(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }

}