package com.shiro.springboot.mapper;

import com.shiro.springboot.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper /*extends CrudRepository<UserInfo,Long>*/ {
    /**通过username查找用户信息;*/
    @Select("select * from user_info where username=#{username}")
    public UserInfo findByUsername(String username);
}