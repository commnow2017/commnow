package com.example.commnowcoreuser.service;

import com.example.commnowcorepojo.pojo.TbCommnowUser;

import java.util.List;

public interface IUserService {
    //新增用户
    Integer saveUser(TbCommnowUser userPojo);

    //多条件查询，目前是:名称，手机号，邮箱，公司
    List<TbCommnowUser> list(String searchParam,Integer pId);

    //修改用户信息
    Integer updateByPrimaryKeySelective(TbCommnowUser user);

    //删除用户（尽量不要删除用户，而是修改状态）
    Integer deleteByPrimaryKey(Integer userId);

    //查询单个用户信息
    TbCommnowUser selectByPrimaryKey(Integer userId);
}
