package com.guys.ilevel.spring.aop;

import java.lang.reflect.Proxy;

/**
 * File：SimpleAOP <br>
 * Created on 2019/3/20.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class SimpleAOP {
    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),bean.getClass().getInterfaces(),advice);
    }
}
