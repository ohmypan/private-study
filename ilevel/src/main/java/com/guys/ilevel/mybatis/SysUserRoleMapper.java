package com.guys.ilevel.mybatis;


import com.guys.ilevel.model.SysUserRole;

public interface SysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}