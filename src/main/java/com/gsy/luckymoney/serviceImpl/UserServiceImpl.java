package com.gsy.luckymoney.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.gsy.luckymoney.mapper.UserInfoMapper;
import com.gsy.luckymoney.mapper.UserInfoMapperCustom;
import com.gsy.luckymoney.pojo.UserInfo;
import com.gsy.luckymoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserInfoMapperCustom userInfoMapperCustom;
    @Override
    public void saveUser(UserInfo userInfo) throws Exception {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void deleteUserById(String UserId) {

    }

    @Override
    public UserInfo queryById(String UserId) {
        return null;
    }

    @Override
    public List<UserInfo> list(UserInfo userInfo) {
        return null;
    }

    @Override
    public List<UserInfo> list(UserInfo userInfo, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        example.orderBy("id");
        List a = userInfoMapper.selectByExample(example);
        return a;
    }
    @Override
    public List<Map> listByMe(Map params){
        return userInfoMapperCustom.listByMine(params);
    }
}
