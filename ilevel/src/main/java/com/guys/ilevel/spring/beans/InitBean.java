package com.guys.ilevel.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * File：InitBean <br>
 * Created on 2019/3/21.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Component
public class InitBean implements BeanNameAware , BeanFactoryAware , ApplicationContextAware ,
        BeanPostProcessor {


    public InitBean(){

    }
    private String beanName;
    private BeanFactory beanFactory;
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
        System.out.println("BeanNameAware");
    }

    /**
     * 不推荐
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("BeanFactoryAware");
    }

    /**
     * 不推荐
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean.getClass().equals(InitBean.class)){
            System.out.println(beanName +"------ before ------");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().equals(InitBean.class)){
            System.out.println(beanName +"------ after ------");
        }
        return bean;
    }
}
