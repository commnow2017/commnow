package com.example.commnowcoredao.dao;

import com.example.commnowcorepojo.pojo.TbUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserRole record);

    int insertSelective(TbUserRole record);

    TbUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserRole record);

    int updateByPrimaryKey(TbUserRole record);

    List<TbUserRole> list(TbUserRole record);
}