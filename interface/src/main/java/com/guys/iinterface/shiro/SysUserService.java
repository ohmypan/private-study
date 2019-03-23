package com.guys.iinterface.shiro;

import com.guys.bean.SysUser;

/**
 * File：SysUserService <br>
 * Created on 2019/3/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public interface SysUserService {
    SysUser findByUserName(String username);
}
