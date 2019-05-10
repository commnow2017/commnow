package com.example.commnowcoreuser.service.impl;

import com.example.commnowcoredao.dao.TbInstitutionMapper;
import com.example.commnowcorepojo.pojo.TbInstitution;
import com.example.commnowcoreuser.service.IInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@SuppressWarnings("ALL")
@Service
@Transactional
public class InstitutionServiceImpl implements IInstitutionService {

    @Autowired
    private TbInstitutionMapper institutionMapper;

    @Override
    public Integer save(TbInstitution institution) {
        return institutionMapper.insert(institution);
    }

    @Override
    public Integer updaue(TbInstitution institution) {
        return institutionMapper.updateByPrimaryKeySelective(institution);
    }

    @Override
    public Integer delete(Integer institutionId) {
        //通过institutionId查询出现当前机构是否存在下一级，如果有则不能删除
        if(institutionMapper.list("",institutionId) == null){
            return institutionMapper.deleteByPrimaryKey(institutionId);
        }else{
            return 0;//代表不能删除
        }
    }

    @Override
    public List<TbInstitution> list(String searchParam, Integer pId) {
        return institutionMapper.list(searchParam,pId);
    }
}
