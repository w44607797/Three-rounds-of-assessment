package com.guo.pojos;

import org.apache.ibatis.type.Alias;

@Alias("MyOrder")
public class MyOrder {
    private int orderId;
    private int commodityMessage;
    private String orderTime;

    public MyOrder(int orderId, int commodityMessage, String orderTime) {
        this.orderId=orderId;
        this.commodityMessage = commodityMessage;
        this.orderTime = orderTime;
    }

    public int getOrderNumber() {
        return orderId;
    }

    public void setOrderNumber(int orderId) {
        this.orderId = orderId;
    }

    public int getCommodityNumber() {
        return commodityMessage;
    }

    public void setCommodityNumber(int commodityMessage) {
        this.commodityMessage = commodityMessage;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", commodityMessage=" + commodityMessage +
                ", orderTime='" + orderTime + '\'' +
                '}';
    }
}

