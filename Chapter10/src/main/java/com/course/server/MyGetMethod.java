package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 返回cookies信息的get接口开发
 */

@RestController  //告诉主程序它是需要被扫描的类
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest  装请求信息的类
        //HttpServletResponse  装响应信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }

    /**
     * 要求客户端携带cookies访问
     */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "携带cookies信息才能访问的get请求",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "你必须携带cookies才能访问";
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")&&
            cookie.getValue().equals("true")){
                return "这是一个需要携带cookies访问的get请求";
            }
        }
        return "你必须携带cookies才能访问";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式： url的格式为:key=value&key=value
     * 模拟获取商品列表
     */

    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求的第一种实现方法",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        //实际开发中，这些数据是从数据库获取的
        Map<String,Integer> myList = new HashMap<>();
        myList.put("布鞋",150);
        myList.put("连衣裙",500);
        myList.put("小ck",228);
        return myList;
    }

    /**
     * 需要携带参数才能访问的get请求
     * 第二种实现方式：
     * url请求格式为：ip:port/get/with/param/10/30
     */

    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "需要携带参数才能访问的get请求的第一种实现方法",httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("布鞋",150);
        myList.put("连衣裙",500);
        myList.put("小ck",228);
        return myList;
    }

}
