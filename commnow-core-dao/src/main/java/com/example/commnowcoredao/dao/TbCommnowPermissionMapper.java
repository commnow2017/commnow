package com.example.commnowcoredao.dao;

import com.example.commnowcorepojo.pojo.TbCommnowPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbCommnowPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCommnowPermission record);

    int insertSelective(TbCommnowPermission record);

    TbCommnowPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCommnowPermission record);

    int updateByPrimaryKey(TbCommnowPermission record);

    List<TbCommnowPermission> list(String permissionName);
}