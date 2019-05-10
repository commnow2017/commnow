package com.example.commnowcoreuser.controller;

import com.example.commnowcorepojo.pojo.TbCommnowRole;
import com.example.commnowcorepojo.pojo.TbCommnowUser;
import com.example.commnowcoreuser.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class RoleController {

    @Autowired
    private HttpSession session;

    @Autowired
    private IRoleService roleService;

    @ResponseBody
    @RequestMapping("role/save")
    public String saveRole(TbCommnowRole commnowRole,String permissionIds){
        TbCommnowUser commnowUser = (TbCommnowUser) session.getAttribute("user");
        commnowRole.setInstitutionId(commnowUser.getInstitutionId());
        commnowRole.setCreateDate(new Date());
        commnowRole.setUpdateDate(new Date());
        Integer roleId = roleService.save(commnowRole,permissionIds);
        if(roleId > 0){
            return "redirect:role/list";
        }else{
            return "新增失败，你重新填写";
        }
    }

    @RequestMapping("role/list")
    public String list(String searchParam, Model model){
        TbCommnowUser commnowUser = (TbCommnowUser) session.getAttribute("user");
        model.addAttribute("list",roleService.list(searchParam,commnowUser.getInstitutionId()));
        return "role/list";
    }

    /**
     * 通过任意参数，查询出对象，并返回
     * @param searchParam
     * @return
     */
    @ResponseBody
    @RequestMapping("role/getRole")
    public TbCommnowRole getRole(String searchParam){
        TbCommnowUser commnowUser = (TbCommnowUser) session.getAttribute("user");
        return roleService.list(searchParam,commnowUser.getInstitutionId()).get(0);
    }

    @RequestMapping("role/update")
    public String roleUpdate(TbCommnowRole commnowRole,String permissionIds){
        commnowRole.setUpdateDate(new Date());
        Integer count = roleService.updateByPrimaryKeySelective(commnowRole,permissionIds);
        if(count > 0){
            return "redirect:role/list";
        }else{
            return count.toString();
        }
    }

    @RequestMapping("role/delete")
    public String roleDelete(Integer roleId){
       Integer count = roleService.deleteByPrimaryKey(roleId);
        if(count == 1){
            return "redirect:role/list";
        }else{
            return count.toString();
        }
    }
}
