package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我全部的post方法")
public class MyPostMethod {
    //用来存储cookies信息
    Cookie cookie;

    /**
     * 返回cookies信息的post接口开发
     * @return
     */

    //需求场景：用户登录成功获取到cookies，然后再访问其他接口获取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        //要求参数是必须要传的
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "psw",required = true)String psw){
        if (userName.equals("zhangsan") && psw.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登录成功了！";
        }
        return "用户名或密码错误";
    }

}
