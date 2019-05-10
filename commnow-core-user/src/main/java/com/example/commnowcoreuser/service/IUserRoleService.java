package com.example.commnowcoreuser.service;

import com.example.commnowcorepojo.pojo.TbUserRole;

import java.util.List;

public interface IUserRoleService {

    //新增用户和角色关联记录
    int insert(TbUserRole record);

    //根据记录id查询关联记录
    TbUserRole selectByPrimaryKey(Integer id);

    //修改记录值
    int updateByPrimaryKeySelective(TbUserRole record);

    //根据条件查询
    List<TbUserRole> list(TbUserRole record);
}
