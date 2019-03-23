package org.spring.springboot.dubbo.impl.shiro;

import com.alibaba.dubbo.config.annotation.Service;
import com.guys.iinterface.shiro.SysPermissionService;
import org.spring.springboot.mybatis.SysPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * File：SysPermissionServiceImpl <br>
 * Created on 2019/3/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Override
    public List<String> selectPermissionByUserId(Long userId) {
        return null;
    }
}
