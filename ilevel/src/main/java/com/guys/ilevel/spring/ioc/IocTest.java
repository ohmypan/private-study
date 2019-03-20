package com.guys.ilevel.spring.ioc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
public class IocTest {
    @Test
    public void test() throws Exception{

        String location =
                SimpleIOC.class.getClassLoader().getResource("spring/spring-ioc.xml").getFile();
        System.out.println(location);

        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }
}
