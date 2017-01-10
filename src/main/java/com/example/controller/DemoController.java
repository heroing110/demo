package com.example.controller;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heroing110 on 2017-01-10.
 */
@RestController
@ImportAutoConfiguration
public class DemoController {
    @RequestMapping(value = "/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }
}
