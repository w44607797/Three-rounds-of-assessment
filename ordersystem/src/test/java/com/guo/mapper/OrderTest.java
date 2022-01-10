package com.guo.mapper;


import com.guo.pojos.myOrder;
import com.guo.utils.MyDateUtils;
import com.guo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
public class OrderTest {
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

    //测试曾加订单
    @Test
    public void insertOrder() {
        try {
            orderMapper.addOrder(new myOrder(12, 12,
                    MyDateUtils.getDate(new Date().getTime())));
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
    }

    //测试删除id为1的订单
    @Test
    public void deletOrder() {
        try {
            orderMapper.deleteOrderById(1);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
    }

    //测试更新订单编号为 1 的订单 更新为当前时间，商品信息随意
    @Test
    public void updataOrder() {
        Date date = new Date();
        try {
            orderMapper.updateOrder(new myOrder(1, 2,
                    MyDateUtils.getDate(date.getTime())));
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
    }

    //测试查询所有的订单
    @Test
    public void getOrderList() {
        List<myOrder> list = orderMapper.getOrderList();
        for (com.guo.pojos.myOrder myOrder : list) {
            System.out.println(myOrder);
        }
    }


    //测试通过订单ID查询订单信息 比如查询订单编号为 1 的订单
    @Test
    public void selectOrderById() {
        System.out.println(orderMapper.getOrderById(1));
    }

    //测试分页查询
    @Test
    public void selectByLimit() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("startIndex", 0);
        hashMap.put("pageSize", 2);
        List<myOrder> list = orderMapper.selectLimit(hashMap);
        for (com.guo.pojos.myOrder myOrder : list) {
            System.out.println(myOrder);
        }
    }



    @After
    public void closeSql() {
        sqlSession.close();
    }


}


