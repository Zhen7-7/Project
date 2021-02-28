package org.zhen77.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhen77.bean.TblCompany;
import org.zhen77.mapper.TblCompanyMapper;
import org.zhen77.returnJson.ReturnObject;
import org.zhen77.service.EstateService;
import org.zhen77.service.base.TblCompanyService;

import java.util.List;

/**
 * @author : zhen77
 * @date: 2021/2/28 - 02 - 28 - 18:07
 * @Description: org.zhen77.controller
 * @version: 1.0
 */
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
public class EstateController {
    @Autowired
    private EstateService estateService;

    @RequestMapping("/estate/selectCompany")
    public String selectCompany(){
        System.out.println("selectCompany");
        List<TblCompany> companies = estateService.selectCompany();
        return JSONObject.toJSONString(new ReturnObject(companies));
    }
}
