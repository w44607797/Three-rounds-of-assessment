package com.guo;

import com.guo.mapper.CityMapper;
import com.guo.mapper.CityWeatherMapper;
import com.guo.pojos.City;
import com.guo.utils.GetCityUtils;
import com.guo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class addCityToDBTest {
    private CityMapper cityMapper;
    private SqlSession sqlSession;

    //因为是测试类，每个Test独立，我就不在每一个Test重新创sqlSession了
    //正常情况下只创建一个sqlSession多次访问数据库有点危险
    @Before
    public void BuildMapper() {
        sqlSession = MybatisUtils.getsqlsession();
        cityMapper = sqlSession.getMapper(CityMapper.class);
    }
    //将城市信息添加到数据库
    @Test
    public void addCity() throws IOException {
        City fuZhou = GetCityUtils.getLocation("福州");  //City{name='福州', id=101230101, lat=26.0753, lon=119.30623}
        City beiJing = GetCityUtils.getLocation("北京"); //City{name='北京', id=101010100, lat=39.90498, lon=116.40528}
        City shangHai = GetCityUtils.getLocation("上海"); //City{name='上海', id=101020100, lat=31.2317, lon=121.47264}
        try {
            cityMapper.insertCity(fuZhou);
            cityMapper.insertCity(beiJing);
            cityMapper.insertCity(shangHai);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }
    }



}
