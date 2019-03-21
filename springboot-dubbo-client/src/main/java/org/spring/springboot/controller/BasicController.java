package org.spring.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.guys.bean.City;
import com.guys.iinterface.CityDubboService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * File：BasicController <br>
 * Created on 2019/3/20.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@RestController
public class BasicController {
    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    @RequestMapping("/mm")
    public void printCity() {
        String cityName="衢州";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
    }
}
