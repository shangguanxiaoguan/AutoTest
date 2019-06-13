package com.course.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Log4j
@RestController
@Api(value = "v1",description = "用户管理系统")
@RequestMapping("v1")
public class UserManager {
    @Autowired
    private SqlSessionTemplate template; //去数据库的对象

    @ApiOperation(value = "登录接口", httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(HttpServletResponse response,
                         @RequestBody User user){
        int i = template.selectOne("login",user);
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        log.info("查询到的结果是：" + i);
        if (i == 1){
            log.info("登录的用户是：" + user.getUserName());
            return true;
        }
        return false;
    }

    @ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Boolean addUser(HttpServletRequest request,
                           @RequestBody User user){
        Boolean x = verifyCookies(request);
        int result = 0;
        if (x==true){
            result = template.insert("addUser",user);
        }
        if (result > 0){
            log.info("添加用户的数量是："+result);
            return true;
        }
        return false;
    }

    @ApiOperation(value = "获取用户(列表)信息接口",httpMethod = "Post")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request,
                                  @RequestBody User user){
        Boolean x = verifyCookies(request);
        if (x==true){
            List<User> users = template.selectList("getUserInfo",user);
            log.info("获取到的用户数量是："+users.size());

            return users;
        }else{
            return null;
        }
    }

    @ApiOperation(value = "获取用户列表接口",httpMethod = "Post")
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    public String getUserList(HttpServletRequest request,
                                  @RequestBody User user){
        Boolean x = verifyCookies(request);
        if (x==true){
            List<User> users = template.selectList("getUserInfo",user);
            log.info("获取到的用户数量是："+users.size());
            String userListJson=JSON.toJSONString(users);
            return userListJson;
        }else{
            return null;
        }
    }


    @ApiOperation(value = "更新/删除用户信息接口",httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public int updateUserInfo(HttpServletRequest request,
                                  @RequestBody User user){
        Boolean x = verifyCookies(request);
        int result = 0;
        if (x==true){
            result = template.update("updateUserInfo",user);
        }
        log.info("更新数据的条目数是：" + result);
        return result;
    }

    private Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return false;
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")
                    &&cookie.getValue().equals("true")){
                return true;
            }
        }
        return false;
    }
}
