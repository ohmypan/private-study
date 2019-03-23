package org.spring.springboot.mybatis;

import com.guys.bean.SysRole;

public interface SysRoleMapper {
    int insert(SysRole record);

    int insertSelective(SysRole record);
}