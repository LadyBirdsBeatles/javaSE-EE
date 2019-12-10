package com.cloud.beetles.dao;

import com.cloud.beetles.pojo.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Insert(value = "INSERT INTO users(user_name,user_password,user_phonenumber,user_sources)" + "Values(#{userName},#{userPhonenumber},#{userPassword},DATABASE())")
    public boolean adduser(Users user);
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "userPhonenumber", column = "user_phonenumber"),
            @Result(property = "userSources", column = "user_sources")
    })
    @Select(value = "select user_id,user_name,user_password,user_phonenumber,user_sources from users where user_id=#{userId}")
    public Users queryuserid(@Param("userId") long userId);

    @Results(
            id = "userId", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "userPhonenumber", column = "user_phonenumber"),
            @Result(property = "userSources", column = "user_sources")
        })
    @Select(value = "select *from  users")
    public List<Users> queryuser();
}
