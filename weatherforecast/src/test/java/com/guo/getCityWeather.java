package com.guo;

import com.guo.mapper.CityMapper;
import com.guo.mapper.CityWeatherMapper;
import com.guo.pojos.City;
import com.guo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;


public class getCityWeather {
    private CityWeatherMapper cityWeatherMapper;
    private SqlSession sqlSession;
    private CityMapper cityMapper;

    //因为是测试类，每个Test独立，我就不在每一个Test重新创sqlSession了
    //正常情况下只创建一个sqlSession多次访问数据库有点危险
    @Before
    public void BuildMapper() {
        sqlSession = MybatisUtils.getsqlsession();
        cityWeatherMapper = sqlSession.getMapper(CityWeatherMapper.class);
        cityMapper = sqlSession.getMapper(CityMapper.class);
    }

    //多表查询,执行之前请先执行"addCityToDBTest"和"addWeatherToDBTest"中的测试类添加数据
    //查询城市和城市天气组合信息
    @Test
    public void getTotal() {
        City city = cityMapper.getCityWeather("福州");
        System.out.println(city);
        City city1 = cityMapper.getCityWeather("北京");
        System.out.println(city1);
        City city2 = cityMapper.getCityWeather("上海");
        System.out.println(city2);
    }
}
