package org.zhen77.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhen77.bean.TblUserRecord;
import org.zhen77.service.LoginService;

/**
 * @author : zhen77
 * @date: 2021/2/26 - 02 - 26 - 13:01
 * @Description: org.zhen77.controller
 * @version: 1.0
 */
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
public class LoginController {
    LoginService loginService;
    @RequestMapping("/auth/login")
    public Object login(String username,String password){
        TblUserRecord tblUserRecord = loginService.login(username,password);

        System.out.println("login");
        System.out.println(tblUserRecord);
        return JSONObject.parseObject(JSONObject.toJSONString(tblUserRecord));
    }
}
