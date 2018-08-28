package com.shiro.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
//@MapperScan("com.shiro.springboot.mappe")
public class ShiroSpbApplication {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
    public static void main(String[] args) {
        SpringApplication.run(ShiroSpbApplication.class, args);
    }
}
