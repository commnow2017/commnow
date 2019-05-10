package com.example.commnowcoreuser.service.impl;

import com.example.commnowcoredao.dao.TbCommnowRoleMapper;
import com.example.commnowcoredao.dao.TbCommnowRolePermissionMapper;
import com.example.commnowcorepojo.pojo.TbCommnowRole;
import com.example.commnowcorepojo.pojo.TbCommnowRolePermission;
import com.example.commnowcoreuser.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private TbCommnowRoleMapper tbCommnowRoleMapper;

    @Autowired
    private TbCommnowRolePermissionMapper tbCommnowRolePermissionMapper;

    @Override
    public Integer save(TbCommnowRole tbCommnowRole,String permissionIds) {
        //出现异常，事务回滚，并返回0表示新增失败
        try{
            Integer roleId = tbCommnowRoleMapper.insert(tbCommnowRole);
            for (String permissionId : permissionIds.split(",")) {
                TbCommnowRolePermission commnowRolePermission = new TbCommnowRolePermission();
                commnowRolePermission.setPermissionId(Integer.parseInt(permissionId));
                commnowRolePermission.setRoleId(roleId);
                commnowRolePermission.setCreateDate(new Date());
                tbCommnowRolePermissionMapper.insert(commnowRolePermission);
            }
            return roleId;
        }catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public List<TbCommnowRole> list(String searchParam,Integer institutionId) {
        return tbCommnowRoleMapper.list(searchParam,institutionId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbCommnowRole tbCommnowRole,String permissionIds) {
        //出现异常，事务回滚，并返回0表示修改失败
        try{
            Integer count = tbCommnowRoleMapper.updateByPrimaryKeySelective(tbCommnowRole);
            if(tbCommnowRole.getRoleId() != null){
                //先删除所有和角色和相关的权限，在新增
                tbCommnowRolePermissionMapper.deleteRoleId(tbCommnowRole.getRoleId());
                for (String permissionId : permissionIds.split(",")) {
                    TbCommnowRolePermission commnowRolePermission = new TbCommnowRolePermission();
                    commnowRolePermission.setPermissionId(Integer.parseInt(permissionId));
                    commnowRolePermission.setRoleId(tbCommnowRole.getRoleId());
                    commnowRolePermission.setCreateDate(new Date());
                    tbCommnowRolePermissionMapper.insert(commnowRolePermission);
                }
            }
            return count;
        }catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int deleteByPrimaryKey(Integer roleId) {
        return tbCommnowRoleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public TbCommnowRole selectByPrimaryKey(Integer roleId) {
        return tbCommnowRoleMapper.selectByPrimaryKey(roleId);
    }
}
