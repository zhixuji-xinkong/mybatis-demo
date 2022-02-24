package org.example;

import org.example.jdbc.UserInfoJDBC;
import org.example.pojo.UserInfo;
import org.junit.Test;

public class Demo1 {

    @Test
    public void queryUserOne(){
        long uId = 9157;
        UserInfo user = UserInfoJDBC.queryOneUser(uId);
        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.out.println("用户 " + uId + " 不存在！");
        }
    }

}
