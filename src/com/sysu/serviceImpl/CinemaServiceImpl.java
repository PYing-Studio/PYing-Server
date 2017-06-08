package com.sysu.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysu.common.Assist;
import com.sysu.mapper.CinemaMapper;
import com.sysu.pojo.Cinema;
import com.sysu.service.CinemaService;

@Service("cinemaService")
public class CinemaServiceImpl implements CinemaService{
    @Autowired
	private CinemaMapper cinemaMapper;
    @Override
    public long getCinemaRowCount(Assist assist){
        return cinemaMapper.getCinemaRowCount(assist);
    }
    @Override
    public List<Cinema> selectCinema(Assist assist){
        return cinemaMapper.selectCinema(assist);
    }
    @Override
    public Cinema selectCinemaById(Integer id){
        return cinemaMapper.selectCinemaById(id);
    }
    @Override
    public int insertCinema(Cinema value){
        return cinemaMapper.insertCinema(value);
    }
    @Override
    public int insertNonEmptyCinema(Cinema value){
        return cinemaMapper.insertNonEmptyCinema(value);
    }
    @Override
    public int deleteCinemaById(Integer id){
        return cinemaMapper.deleteCinemaById(id);
    }
    @Override
    public int deleteCinema(Assist assist){
        return cinemaMapper.deleteCinema(assist);
    }
    @Override
    public int updateCinemaById(Cinema enti){
        return cinemaMapper.updateCinemaById(enti);
    }
    @Override
    public int updateCinema(Cinema value, Assist assist){
        return cinemaMapper.updateCinema(value,assist);
    }
    @Override
    public int updateNonEmptyCinemaById(Cinema enti){
        return cinemaMapper.updateNonEmptyCinemaById(enti);
    }
    @Override
    public int updateNonEmptyCinema(Cinema value, Assist assist){
        return cinemaMapper.updateNonEmptyCinema(value,assist);
    }

	@Override
	public List<Cinema> getCinemas(String city, String area) {
		Assist assist = new Assist();
		if (org.apache.commons.lang.StringUtils.isEmpty(area)) {
			assist.setRequires(Assist.and_eq("city", city));
		} else {
			assist.setRequires(Assist.and_eq("city", city), Assist.and_eq("area", area));
		}
		return cinemaMapper.selectCinema(assist);
	}

}