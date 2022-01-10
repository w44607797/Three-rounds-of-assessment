package com.guo.pojos;

import org.apache.ibatis.type.Alias;

@Alias("Commodity")
public class Commodity {
    private int commodity_id;
    private String commodity_name;
    private double commodity_price;

    public Commodity(int commodity_id,String commodity_name,double commodity_price){
        this.commodity_id = commodity_id;
        this.commodity_name = commodity_name;
        this.commodity_price = commodity_price;
    }

    public int getCommodityId() {
        return commodity_id;
    }

    public void setCommodityId(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getCommodityName() {
        return commodity_name;
    }

    public void setCommodityName(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public double getCommodityPrice() {
        return commodity_price;
    }

    public void setCommodityPrice(double commodity_price) {
        this.commodity_price = commodity_price;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commodity_id=" +  + commodity_id +
                ", commodity_name='" + commodity_name + '\'' +
                ", commodity_price=" + commodity_price +
                '}';
    }
}
