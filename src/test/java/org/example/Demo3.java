package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.UserInfoMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Demo3 {

    SqlSessionFactory ssf = null;

    @Before
    public void start(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            ssf = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryUserAll(){
        SqlSession session = ssf.openSession();
        UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
        System.out.println(mapper.queryUserAll());
        session.close();
    }

}
