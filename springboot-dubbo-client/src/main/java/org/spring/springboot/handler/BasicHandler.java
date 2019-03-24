package org.spring.springboot.handler;

import com.alibaba.dubbo.config.annotation.Reference;
import com.guys.bean.City;
import com.guys.iinterface.CityDubboService;
import org.springframework.stereotype.Component;

/**
 * File：BasicHandler <br>
 * Created on 2019/3/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Component
public class BasicHandler {
    @Reference
    CityDubboService cityDubboService;

    public City findCityByName(String cityName) {
        return cityDubboService.findCityByName(cityName);
    }
}
