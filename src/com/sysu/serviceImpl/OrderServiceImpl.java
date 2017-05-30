package com.sysu.serviceImpl;
import java.util.List;
import com.sysu.mapper.OrderDao;
import com.sysu.pojo.Order;
import com.sysu.common.Assist;
import com.sysu.service.OrderService;
public class OrderServiceImpl implements OrderService{
    private OrderDao orderDao;
    @Override
    public long getOrderRowCount(Assist assist){
        return orderDao.getOrderRowCount(assist);
    }
    @Override
    public List<Order> selectOrder(Assist assist){
        return orderDao.selectOrder(assist);
    }
    @Override
    public Order selectOrderById(Integer id){
        return orderDao.selectOrderById(id);
    }
    @Override
    public int insertOrder(Order value){
        return orderDao.insertOrder(value);
    }
    @Override
    public int insertNonEmptyOrder(Order value){
        return orderDao.insertNonEmptyOrder(value);
    }
    @Override
    public int deleteOrderById(Integer id){
        return orderDao.deleteOrderById(id);
    }
    @Override
    public int deleteOrder(Assist assist){
        return orderDao.deleteOrder(assist);
    }
    @Override
    public int updateOrderById(Order enti){
        return orderDao.updateOrderById(enti);
    }
    @Override
    public int updateOrder(Order value, Assist assist){
        return orderDao.updateOrder(value,assist);
    }
    @Override
    public int updateNonEmptyOrderById(Order enti){
        return orderDao.updateNonEmptyOrderById(enti);
    }
    @Override
    public int updateNonEmptyOrder(Order value, Assist assist){
        return orderDao.updateNonEmptyOrder(value,assist);
    }

    public OrderDao getOrderDao() {
        return this.orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

}