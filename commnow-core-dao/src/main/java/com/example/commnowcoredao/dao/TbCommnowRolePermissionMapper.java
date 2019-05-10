package com.example.commnowcoredao.dao;

import com.example.commnowcorepojo.pojo.TbCommnowRolePermission;

public interface TbCommnowRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCommnowRolePermission record);

    int insertSelective(TbCommnowRolePermission record);

    TbCommnowRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCommnowRolePermission record);

    int updateByPrimaryKey(TbCommnowRolePermission record);
}