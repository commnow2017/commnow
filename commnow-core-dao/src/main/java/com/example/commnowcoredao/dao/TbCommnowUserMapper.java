package com.example.commnowcoredao.dao;

import com.example.commnowcorepojo.pojo.TbCommnowUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbCommnowUserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(TbCommnowUser record);

    int insertSelective(TbCommnowUser record);

    TbCommnowUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TbCommnowUser record);

    int updateByPrimaryKey(TbCommnowUser record);

    List<TbCommnowUser> list(@Param("searchParam") String searchParam,@Param("pId") Integer pId);
}