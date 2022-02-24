package org.example.jdbc;

import org.example.pojo.UserInfo;

import java.sql.*;

/**
 * JDBC
 */
public class UserInfoJDBC {

    /**
     * 根据用户 id 查询对应用户信息
     * @param uId 用户 id
     * @return 返回用户信息 UserInfo 一个实例化类对象
     */
    public static UserInfo queryOneUser(long uId){
        // 用户信息表实例化对象
        UserInfo user = null;
        // 数据库连接对象
        Connection conn = null;
        // sql 语句预编译对象
        PreparedStatement ps = null;
        // 编译返回结果对象
        ResultSet resultSet = null;

        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigdata?useSSL=false",
                    "root",
                    "root");
            // 3.创建 Statement 实例化对象
            String sql = "select * from user_info where u_id = ?";
            // 3.1 预编译 sql 语句
            ps = conn.prepareStatement(sql);
            // 3.2 设置参数
            ps.setLong(1,uId);
            // 4 发送请求并处理结果
            resultSet = ps.executeQuery();
            // 5 解析结果
            if (resultSet.next()){
                user = new UserInfo();
                user.setId(resultSet.getLong("id"));
                user.setuId(uId);
                user.setuName(resultSet.getString("u_name"));
                user.setGender(resultSet.getInt("gender"));
                user.setAge(resultSet.getInt("age"));
                user.setAddTime(resultSet.getString("add_time"));
                user.setUpdateTime(resultSet.getString("update_time"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 5 释放资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return user;
    }
}
