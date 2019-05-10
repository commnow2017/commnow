package com.example.commnowcoreuser.service;

import com.example.commnowcorepojo.pojo.TbCommnowPermission;

import java.util.List;

public interface IPermissionService {

    //新增权限
    public Integer save(TbCommnowPermission commnowPermission);

    //修改权限
    public Integer update(TbCommnowPermission commnowPermission);

    //删除权限
    public Integer delete(Integer permissionId);

    //多条件查询，目前支持权限名称
    public List<TbCommnowPermission> list(String permissionName);

    //获取单个权限
    public TbCommnowPermission getPermission(Integer permissionId);

}
