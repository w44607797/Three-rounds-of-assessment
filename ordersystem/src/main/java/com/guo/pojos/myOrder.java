package com.guo.pojos;

import org.apache.ibatis.type.Alias;


@Alias("MyOrder")
public class myOrder {
    private int order_id;
    private int commodity_id;
    private String order_time;

    public myOrder(int order_id, int commodity_id, String order_time) {
        this.order_id=order_id;
        this.commodity_id = commodity_id;
        this.order_time = order_time;
    }

    public int getOrderNumber() {
        return order_id;
    }

    public void setOrderNumber(int order_id) {
        this.order_id = order_id;
    }

    public int getCommodityNumber() {
        return commodity_id;
    }

    public void setCommodityNumber(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getOrderTime() {
        return order_time;
    }

    public void setOrderTime(String order_time) {
        this.order_time = order_time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", commodity_id=" + commodity_id +
                ", order_time='" + order_time + '\'' +
                '}';
    }
}

