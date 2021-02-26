package org.zhen77.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : zhen77
 * @date: 2021/2/26 - 02 - 26 - 13:01
 * @Description: org.zhen77.controller
 * @version: 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/auth/login")
    public String test(){
        System.out.println(
                "test"
        );
        return "";
    }
}
