package com.guys.ilevel.mybatis;


import com.guys.ilevel.model.SysPermission;
import org.springframework.stereotype.Component;

@Component
public interface SysPermissionMapper {
    int insert(SysPermission record);

    int insertSelective(SysPermission record);
}