package com.guo.utils;

import com.guo.mapper.CityMapper;
import org.apache.ibatis.session.SqlSession;

public class deleteSameUtil {
    public static void deleteSame(){
        SqlSession sqlSession = MybatisUtils.getsqlsession();
        CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
        try {
            cityMapper.deleteSame();
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }
    }
}
