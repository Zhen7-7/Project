package org.zhen77.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zhen77.bean.TblUserRecord;
import org.zhen77.mapper.TblUserRecordMapper;

/**
 * @author : zhen77
 * @date: 2021/2/27 - 02 - 27 - 11:24
 * @Description: org.zhen77.service
 * @version: 1.0
 */
@Service
public class LoginService {


    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;

    public TblUserRecord login(String username, String password){
        return tblUserRecordMapper.login(username,password);
    }
}

