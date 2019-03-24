package com.guys.ilevel.mybatis;


import com.guys.ilevel.model.SysRole;

public interface SysRoleMapper {
    int insert(SysRole record);

    int insertSelective(SysRole record);
}