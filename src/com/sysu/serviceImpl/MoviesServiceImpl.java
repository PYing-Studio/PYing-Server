package com.sysu.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysu.mapper.MoviesMapper;
import com.sysu.pojo.MovieOrder;
import com.sysu.pojo.Movies;
import com.sysu.common.Assist;
import com.sysu.service.MoviesService;

@Service("moviesService")
public class MoviesServiceImpl implements MoviesService{
    @Autowired
	private MoviesMapper moviesMapper;
    @Override
    public long getMoviesRowCount(Assist assist){
        return moviesMapper.getMoviesRowCount(assist);
    }
    @Override
    public List<Movies> selectMovies(Assist assist){
        return moviesMapper.selectMovies(assist);
    }
    @Override
    public Movies selectMoviesById(Integer id){
        return moviesMapper.selectMoviesById(id);
    }
    @Override
    public int insertMovies(Movies value){
        return moviesMapper.insertMovies(value);
    }
    @Override
    public int insertNonEmptyMovies(Movies value){
        return moviesMapper.insertNonEmptyMovies(value);
    }
    @Override
    public int deleteMoviesById(Integer id){
        return moviesMapper.deleteMoviesById(id);
    }
    @Override
    public int deleteMovies(Assist assist){
        return moviesMapper.deleteMovies(assist);
    }
    @Override
    public int updateMoviesById(Movies enti){
        return moviesMapper.updateMoviesById(enti);
    }
    @Override
    public int updateMovies(Movies value, Assist assist){
        return moviesMapper.updateMovies(value,assist);
    }
    @Override
    public int updateNonEmptyMoviesById(Movies enti){
        return moviesMapper.updateNonEmptyMoviesById(enti);
    }
    @Override
    public int updateNonEmptyMovies(Movies value, Assist assist){
        return moviesMapper.updateNonEmptyMovies(value,assist);
    }
	@Override
	public List<Movies> searchMovies(String keyWord) {
		Assist assist = new Assist();
		assist.setRequires(Assist.or_like("name", "%" + keyWord + "%"), Assist.or_like("cat", "%" + keyWord + "%"), Assist.or_like("star", "%" + keyWord + "%"), Assist.or_like("dir", "%" + keyWord + "%"));
        return moviesMapper.selectMovies(assist);
	}

}