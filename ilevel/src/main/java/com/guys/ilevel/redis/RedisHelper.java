package com.guys.ilevel.redis;

import java.lang.reflect.Method;

/**
 * File：RedisHelper <br>
 * Created on 2019/3/18.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class RedisHelper {
    public static void main(String[] args) {
        int arr$ = 0;
        Method[] methods = RedisHelper.class.getDeclaredMethods();
        System.out.println(methods[0]);

    }
}
