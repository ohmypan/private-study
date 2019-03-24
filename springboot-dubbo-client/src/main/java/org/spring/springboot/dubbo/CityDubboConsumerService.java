package org.spring.springboot.dubbo;

import com.guys.bean.City;
import com.guys.iinterface.CityDubboService;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket
 */
@Component
public class CityDubboConsumerService {

    CityDubboService cityDubboService;

    public void printCity() {
        String cityName="温岭";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
    }
}
