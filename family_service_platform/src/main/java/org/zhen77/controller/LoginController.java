package org.zhen77.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zhen77.bean.TblUserRecord;
import org.zhen77.returnJson.Permission;
import org.zhen77.returnJson.Permissions;
import org.zhen77.returnJson.ReturnObject;
import org.zhen77.returnJson.UserInfo;
import org.zhen77.service.LoginService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhen77
 * @date: 2021/2/26 - 02 - 26 - 13:01
 * @Description: org.zhen77.controller
 * @version: 1.0
 */
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/auth/2step-code")
    public Boolean test(){
        System.out.println("前端框架自带的一个验证规则，写不写无所谓");
        return true;
    }
    @RequestMapping("/auth/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        System.out.println("login");
        TblUserRecord tblUserRecord = loginService.login(username,password);
        tblUserRecord.setToken(tblUserRecord.getUserName());//可以用AOP,而且更高效
        //将用户数据写入到session中
        session.setAttribute("userRecord",tblUserRecord);
        ReturnObject returnObject = new ReturnObject(tblUserRecord);//设计模式
        return JSONObject.toJSONString(returnObject);
    }
    @RequestMapping("/user/info")
    public String getInfo(HttpSession session){//共享session数据
        TblUserRecord tblUserRecord = (TblUserRecord)session.getAttribute("userRecord");
        //获取模块信息用"-"拼接
        String[] split = tblUserRecord.getTblRole().getRolePrivileges().split("-");
        //创建权限集合对象
        Permissions permissions = new Permissions();
        //向集合对象中添加具体的权限
        List<Permission> permissionList = new ArrayList<>();
        for (String s : split) {
            permissionList.add(new Permission(s));
        }
        permissions.setPermissions(permissionList);
        //设置返回值的result
        UserInfo userInfo = new UserInfo(tblUserRecord.getUserName(), permissions);
        return JSONObject.toJSONString(new ReturnObject(userInfo));

    }
    @RequestMapping("/auth/logout")
    public String logOut(HttpSession session){
        System.out.println("退出登录");
        session.invalidate();//使session无效
//        return JSONObject.toJSONString(new ReturnObject(null));
        return "";
    }
}
