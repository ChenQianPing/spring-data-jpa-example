package com.pingkeke.rdf.controller;

import com.pingkeke.rdf.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ExceptionController.
 * http://localhost:8080/exception
 * http://localhost:8080/json
 *
 * {"code":100,"message":"发生错误2","url":"http://localhost:8080/json","data":"Some Data"}
 *
 *
 * http://localhost:8080/
 * https://github.com
 */
@Controller
public class ExceptionController {

    @RequestMapping("/exception")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "https://github.com");
        return "index";
    }



}
