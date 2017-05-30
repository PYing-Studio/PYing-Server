package com.sysu.serviceImpl;
import java.util.List;
import com.sysu.mapper.MoviesDao;
import com.sysu.pojo.Movies;
import com.sysu.common.Assist;
import com.sysu.service.MoviesService;
public class MoviesServiceImpl implements MoviesService{
    private MoviesDao moviesDao;
    @Override
    public long getMoviesRowCount(Assist assist){
        return moviesDao.getMoviesRowCount(assist);
    }
    @Override
    public List<Movies> selectMovies(Assist assist){
        return moviesDao.selectMovies(assist);
    }
    @Override
    public Movies selectMoviesById(Integer id){
        return moviesDao.selectMoviesById(id);
    }
    @Override
    public int insertMovies(Movies value){
        return moviesDao.insertMovies(value);
    }
    @Override
    public int insertNonEmptyMovies(Movies value){
        return moviesDao.insertNonEmptyMovies(value);
    }
    @Override
    public int deleteMoviesById(Integer id){
        return moviesDao.deleteMoviesById(id);
    }
    @Override
    public int deleteMovies(Assist assist){
        return moviesDao.deleteMovies(assist);
    }
    @Override
    public int updateMoviesById(Movies enti){
        return moviesDao.updateMoviesById(enti);
    }
    @Override
    public int updateMovies(Movies value, Assist assist){
        return moviesDao.updateMovies(value,assist);
    }
    @Override
    public int updateNonEmptyMoviesById(Movies enti){
        return moviesDao.updateNonEmptyMoviesById(enti);
    }
    @Override
    public int updateNonEmptyMovies(Movies value, Assist assist){
        return moviesDao.updateNonEmptyMovies(value,assist);
    }

    public MoviesDao getMoviesDao() {
        return this.moviesDao;
    }

    public void setMoviesDao(MoviesDao moviesDao) {
        this.moviesDao = moviesDao;
    }

}