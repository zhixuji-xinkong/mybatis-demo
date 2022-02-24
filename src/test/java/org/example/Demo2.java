package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.UserInfo;
import org.example.util.DateTimeUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    private SqlSessionFactory ssf = null;

    @Before
    public void start(){
        try {
            // 1 加载配置文件流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 2 创建 sqlSessionFactory 对象
            ssf = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteUser(){
        SqlSession session = ssf.openSession(true);
        long uId = 9157L;
        int row = session.delete("deleteUser", uId);
        if (row > 0){
            System.out.println("数据删除成功:" + row);
        } else {
            System.out.println("数据删除失败");
        }
        session.close();
    }

    @Test
    public void updateUser(){
        SqlSession session = ssf.openSession(true);
        UserInfo user = new UserInfo();
        user.setuId(3799L);
        user.setuName("张薇");
        user.setAge(18);
        user.setUpdateTime(DateTimeUtil.getCurrentDateTime());
        int row = session.update("updateUser", user);
        if (row > 0){
            System.out.println("数据更新成功:" + row);
        } else {
            System.out.println("数据更新失败");
        }
        session.close();
    }

    @Test
    public void insertUsers(){
        //自动提交事务
        SqlSession session = ssf.openSession(true);
        List<UserInfo> users = new ArrayList<>();
        UserInfo user1 = new UserInfo();
        user1.setuId(1754L);
        user1.setuName("李琦");
        user1.setGender(1);
        user1.setAge(21);
        String currentDateTime1 = DateTimeUtil.getCurrentDateTime();
        user1.setAddTime(currentDateTime1);
        user1.setUpdateTime(currentDateTime1);
        users.add(user1);
        UserInfo user2 = new UserInfo();
        user2.setuId(3799L);
        user2.setuName("张小小");
        user2.setGender(0);
        user2.setAge(19);
        String currentDateTime2 = DateTimeUtil.getCurrentDateTime();
        user2.setAddTime(currentDateTime2);
        user2.setUpdateTime(currentDateTime2);
        users.add(user2);
        int rows = session.insert("insertUsers", users);
        if (rows > 0){
            System.out.println("数据插入成功:" + rows);
        } else {
            System.out.println("数据插入失败");
        }
        session.close();
    }

    @Test
    public void insertUser(){
        // openSession() 手动提交事务，默认参数 false，需要 session.commit() 提交事务
        // 相当于自动提交事务 openSession(true)
        SqlSession session = ssf.openSession();
        UserInfo user = new UserInfo();
        user.setuId(2465L);
        user.setuName("王五");
        user.setGender(1);
        user.setAge(20);
        String currentDateTime = DateTimeUtil.getCurrentDateTime();
        user.setAddTime(currentDateTime);
        user.setUpdateTime(currentDateTime);
        int row = session.insert("insertUser", user);
        if (row > 0){
            System.out.println("数据插入成功:" + row);
        } else {
            System.out.println("数据插入失败");
        }
        // 提交事务
        session.commit();
        session.close();
    }

    @Test
    public void selectLike(){
        SqlSession session = ssf.openSession();
        List<UserInfo> users = session.selectList("selectLike", "张");
        users.forEach(user -> {
            System.out.println(user.toString());
        });
    }

    @Test
    public void selectUsers(){
        SqlSession session = ssf.openSession();
        List<UserInfo> users = session.selectList("selectUsers");
        users.forEach(user -> {
            System.out.println(user.toString());
        });
        session.close();
    }

    @Test
    public void selectUser(){
        // 3 创建 sqlSession 对象
        SqlSession session = ssf.openSession();
        // 4 执行 sql 查询
        long uId = 8566;
        UserInfo user = session.selectOne("mapper.selectUser", uId);
        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.out.println("用户 " + uId + " 不存在！");
        }
        // 5 释放资源
        session.close();
    }

    @Test
    public void test01(){
        String dateTime = DateTimeUtil.getPlusDateTime("2022/02/14 16:44:26",
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"),
                0,0,1, 4, -44, -26);
        System.out.println(dateTime);

        String date = DateTimeUtil.getPlusDate("2022/02/14 16:44:26",
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"),
                0,0,-24);
        System.out.println(date);
    }

}
