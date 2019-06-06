package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@Api(value = "v1",description = "这是第一个版本的demo")
@RequestMapping("v1")
public class Demo {
    //首先获取一个执行sql语句的对象

    @Autowired   //启动类获取对象
    private SqlSessionTemplate template;

    /**
     * 使用Mybatis+Springboot完成第一个查询
     * @return
     */

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "获取user表的用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

    /**
     * 使用Mybatis实现添加数据
     * @return
     */

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
//    @ApiOperation(value = "向user表增加一个用户",httpMethod = "POST")
    public int addUser(@RequestBody User user){
        System.out.println(user.toString());
        int result = template.insert("addUser",user);
        return result;
    }

    /**
     * 使用Mybatis实现修改数据
     * @param user
     * @return
     */

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(@RequestBody User user){
        return template.update("updateUser",user);
    }

    /**
     * 使用Mybatis实现删除数据
     * @param id
     * @return
     */

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public int deleteUser(@RequestParam Integer id){
        return template.delete("deleteUser",id);
    }

}
