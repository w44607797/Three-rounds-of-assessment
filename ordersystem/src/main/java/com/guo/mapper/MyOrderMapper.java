package com.guo.mapper;

import com.guo.pojos.MyOrder;

import java.util.List;
import java.util.Map;

public interface MyOrderMapper {
    List<MyOrder> getOrderList();
    MyOrder getOrderById(int id);
    int addOrder(MyOrder myOrder);
    void updateOrder(MyOrder myOrder);
    void deleteOrderById(int orderId);
    int addOrderByMap(Map<String,Object> map);
    List<MyOrder> selectLike(String id);
}
