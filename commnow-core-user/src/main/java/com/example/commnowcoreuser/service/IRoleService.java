package com.example.commnowcoreuser.service;

import com.example.commnowcorepojo.pojo.TbCommnowRole;

import java.util.List;

public interface IRoleService {
    //新增角色,同时新增角色权限
    Integer save(TbCommnowRole tbCommnowRole,String permissionIds);

    //多条件查询，目前是:角色名称
    List<TbCommnowRole> list(String searchParam,Integer institutionId);

    //修改角色信息，同时修改角色权限
    int updateByPrimaryKeySelective(TbCommnowRole tbCommnowRole,String permissionIds);

    //删除角色
    int deleteByPrimaryKey(Integer roleId);

    //查询单个角色信息
    TbCommnowRole selectByPrimaryKey(Integer roleId);
}
