package com.sysu.service;
import java.util.List;
import com.sysu.pojo.Order;
import com.sysu.common.Assist;
public interface OrderService{
	public List<Order> getOrdersByUsername(String username);
	public Order getOrdersById(Integer order_id);
	public int insertOrder(Order order);
	public int updateOrder(Integer order_id, int statues);
	public int deleteOrder(Integer order_id);
	public int payOrder(Integer order_id);
	public int overPayTimeOrder(Integer order_id);

}