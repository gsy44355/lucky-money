package com.gsy.luckymoney.service;

import com.gsy.luckymoney.pojo.UserInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface UserService {
    void saveUser(UserInfo userInfo) throws  Exception;
    void updateUser(UserInfo userInfo);
    void deleteUserById(String UserId);
    UserInfo queryById(String UserId);
    List<UserInfo> list(UserInfo userInfo);
    List<UserInfo> list(UserInfo userInfo,Integer page,Integer pageSize);
    List<Map> listByMe(Map params);
}
