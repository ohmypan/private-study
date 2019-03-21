package com.guys.ilevel.spring.beans;


import com.guys.ilevel.spring.ioc.SimpleIOC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * File：IocTest <br>
 * Created on 2019/3/20.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanTest {
    @Test
    public void test() throws Exception{

        String location =
                SimpleIOC.class.getClassLoader().getResource("spring/spring-test.xml").getFile();
        System.out.println(location);

        ApplicationContext context =  new FileSystemXmlApplicationContext("spring-test.xml"); ;

        InitBean initBean = (InitBean) context.getBean("initBean");
        System.out.println(initBean);
    }
}
