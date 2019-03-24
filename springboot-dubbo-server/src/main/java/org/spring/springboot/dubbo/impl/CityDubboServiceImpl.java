package org.spring.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.guys.bean.City;
import com.guys.iinterface.CityDubboService;
import org.springframework.stereotype.Component;

/**
 * 城市业务 Dubbo 服务层实现层
 *
 * Created by bysocket
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
@Component
public class CityDubboServiceImpl implements CityDubboService {

    @Override
    public City findCityByName(String cityName) {
        return new City(1L,2L,"衢州","是我的故乡");
    }
}
