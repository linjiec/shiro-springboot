package com.shiro.springboot.dao;

import com.shiro.springboot.entity.UserInfo;
import com.shiro.springboot.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * UserInfoDao
 *
 * @author linjie
 * @date 2018/8/27
 */
@Repository
public class UserInfoDao {

    @Autowired
    public UserInfoMapper userInfoMapper;

    public UserInfo findByUsername(String username){
       return userInfoMapper.findByUsername(username);
    }

}
