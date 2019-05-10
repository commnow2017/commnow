package com.example.commnowcoreuser.service.impl;

import com.example.commnowcoredao.dao.TbUserRoleMapper;
import com.example.commnowcorepojo.pojo.TbUserRole;
import com.example.commnowcoreuser.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("ALL")
@Service
@Transactional
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private TbUserRoleMapper tbUserRoleMapper;

    @Override
    public int insert(TbUserRole record) {
        return tbUserRoleMapper.insert(record);
    }

    @Override
    public TbUserRole selectByPrimaryKey(Integer id) {
        return tbUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TbUserRole record) {
        return tbUserRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<TbUserRole> list(TbUserRole record) {
        return tbUserRoleMapper.list(record);
    }
}
