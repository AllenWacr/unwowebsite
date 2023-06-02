package com.unwo.website.mapper;

import org.apache.ibatis.annotations.*;

import com.unwo.website.bean.User;

@Mapper
public interface UserMapper {
    
    @Select("SELECT * FROM user WHERE id=#{id}")
    public User selectUserById(Integer id);

    @Select("SELECT * FROM user WHERE username=#{username}")
    public User selectUserByUsername(String username);

    @Insert("INSERT INTO user(username, password, sex, email, join_date) values(#{username}, #{password}, #{sex}, #{email}, #{join_date})")
    public int addUser(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    public int deleteUser(Integer id);

    @Update("UPDATE user SET username=#{username} WHERE id=#{id}")
    public int updateUserUsername(User user);

    @Update("UPDATE user SET password=#{password} WHERE id=#{id}")
    public int updateUserPassword(User user);
}