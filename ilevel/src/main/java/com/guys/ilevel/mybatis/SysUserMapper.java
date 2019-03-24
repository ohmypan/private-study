package com.guys.ilevel.mybatis;


import com.guys.ilevel.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SysUserMapper {
    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByUsername(@Param("username") String username);
}