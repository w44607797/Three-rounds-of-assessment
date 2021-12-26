package com.guo.pojos;

import org.apache.ibatis.type.Alias;

@Alias("Commodity")
public class Commodity {
    private int commodityId;
    private String commodityName;
    private double commodityPrice;

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commodityId=" +  + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice=" + commodityPrice +
                '}';
    }
}
