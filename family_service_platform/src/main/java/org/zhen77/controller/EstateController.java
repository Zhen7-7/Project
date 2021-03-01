package org.zhen77.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhen77.bean.FcBuilding;
import org.zhen77.bean.FcEstate;
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
    //controller层应该只是传递参数用的,不应该有太多的逻辑判断,那么逻辑判断我们应该写入service层
    @RequestMapping("/estate/insertEstate")
    public String insertEstate(FcEstate fcEstate){
        System.out.println(fcEstate);
        System.out.println("insert estate");
        Integer result = estateService.insertEstate(fcEstate);
        if (result == 0){
            return JSONObject.toJSONString(new ReturnObject("0","房产编码已存在"));
        }else{
            return JSONObject.toJSONString(new ReturnObject("1","插入房产成功"));
        }
    }

    /**
     * 此处应该完成的是楼宇的查询功能,但是发现,现在数据表中没有任何楼宇的数据
     * 因此在辨析的时候需要进行插入且返回插入的数据
     *
     * @param buildingNumber
     * @param estateCode
     * @return
     */
    @RequestMapping("/estate/selectBuilding")
    public String selectBuilding(Integer buildingNumber,String estateCode){
        System.out.println("select building");
        List<FcBuilding> fcBuildings = estateService.selectBuilding(buildingNumber, estateCode);
        System.out.println(fcBuildings);
        return JSONObject.toJSONString(new ReturnObject(fcBuildings));
    }
    @RequestMapping("/estate/updateBuilding")
    public String updateBuilding(FcBuilding fcBuilding){
        System.out.println("update building");
        Integer result = estateService.updateBuilding(fcBuilding);
        if(result == 1){
            return JSONObject.toJSONString(new ReturnObject("更新楼宇成功"));
        }else{
            return JSONObject.toJSONString(new ReturnObject("更新楼宇失败"));
        }
    }
}
