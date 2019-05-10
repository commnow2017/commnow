package com.example.commnowcoreuser.controller;

import com.example.commnowcorepojo.pojo.TbCommnowUser;
import com.example.commnowcorepojo.pojo.TbUserRole;
import com.example.commnowcoreuser.service.IUserRoleService;
import com.example.commnowcoreuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private HttpSession session;


    /**
     * 新增账户
     * @param user
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping("user/saveUser")
    public String saveUser(TbCommnowUser user,Integer roleId){
        //初始化账户状态，更新时间，创建时间
        user.setUserState(2);
        user.setUpdateDate(new Date());
        user.setCreateDate(new Date());
        Integer userId = userService.saveUser(user);
        //添加用户和角色的关联
        TbUserRole userRole = new TbUserRole(userId,roleId,new Date());
        Integer userRoleId = userRoleService.insert(userRole);
        if(userRoleId > 0){
            return "redirect:user/list";
        }else{
            return "新增失败，请检查后重新提交";
        }
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("user/updateUser")
    public String updateUser(TbCommnowUser user,Integer roleId){
        //查询出用户角色
        TbUserRole userRole = new TbUserRole();
        userRole.setUserId(user.getUserId());
        userRole = userRoleService.list(userRole).get(0);
        //判断用户角色是否更改
        if(userRole.getId() != roleId){
            userRole.setRoleId(roleId);
            userRoleService.updateByPrimaryKeySelective(userRole);
        }
        user.setUpdateDate(new Date());
        Integer count = userService.updateByPrimaryKeySelective(user);
        if(count > 0){
            return "redirect:user/list";
        }else{
            return "修改失败，请检查后重新提交";
        }
    }

    @RequestMapping("user/list")
    public String userList(String searchParam, Model model){
        TbCommnowUser commnowUser = (TbCommnowUser) session.getAttribute("user");
        model.addAttribute("list",userService.list(searchParam,commnowUser.getInstitutionId()));
        return "user/list";
    }

    @RequestMapping("user/delete")
    public String deleteUser(Integer userId){
        Integer count = userService.deleteByPrimaryKey(userId);
        if(count == 1){
            return "redirect:user/list";
        }else{
            return count.toString();
        }

    }
}
