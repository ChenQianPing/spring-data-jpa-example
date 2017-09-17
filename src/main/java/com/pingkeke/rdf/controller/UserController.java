package com.pingkeke.rdf.controller;

import com.pingkeke.rdf.domain.User;
import com.pingkeke.rdf.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController.
 * http://localhost:8080/swagger-ui.html
 */
@Api(tags = "用户管理相关接口")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value = "/add/{id}/{name}/{address}", method=RequestMethod.GET)
    public User addUser(@PathVariable int id, @PathVariable String name,
                        @PathVariable String address)
    {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        userService.saveUser(user);
        return user;
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType="path", dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id)
    {
        userService.delete(id);
    }

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<User> getUsers()
    {
        return userService.findAll();
    }

    @ApiOperation(value="分页获取用户列表", notes="")
    @RequestMapping(value={"getPageUsers/{page}/{size}"}, method= RequestMethod.GET)
    public Page<User> getPageUsers(@PathVariable int page, @PathVariable int size)
    {
        return userService.findPage(page,size);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType="path", dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable int id)
    {
        User user = userService.findOne(id);
        return user;
    }

    @ApiOperation(value="获取用户列表", notes="根据用户名查询")
    @RequestMapping(value = "/search/name/{name}", method=RequestMethod.GET)
    public List<User> getUserByName(@PathVariable String name)
    {
        List<User> users = userService.findByName(name);
        return users;
    }

}



/**
 *
 * spring-data-jpa-example
 *
 * http://localhost:8080/users/
 http://localhost:8080/users/add/100/110/111
 http://localhost:8080/users/delete/100
 http://localhost:8080/users/search/name/2
 http://localhost:8080/users/100
 */
