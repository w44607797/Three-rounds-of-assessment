package com.guo;

import com.guo.mapper.CityWeatherMapper;
import com.guo.pojos.CityWeather;
import com.guo.utils.GetCityWeatherUtil;
import com.guo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import com.guo.utils.deleteSameUtil;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class addWeatherToDBTest {
    private CityWeatherMapper cityWeatherMapper;
    private SqlSession sqlSession;
    //因为是测试类，每个Test独立，我就不在每一个Test重新创sqlSession了
    //正常情况下只创建一个sqlSession多次访问数据库有点危险
    @Before
    public void BuildMapper() {
        sqlSession = MybatisUtils.getsqlsession();
        cityWeatherMapper = sqlSession.getMapper(CityWeatherMapper.class);
    }
    //将天气信息添加到数据库
    @Test
    public void addWeather() throws IOException, ParseException {
        ArrayList<List<CityWeather>> cityWeatherList = new ArrayList<>();
        cityWeatherList.add(GetCityWeatherUtil.getCityWeather("福州"));
        //[CityWeather{fxDate=Thu Jan 06 00:00:00 CST 2022, tempMax=15, tempMin=9, textDay='阴', cityId=101230101},
        // CityWeather{fxDate=Fri Jan 07 00:00:00 CST 2022, tempMax=16, tempMin=8, textDay='阴', cityId=101230101},
        // CityWeather{fxDate=Sat Jan 08 00:00:00 CST 2022, tempMax=15, tempMin=7, textDay='多云', cityId=101230101}]
        cityWeatherList.add(GetCityWeatherUtil.getCityWeather("北京"));
        //[CityWeather{fxDate=Thu Jan 06 00:00:00 CST 2022, tempMax=5, tempMin=-7, textDay='晴', cityId=101010100},
        // CityWeather{fxDate=Fri Jan 07 00:00:00 CST 2022, tempMax=5, tempMin=-6, textDay='晴', cityId=101010100},
        // CityWeather{fxDate=Sat Jan 08 00:00:00 CST 2022, tempMax=8, tempMin=-5, textDay='多云', cityId=101010100}]
        cityWeatherList.add(GetCityWeatherUtil.getCityWeather("上海"));
        //[CityWeather{fxDate=Thu Jan 06 00:00:00 CST 2022, tempMax=9, tempMin=5, textDay='多云', cityId=101020100},
        // CityWeather{fxDate=Fri Jan 07 00:00:00 CST 2022, tempMax=9, tempMin=5, textDay='多云', cityId=101020100},
        // CityWeather{fxDate=Sat Jan 08 00:00:00 CST 2022, tempMax=9, tempMin=4, textDay='阴', cityId=101020100}]
        try {
            for (List<CityWeather> cityWeathers : cityWeatherList) {
                for (CityWeather cityWeather : cityWeathers) {
                    cityWeatherMapper.insertWeather(cityWeather);
                }
            }
            sqlSession.commit();
            deleteSameUtil.deleteSame();
        }catch (Exception e){
            sqlSession.rollback();
        }
    }
}
