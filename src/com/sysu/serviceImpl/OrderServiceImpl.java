package com.sysu.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.common.Assist;
import com.sysu.mapper.MovieOrderMapper;
import com.sysu.pojo.IntheaterMovie;
import com.sysu.pojo.MovieOrder;
import com.sysu.service.IntheaterMovieService;
import com.sysu.service.OrderService;
import com.sysu.utils.DateUtil;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private MovieOrderMapper orderMapper;
	@Autowired
	private IntheaterMovieService intheaterMovieService;

	@Override
	public List<MovieOrder> getOrdersByUsername(String username) {
		Assist assist = new Assist();
		assist.setRequires(Assist.and_eq("username", username), Assist.and_neq("status", "3"), Assist.and_neq("status", "0"));
		List<MovieOrder> listOrders = orderMapper.selectMovieOrder(assist);
		return listOrders;
	}

	@Override
	public MovieOrder getOrdersById(Integer order_id) {
		return orderMapper.selectMovieOrderById(order_id);
	}

	@Override
	public int insertOrder(MovieOrder order) {
		return orderMapper.insertMovieOrder(order);
	}
	
	@Override
	public int updateOrder(Integer order_id, int statues) {
		MovieOrder order = orderMapper.selectMovieOrderById(order_id);
		order.setStatus(statues);
		return orderMapper.updateMovieOrderById(order);
	}

	@Override
	public int deleteOrder(Integer order_id) {
		return updateOrder(order_id, 0);
	}

	@Override
	public int payOrder(Integer order_id) {
		MovieOrder order = orderMapper.selectMovieOrderById(order_id);
		order.setStatus(1);
		order.setPayTime(DateUtil.getCurrrentDate());
		return orderMapper.updateMovieOrderById(order);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int overPayTimeOrder(Integer order_id) throws Exception {
		MovieOrder order = orderMapper.selectMovieOrderById(order_id);
		if (order == null) {
			throw new Exception("can't not get order by id " + order_id);
		}
		order.setStatus(3);
		IntheaterMovie intheaterMovie = intheaterMovieService.selectIntheaterMovieById(order.getShowTimeId());
		if (intheaterMovie == null) {
			throw new Exception("can't not get intheaterMovie by id " + order.getShowTimeId());
		}
		int res = orderMapper.updateMovieOrderById(order);
		if (res < 1) {
			throw new Exception("can't not update order by id " + order.getId());
		}
		intheaterMovie.setNum(intheaterMovie.getNum() + order.getNum());
		res = intheaterMovieService.updateIntheaterMovieById(intheaterMovie);
		if (res < 1) {
			throw new Exception("can't not update intheaterMovie by id " + intheaterMovie.getId());
		}
		return res;
	}

	@Override
	public int updateOrder(MovieOrder order) {
		return orderMapper.updateMovieOrderById(order);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int addOrder(MovieOrder order, IntheaterMovie intheaterMovie) throws Exception {
		intheaterMovie.setLeaveNum(intheaterMovie.getNum() - order.getNum());
		int res = intheaterMovieService.updateIntheaterMovieById(intheaterMovie);
		if (res < 1) {
			throw new Exception("update intheaterMovie fail!");
		}
		res = insertOrder(order);
		if (res < 1) {
			throw new Exception("insert order fail!");
		}
		return res;
	}

}