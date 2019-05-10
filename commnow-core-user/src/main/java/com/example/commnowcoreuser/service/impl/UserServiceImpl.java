package com.example.commnowcoreuser.service.impl;

import com.example.commnowcoredao.dao.TbCommnowUserMapper;
import com.example.commnowcorepojo.pojo.TbCommnowUser;
import com.example.commnowcoreuser.service.IUserService;
import com.example.commnowutilsserver.utils.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("ALL")
@Service
@Transactional(rollbackOn = Exception.class)
public class UserServiceImpl implements IUserService {


    @Autowired
    private TbCommnowUserMapper tbCommnowUserMapper;

    @Override
    public Integer saveUser(TbCommnowUser userPojo) {
        //对密码进行MD5加密
        userPojo.setPassword(UtilTools.MD5(userPojo.getPassword()));
        return tbCommnowUserMapper.insert(userPojo);
    }

    @Override
    public List<TbCommnowUser> list(String searchParam,Integer pId) {
        return tbCommnowUserMapper.list(searchParam,pId);
    }

    @Override
    public Integer updateByPrimaryKeySelective(TbCommnowUser user) {
        try{
            return tbCommnowUserMapper.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -1;
        }
    }

    @Override
    public Integer deleteByPrimaryKey(Integer userId) {
        TbCommnowUser tbCommnowUser = this.selectByPrimaryKey(userId);
        try {
            if(tbCommnowUser.getUserState() == 1){
                return tbCommnowUserMapper.deleteByPrimaryKey(userId);
            }else{
                return 2;//2代表当前用户状态处于不可删除状态
            }
        }catch (Exception e){

            return 3;//该用户不存在
        }
    }

    @Override
    public TbCommnowUser selectByPrimaryKey(Integer userId) {
        return tbCommnowUserMapper.selectByPrimaryKey(userId);
    }
}
