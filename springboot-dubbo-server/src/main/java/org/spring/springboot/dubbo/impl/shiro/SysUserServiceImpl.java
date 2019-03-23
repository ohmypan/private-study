package org.spring.springboot.dubbo.impl.shiro;

import com.alibaba.dubbo.config.annotation.Service;
import com.guys.bean.SysUser;
import com.guys.iinterface.shiro.SysUserService;
import org.spring.springboot.mybatis.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * File：SysUserServiceImpl <br>
 * Created on 2019/3/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Service(version = "1.0.0")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser findByUserName(String username) {
        return sysUserMapper.selectByUsername(username);
    }
}
