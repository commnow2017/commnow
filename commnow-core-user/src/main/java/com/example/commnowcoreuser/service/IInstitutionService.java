package com.example.commnowcoreuser.service;

import com.example.commnowcorepojo.pojo.TbInstitution;

import java.util.List;

public interface IInstitutionService {

    public Integer save(TbInstitution institution);

    public Integer updaue(TbInstitution institution);

    public Integer delete(Integer institutionId);

    public List<TbInstitution> list(String searchParam,Integer pId);

}
