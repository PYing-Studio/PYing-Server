package com.sysu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysu.common.Assist;
import com.sysu.mapper.YueyinMapper;
import com.sysu.pojo.Yueyin;
import com.sysu.service.YueyinService;

@Service("yueyinService")
public class YueyinServiceImpl implements YueyinService {
	@Autowired
	private YueyinMapper yueyinMapper;

	@Override
	public long getYueyinRowCount(Assist assist) {
		return yueyinMapper.getYueyinRowCount(assist);
	}

	@Override
	public List<Yueyin> selectYueyin(Assist assist) {
		return yueyinMapper.selectYueyin(assist);
	}

	@Override
	public Yueyin selectYueyinById(Integer id) {
		return yueyinMapper.selectYueyinById(id);
	}

	@Override
	public int insertYueyin(Yueyin value) {
		return yueyinMapper.insertYueyin(value);
	}

	@Override
	public int insertNonEmptyYueyin(Yueyin value) {
		return yueyinMapper.insertNonEmptyYueyin(value);
	}

	@Override
	public int deleteYueyinById(Integer id) {
		Yueyin yueyin = yueyinMapper.selectYueyinById(id);
		if (yueyin == null) {
			return 0;
		}
		yueyin.setStatus(0);
		return yueyinMapper.updateYueyinById(yueyin);
	}

	@Override
	public int deleteYueyin(Assist assist) {
		return yueyinMapper.deleteYueyin(assist);
	}

	@Override
	public int updateYueyinById(Yueyin enti) {
		return yueyinMapper.updateYueyinById(enti);
	}

	@Override
	public int updateYueyin(Yueyin value, Assist assist) {
		return yueyinMapper.updateYueyin(value, assist);
	}

	@Override
	public int updateNonEmptyYueyinById(Yueyin enti) {
		return yueyinMapper.updateNonEmptyYueyinById(enti);
	}

	@Override
	public int updateNonEmptyYueyin(Yueyin value, Assist assist) {
		return yueyinMapper.updateNonEmptyYueyin(value, assist);
	}

	@Override
	public List<Yueyin> getYueyinByUserName(String username) {
		Assist assist = new Assist();
		assist.setRequires(Assist.and_eq("username", username), Assist.and_eq("status", "1"), Assist.or_like("friends", "%" + username + "%"), Assist.and_eq("status", "1"));
		List<Yueyin> listOrders = yueyinMapper.selectYueyin(assist);
		return listOrders;
	}

	@Override
	public List<Yueyin> getAllYueyin() {
		Assist assist = new Assist();
		assist.setRequires(Assist.and_eq("status", "1"), Assist.and_gt("leave_num", "0"));
		List<Yueyin> listOrders = yueyinMapper.selectYueyin(assist);
		return listOrders;
	}

}