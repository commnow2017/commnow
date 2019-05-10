package com.example.commnowcoreuser.service.impl;

import com.example.commnowcoredao.dao.TbCommnowPermissionMapper;
import com.example.commnowcorepojo.pojo.TbCommnowPermission;
import com.example.commnowcoreuser.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("ALL")
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private TbCommnowPermissionMapper commnowPermissionMapper;

    @Override
    public Integer save(TbCommnowPermission commnowPermission) {
        return commnowPermissionMapper.insert(commnowPermission);
    }

    @Override
    public Integer update(TbCommnowPermission commnowPermission) {
        return commnowPermissionMapper.updateByPrimaryKeySelective(commnowPermission);
    }

    @Override
    public Integer delete(Integer permissionId) {
        return commnowPermissionMapper.deleteByPrimaryKey(permissionId);
    }

    @Override
    public List<TbCommnowPermission> list(String permissionName) {
        return commnowPermissionMapper.list(permissionName);
    }

    @Override
    public TbCommnowPermission getPermission(Integer permissionId) {
        return commnowPermissionMapper.selectByPrimaryKey(permissionId);
    }
}
