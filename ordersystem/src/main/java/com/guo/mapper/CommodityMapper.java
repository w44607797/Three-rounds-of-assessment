package com.guo.mapper;

import com.guo.pojos.Commodity;

import java.util.List;

public interface CommodityMapper {
    public List<Commodity> getCommodityList();
    void updateCommodity(Commodity commodity);
    void insertCommodity(Commodity commodity);
    void deleteCommodity(int commodity_id);
}
