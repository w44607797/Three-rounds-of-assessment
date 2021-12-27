package com.guo.mapper;
import com.guo.pojos.Commodity;
import com.guo.pojos.MyOrder;
import com.guo.utils.MyDateUtils;
import com.guo.utils.MybatisUtils;
import javafx.scene.chart.PieChart;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderTest {
    private List<MyOrder> OrderList;
    private List<Commodity> commodityList;
    private MyOrderMapper orderMapper;
    private CommodityMapper commodityMapper;
    private SqlSession sqlSession;

    @Before
    public void BuildMapper() {
        sqlSession = MybatisUtils.getsqlsession();
        orderMapper = sqlSession.getMapper(MyOrderMapper.class);
        OrderList = orderMapper.getOrderList();
        commodityMapper = sqlSession.getMapper(CommodityMapper.class);
        commodityList = commodityMapper.getCommodityList();
    }

    @Test
    public void Demo() {
        for (MyOrder o : OrderList) {
            System.out.println(o.getOrderNumber());
        }
        for (Commodity c : commodityList) {
            System.out.println(c.getCommodityName());
        }
        MyOrder myOrder = orderMapper.getOrderById(1);
        System.out.println(myOrder.getOrderTime());
        //     try {
        //          orderMapper.addOrder(new MyOrder(11, 2, "20211215"));
        //           sqlSession.commit();
////////            orderMapper.updateOrder(new Order(3,1,"20211216"));
////            sqlSession.commit();
//            orderMapper.deleteOrderById(3);
//            sqlSession.commit();

        //      }catch (Exception e){
        //          sqlSession.rollback();
//            System.out.println(e);
        Scanner sc = new Scanner(System.in);
        List<MyOrder> list = orderMapper.selectLike(sc.next());
        for (MyOrder order : list) {
            System.out.println(order);
        }
    }
    //测试查询所有的订单
    @Test
    public void getOrderList(){

    }

    //测试通过订单ID查询订单信息 比如查询订单编号为 1 的订单
    @Test
    public void selectOrderById() {
        System.out.println(orderMapper.getOrderById(1));
    }

    //测试通过订单ID查询订单和商品的信息(多表查询) 比如查询订单编号为 1 的订单和对应商品
    @Test
    public void selectAll() {
        System.out.println();
    }

    //测试更新订单编号为 1 的订单 更新为当前时间，商品信息随意
    @Test
    public void updataOrder() {
        Date date = new Date();
          orderMapper.updateOrder(new MyOrder(2,2,
                  MyDateUtils.getDate(date.getTime())));
    }
    @Test
    public void add(){
        System.out.println("hellow");
    }
    @Test
    public void add2() {
        System.out.println("nmb");
    }
    @Test
    public void add3(){
        System.out.println(3);
    }

}

//    @After
//    public void CloseSql(){
//        sqlSession.close();
//    }
//}

