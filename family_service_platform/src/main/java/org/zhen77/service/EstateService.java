package org.zhen77.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhen77.bean.FcBuilding;
import org.zhen77.bean.FcEstate;
import org.zhen77.bean.TblCompany;
import org.zhen77.mapper.FcBuildingMapper;
import org.zhen77.mapper.FcEstateMapper;
import org.zhen77.mapper.TblCompanyMapper;
import org.zhen77.returnJson.ReturnObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhen77
 * @date: 2021/2/28 - 02 - 28 - 18:11
 * @Description: org.zhen77.service
 * @version: 1.0
 */
@Service
public class EstateService {
    @Autowired
    private TblCompanyMapper tblCompanyMapper;
    @Autowired
    private FcEstateMapper fcEstateMapper;
    @Autowired
    private FcBuildingMapper fcBuildingMapper;


    public List<TblCompany> selectCompany() {
        List<TblCompany> companies = tblCompanyMapper.selectCompany();

        return companies;
    }

    /**
     * 在插入数据之前,最好对信息进行逻辑判断,判断住宅编码是否存在,
     * 如果存在那么不允许插入,如果不存才才可以插入
     * **/
    public Integer insertEstate(FcEstate fcEstate){
        //定义查询包装类
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("estate_code",fcEstate.getEstateCode());
        FcEstate findResult = fcEstateMapper.selectOne(queryWrapper);
        int result=0;
        if(findResult!=null){
            return result;
        }else{
            result = fcEstateMapper.insert(fcEstate);
            return result;
        }
    }

    /**
     * 先插入数据,再查询
     * @param buildNumber
     * @param estateCode
     * @return
     */
    public List<FcBuilding> selectBuilding(Integer buildNumber, String estateCode){
        List<FcBuilding> fcBuildings = new ArrayList<>();
        for (int i =0;i<buildNumber;i++){
            FcBuilding fcBuilding = new FcBuilding();
            fcBuilding.setBuildingCode("B"+(i+1));
            fcBuilding.setBuildingName("第"+(i+1)+"号楼");
            fcBuilding.setEstateCode(estateCode);
            fcBuildingMapper.insert(fcBuilding);
            fcBuildings.add(fcBuilding);
        }
        return fcBuildings;
    }
    /**
     * 完成楼宇的更新功能
     * @param fcBuilding
     * @return
     */
    public Integer updateBuilding(FcBuilding fcBuilding){
        int result = fcBuildingMapper.updateById(fcBuilding);
        return result;
    }

}
