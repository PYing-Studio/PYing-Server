package com.sysu.service;
import java.util.List;
import com.sysu.pojo.Order;
import com.sysu.common.Assist;
public interface OrderService{
    long getOrderRowCount(Assist assist);
    List<Order> selectOrder(Assist assist);
    Order selectOrderById(Integer id);
    int insertOrder(Order value);
    int insertNonEmptyOrder(Order value);
    int deleteOrderById(Integer id);
    int deleteOrder(Assist assist);
    int updateOrderById(Order enti);
    int updateOrder(Order value, Assist assist);
    int updateNonEmptyOrderById(Order enti);
    int updateNonEmptyOrder(Order value, Assist assist);
}