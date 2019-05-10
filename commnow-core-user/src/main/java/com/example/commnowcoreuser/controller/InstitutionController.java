package com.example.commnowcoreuser.controller;

import com.example.commnowcorepojo.pojo.TbCommnowUser;
import com.example.commnowcorepojo.pojo.TbInstitution;
import com.example.commnowcoreuser.service.IInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class InstitutionController {

    @Autowired
    private IInstitutionService institutionService;

    @Autowired
    private HttpSession session;

    @RequestMapping("institution/save")
    public String save(TbInstitution institution){
        //更新机构一些初始值
        TbCommnowUser commnowUser = (TbCommnowUser)session.getAttribute("user");
        institution.setCreateDate(new Date());
        institution.setTopId(0);
        institution.setParentId(commnowUser.getUserId());
        institution.setUserId(commnowUser.getUserId());
        Integer institutionId = institutionService.save(institution);
        if(institutionId > 0){
            return "redirect:institution/list";
        } else{
            return "添加失败,请检查信息重新添加";
        }
    }

    @RequestMapping("institution/update")
    public String update(TbInstitution institution){
        Integer count = institutionService.updaue(institution);
        if(count > 0){
            return "redirect:permission/list";
        } else {
            return "修改失败,请检查信息重新修改";
        }
    }

    @RequestMapping("institution/delete")
    public String delete(Integer institutionId){
        Integer count = institutionService.delete(institutionId);
        if(count > 0){
            return "redirect:permission/list";
        } else {
            return "删除失败,请检查信息重新删除";
        }
    }
    @RequestMapping("institution/list")
    public String list(String permissionName, Model model){
        TbCommnowUser commnowUser = (TbCommnowUser)session.getAttribute("user");
        model.addAttribute("list",institutionService.list(permissionName,commnowUser.getUserId()));
        return "permission/list";
    }

    @ResponseBody
    @RequestMapping("permission/getInstitution")
    public TbInstitution getInstitution(String permissionName, Model model){
        TbCommnowUser commnowUser = (TbCommnowUser)session.getAttribute("user");
        return institutionService.list(permissionName,commnowUser.getUserId()).get(0);
    }
}
