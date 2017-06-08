package com.sysu.service;
import java.util.List;

import com.sysu.pojo.IntheaterMovie;
import com.sysu.pojo.MovieOrder;
public interface OrderService{
	public List<MovieOrder> getOrdersByUsername(String username);
	public MovieOrder getOrdersById(Integer order_id);
	public int insertOrder(MovieOrder order);
	public int updateOrder(MovieOrder order);
	public int updateOrder(Integer order_id, int statues);
	public int deleteOrder(Integer order_id);
	public int payOrder(Integer order_id);
	
	public int overPayTimeOrder(Integer order_id) throws Exception;
	public int addOrder(MovieOrder order, IntheaterMovie intheaterMovie) throws Exception;

}