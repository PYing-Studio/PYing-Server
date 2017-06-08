package com.sysu.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysu.mapper.HotMovieMapper;
import com.sysu.pojo.HotMovie;
import com.sysu.pojo.Yueyin;
import com.sysu.common.Assist;
import com.sysu.service.HotMovieService;

@Service("hotMovieService")
public class HotMovieServiceImpl implements HotMovieService{
    @Autowired
	private HotMovieMapper hotMovieMapper;
    @Override
    public long getHotMovieRowCount(Assist assist){
        return hotMovieMapper.getHotMovieRowCount(assist);
    }
    @Override
    public List<HotMovie> selectHotMovie(Assist assist){
        return hotMovieMapper.selectHotMovie(assist);
    }
    @Override
    public HotMovie selectHotMovieById(Integer id){
        return hotMovieMapper.selectHotMovieById(id);
    }
    @Override
    public int insertHotMovie(HotMovie value){
        return hotMovieMapper.insertHotMovie(value);
    }
    @Override
    public int insertNonEmptyHotMovie(HotMovie value){
        return hotMovieMapper.insertNonEmptyHotMovie(value);
    }
    @Override
    public int deleteHotMovieById(Integer id){
        return hotMovieMapper.deleteHotMovieById(id);
    }
    @Override
    public int deleteHotMovie(Assist assist){
        return hotMovieMapper.deleteHotMovie(assist);
    }
    @Override
    public int updateHotMovieById(HotMovie enti){
        return hotMovieMapper.updateHotMovieById(enti);
    }
    @Override
    public int updateHotMovie(HotMovie value, Assist assist){
        return hotMovieMapper.updateHotMovie(value,assist);
    }
    @Override
    public int updateNonEmptyHotMovieById(HotMovie enti){
        return hotMovieMapper.updateNonEmptyHotMovieById(enti);
    }
    @Override
    public int updateNonEmptyHotMovie(HotMovie value, Assist assist){
        return hotMovieMapper.updateNonEmptyHotMovie(value,assist);
    }
	@Override
	public List<HotMovie> getAllHotMovies() {
		Assist assist = new Assist();
		assist.setRequires();
		return hotMovieMapper.selectHotMovie(assist);
	}
	@Override
	public List<HotMovie> getHotMovies(int offset, int limit) {
		Assist assist = new Assist();
		assist.setStartRow(offset);
		assist.setRowSize(limit);
		assist.setRequires(Assist.and_eq("statue", "1"));
		return hotMovieMapper.selectHotMovie(assist);
	}

}