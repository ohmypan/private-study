package org.spring.springboot.mybatis;

import com.guys.bean.SysPermission;
import org.springframework.stereotype.Component;

@Component
public interface SysPermissionMapper {
    int insert(SysPermission record);

    int insertSelective(SysPermission record);
}