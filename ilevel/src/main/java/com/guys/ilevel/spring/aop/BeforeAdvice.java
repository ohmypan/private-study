package com.guys.ilevel.spring.aop;

import java.lang.reflect.Method;

/**
 * File：BeforeAdvice <br>
 * Created on 2019/3/20.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class BeforeAdvice implements Advice {
    private Object bean;
    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean,MethodInvocation methodInvocation){
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始调用");
        methodInvocation.invoke();
        System.out.println("调用结束");
        return method.invoke(bean,args);
    }
}
