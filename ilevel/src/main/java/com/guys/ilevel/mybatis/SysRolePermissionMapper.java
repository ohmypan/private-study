package com.guys.ilevel.mybatis;


import com.guys.ilevel.model.SysRolePermission;

public interface SysRolePermissionMapper {
    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);
}