package com.example.commnowcorepojo.pojo;

import java.util.Date;

public class TbUserRole {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public TbUserRole() {
        super();
    }

    public TbUserRole(Integer userId, Integer roleId, Date createDate) {
        this.userId = userId;
        this.roleId = roleId;
        this.createDate = createDate;
    }
}