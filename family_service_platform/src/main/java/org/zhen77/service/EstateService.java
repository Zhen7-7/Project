package org.zhen77.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhen77.bean.TblCompany;
import org.zhen77.mapper.TblCompanyMapper;

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

    public List<TblCompany> selectCompany(){
        List<TblCompany> companies= tblCompanyMapper.selectCompany();

        return companies;


    }
}
