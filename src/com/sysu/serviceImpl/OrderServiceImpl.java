package com.sysu.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sysu.common.Assist;
import com.sysu.mapper.OrderMapper;
import com.sysu.pojo.Order;
import com.sysu.service.OrderService;
import com.sysu.utils.DateUtil;
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<Order> getOrdersByUsername(String username) {
		Assist assist = new Assist();
		assist.setRequires(Assist.and_eq("username", username), Assist.and_neq("statue", "3"), Assist.and_neq("statue", "0"));
		List<Order> listOrders = orderMapper.selectOrder(assist);
		return listOrders;
	}

	@Override
	public Order getOrdersById(Integer order_id) {
		return orderMapper.selectOrderById(order_id);
	}

	@Override
	public int insertOrder(Order order) {
		return orderMapper.insertOrder(order);
	}
	
	@Override
	public int updateOrder(Integer order_id, int statues) {
		Order order = orderMapper.selectOrderById(order_id);
		order.setStatue(statues);
		return orderMapper.updateOrderById(order);
	}

	@Override
	public int deleteOrder(Integer order_id) {
		return updateOrder(order_id, 0);
	}

	@Override
	public int payOrder(Integer order_id) {
		Order order = orderMapper.selectOrderById(order_id);
		order.setStatue(1);
		order.setPayTime(DateUtil.getCurrrentDate());
		return orderMapper.updateOrderById(order);
	}

	@Override
	public int overPayTimeOrder(Integer order_id) {
		return updateOrder(order_id, 3);
	}


}