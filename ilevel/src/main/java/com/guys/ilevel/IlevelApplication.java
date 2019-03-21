package com.guys.ilevel;

import com.guys.ilevel.spring.beans.InitBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IlevelApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(IlevelApplication.class, args);
        InitBean initBean = (InitBean) run.getBean("initBean");
        System.out.println(initBean);
    }

}
