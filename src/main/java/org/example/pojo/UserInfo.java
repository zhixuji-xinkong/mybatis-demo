package org.example.pojo;

/**
 * 用户信息表 user_info 实体类
 */
public class UserInfo {
    /**
     * 主键 id
     */
    private Long id;
    /**
     * 用户 id
     */
    private Long uId;
    /**
     * 用户姓名
     */
    private String uName;
    /**
     * 用户性别:0-女,1-男
     */
    private Integer gender;
    /**
     * 用户年龄
     */
    private Integer age;
    /**
     * 添加用户时间
     */
    private String addTime;
    /**
     * 用户更新时间
     */
    private String updateTime;

    public UserInfo() {
    }

    public UserInfo(Long id, Long uId, String uName, Integer gender, Integer age, String addTime, String updateTime) {
        this.id = id;
        this.uId = uId;
        this.uName = uName;
        this.gender = gender;
        this.age = age;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", uId=" + uId +
                ", uName='" + uName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
