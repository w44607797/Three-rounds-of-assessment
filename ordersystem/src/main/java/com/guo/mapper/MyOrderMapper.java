package com.guo.mapper;

import com.guo.pojos.myOrder;

import java.util.HashMap;
import java.util.List;

public interface MyOrderMapper {
    List<myOrder> getOrderList();
    myOrder getOrderById(int id);
    int addOrder(myOrder myOrder);
    void updateOrder(myOrder myOrder);
    void deleteOrderById(int orderId);
    List<myOrder> selectLike(String id);
    List<myOrder> selectLimit(HashMap<String,Integer> map);
}
