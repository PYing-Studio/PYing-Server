package com.sysu.serviceImpl;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysu.mapper.IntheaterMovieMapper;
import com.sysu.pojo.IntheaterMovie;
import com.sysu.common.Assist;
import com.sysu.service.IntheaterMovieService;
import com.sysu.utils.DateUtil;

@Service("intheaterMovieService")
public class IntheaterMovieServiceImpl implements IntheaterMovieService{
    @Autowired
	private IntheaterMovieMapper intheaterMovieMapper;
    @Override
    public long getIntheaterMovieRowCount(Assist assist){
        return intheaterMovieMapper.getIntheaterMovieRowCount(assist);
    }
    @Override
    public List<IntheaterMovie> selectIntheaterMovie(Assist assist){
        return intheaterMovieMapper.selectIntheaterMovie(assist);
    }
    @Override
    public IntheaterMovie selectIntheaterMovieById(Integer id){
        return intheaterMovieMapper.selectIntheaterMovieById(id);
    }
    @Override
    public int insertIntheaterMovie(IntheaterMovie value){
        return intheaterMovieMapper.insertIntheaterMovie(value);
    }
    @Override
    public int insertNonEmptyIntheaterMovie(IntheaterMovie value){
        return intheaterMovieMapper.insertNonEmptyIntheaterMovie(value);
    }
    @Override
    public int deleteIntheaterMovieById(Integer id){
        return intheaterMovieMapper.deleteIntheaterMovieById(id);
    }
    @Override
    public int deleteIntheaterMovie(Assist assist){
        return intheaterMovieMapper.deleteIntheaterMovie(assist);
    }
    @Override
    public int updateIntheaterMovieById(IntheaterMovie enti){
        return intheaterMovieMapper.updateIntheaterMovieById(enti);
    }
    @Override
    public int updateIntheaterMovie(IntheaterMovie value, Assist assist){
        return intheaterMovieMapper.updateIntheaterMovie(value,assist);
    }
    @Override
    public int updateNonEmptyIntheaterMovieById(IntheaterMovie enti){
        return intheaterMovieMapper.updateNonEmptyIntheaterMovieById(enti);
    }
    @Override
    public int updateNonEmptyIntheaterMovie(IntheaterMovie value, Assist assist){
        return intheaterMovieMapper.updateNonEmptyIntheaterMovie(value,assist);
    }


	@Override
	public List<IntheaterMovie> getIntheaterMovie(Integer cinema_id,
			Integer movie_id) {
		Assist assist = new Assist();
		assist.setOrder("show_time", true);
		if (movie_id == null || movie_id == 0) {
			assist.setRequires(Assist.and_eq("cinema_id", cinema_id.toString()));
		} else if (cinema_id == null || cinema_id == 0) {
			assist.setRequires(Assist.and_eq("movie_id", movie_id.toString()));
		} else {
			assist.setRequires(Assist.and_eq("cinema_id", cinema_id.toString()), Assist.and_eq("movie_id", movie_id.toString()));
		}
		assist.getRequire().add(Assist.and_gt("leave_num", "0"));
//		String tmpString = "";
//		try {
//			tmpString = DateUtil.formatDate(DateUtil.dataIncrease(DateUtil.getCurrrentDate(), -1));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		assist.getRequire().add(Assist.and_gt("show_time", DateUtil.getCurrrentDateString()));
		return intheaterMovieMapper.selectIntheaterMovie(assist);
	}

}