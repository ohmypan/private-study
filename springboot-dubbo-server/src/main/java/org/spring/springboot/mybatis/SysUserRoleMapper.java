package org.spring.springboot.mybatis;

import com.guys.bean.SysUserRole;

public interface SysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}