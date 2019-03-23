package com.guys.iinterface.shiro;

import java.util.List;

/**
 * File：SysPermissionService <br>
 * Created on 2019/3/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public interface SysPermissionService {
    List<String> selectPermissionByUserId(Long userId);
}
