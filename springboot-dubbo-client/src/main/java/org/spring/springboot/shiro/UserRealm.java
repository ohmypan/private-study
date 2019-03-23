package org.spring.springboot.shiro;

import com.guys.bean.SysUser;
import com.guys.iinterface.shiro.SysPermissionService;
import com.guys.iinterface.shiro.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * File：UserRealm <br>
 * Created on 2019/3/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class UserRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    private SysUserService sysUserService;


    private SysPermissionService sysPermissionService;

//    /**
//     * 手动注入dubbo服务
//     */
//    public void setSysUserService() {
//        ReferenceConfig<SysUserService> referenceConfig = new ReferenceConfig<>();
//        referenceConfig.setApplication(properties.applicationConfig());
//        referenceConfig.setRegistry(properties.registryConfig());
//        referenceConfig.setInterface(SysUserService.class);
//        referenceConfig.setVersion("1.0.0");
//        this.sysUserService = referenceConfig.get();
//    }
//
//    /**
//     * 手动注入dubbo服务
//     */
//    public void setSysPermissionService() {
//        ReferenceConfig<SysPermissionService> referenceConfig = new ReferenceConfig<>();
//        referenceConfig.setApplication(properties.applicationConfig());
//        referenceConfig.setRegistry(properties.registryConfig());
//        referenceConfig.setInterface(SysPermissionService.class);
//        this.sysPermissionService = referenceConfig.get();
//    }
    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        List<String> sysPermissions = sysPermissionService.selectPermissionByUserId(sysUser.getUserId());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(sysPermissions);
        logger.info("doGetAuthorizationInfo");
        return info;
    }

    /**
     * 验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUser sysUser = sysUserService.findByUserName(token.getUsername());
        if (sysUser == null) {
            return null;
        }
        logger.info("doGetAuthenticationInfo");
        return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword().toCharArray(), ByteSource.Util.bytes(sysUser.getSalt()), getName());

    }
}
