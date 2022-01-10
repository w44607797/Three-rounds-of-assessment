package com.guo.mapper;

import com.guo.pojos.Commodity;
import com.guo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class CommodityTest {
    private MyOrderMapper orderMapper;
    private CommodityMapper commodityMapper;
    private SqlSession sqlSession;

    //因为是测试类，每个Test独立，我就不在每一个Test重新创sqlSession了
    //正常情况下只创建一个sqlSession多次访问数据库有点危险
    @Before
    public void BuildMapper() {
        sqlSession = MybatisUtils.getsqlsession();
        orderMapper = sqlSession.getMapper(MyOrderMapper.class);
        commodityMapper = sqlSession.getMapper(CommodityMapper.class);
    }
    //测试查询所有的商品
    @Test
    public void getCommodityList() {
        List<Commodity> list = commodityMapper.getCommodityList();
        for (Commodity commodity : list) {
            System.out.println(commodity);
        }
    }
    //插
    @Test
    public void insertCommodity() {
        try {
            commodityMapper.insertCommodity(
                    new Commodity(4, "牛奶", 20));
            sqlSession.commit();
        } catch (Exception e){
            sqlSession.rollback();
        }

    }
    //根据id删除商品
    @Test
    public void deleteCommodity() {
        try {
            commodityMapper.deleteCommodity(4);
            sqlSession.commit();
        }catch (Exception e) {
            sqlSession.rollback();
        }
    }
    @Test
    public void updateCommodity(){
        try {
            commodityMapper.updateCommodity(new Commodity(1,"羊肉片",20));
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            System.out.println(e);
        }
    }
}
