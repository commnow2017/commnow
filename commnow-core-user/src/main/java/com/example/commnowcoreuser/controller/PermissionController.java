package com.example.commnowcoreuser.controller;

import com.example.commnowcorepojo.pojo.TbCommnowPermission;
import com.example.commnowcoreuser.service.impl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PermissionController {

    @Autowired
    private PermissionServiceImpl permissionService;

    @RequestMapping("permission/save")
    public String save(TbCommnowPermission commnowPermission){
        Integer permissionId = permissionService.save(commnowPermission);
        if(permissionId > 0){
            return "redirect:permission/list";
        } else{
            return "添加失败,请检查信息重新添加";
        }
    }
    @RequestMapping("permission/update")
    public String update(TbCommnowPermission commnowPermission){
        Integer count = permissionService.update(commnowPermission);
        if(count > 0){
            return "redirect:permission/list";
        } else {
            return "修改失败,请检查信息重新修改";
        }
    }
    @RequestMapping("permission/delete")
    public String delete(Integer permissionId){
        Integer count = permissionService.delete(permissionId);
        if(count > 0){
            return "redirect:permission/list";
        } else {
            return "删除失败,请检查信息重新删除";
        }
    }

    @RequestMapping("permission/list")
    public String list(String permissionName, Model model){
        model.addAttribute("list",permissionService.list(permissionName));
        return "permission/list";
    }
}
