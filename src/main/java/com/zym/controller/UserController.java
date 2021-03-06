package com.zym.controller;

import com.zym.beans.User;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
@RequestMapping(value = "/users")  // 配置一级目录
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiIgnore
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {

        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递

        List<User> ret = new ArrayList<>(users.values());
        return ret;
    }

    @ApiIgnore
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {

        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数

        users.put(user.getId(), user);
        return "success";
    }

    @ApiIgnore
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {

        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中

        return users.get(id);
    }

    @ApiIgnore
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {

        // 处理"/users/{id}"的PUT请求，用来更新User信息

        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiIgnore
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {

        // 处理"/users/{id}"的DELETE请求，用来删除User

        users.remove(id);
        return "success";
    }
}
