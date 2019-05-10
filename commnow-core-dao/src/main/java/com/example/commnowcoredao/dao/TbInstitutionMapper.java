package com.example.commnowcoredao.dao;

import com.example.commnowcorepojo.pojo.TbInstitution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbInstitutionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbInstitution record);

    int insertSelective(TbInstitution record);

    TbInstitution selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbInstitution record);

    int updateByPrimaryKey(TbInstitution record);

    List<TbInstitution> list(@Param("searchParam") String searchParam, @Param("pId") Integer pId);
}