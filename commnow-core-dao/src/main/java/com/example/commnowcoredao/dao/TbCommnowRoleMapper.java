package com.example.commnowcoredao.dao;

import com.example.commnowcorepojo.pojo.TbCommnowRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbCommnowRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(TbCommnowRole record);

    int insertSelective(TbCommnowRole record);

    TbCommnowRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(TbCommnowRole record);

    int updateByPrimaryKey(TbCommnowRole record);

    List<TbCommnowRole> list(@Param("searchParam") String searchParam,@Param("institutionId") Integer institutionId);
}