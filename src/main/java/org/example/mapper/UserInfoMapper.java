package org.example.mapper;

import org.example.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    /**
     * 查询所有用户信息
     * @return 返回查询结果集合
     */
    List<UserInfo> queryUserAll();
}
