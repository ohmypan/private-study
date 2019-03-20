package com.guys.ilevel.spring.ioc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * File：Car <br>
 * Created on 2019/3/20.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Getter
@Setter
@ToString
public class Car {
    private String name;
    private String length;
    private String width;
    private String height;
    private Wheel wheel;
}
