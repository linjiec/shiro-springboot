package com.shiro.springboot.service;


import com.shiro.springboot.entity.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}