package com.pingkeke.rdf.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 实现一个简单请求处理：通过传入name参数，返回“hello xxx”的功能.
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }
}
