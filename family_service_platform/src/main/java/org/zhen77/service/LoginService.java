package org.zhen77.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.zhen77.bean.TblUserRecord;
import org.zhen77.mapper.TblUserRecordMapper;

/**
 * @author : zhen77
 * @date: 2021/2/27 - 02 - 27 - 11:24
 * @Description: org.zhen77.service
 * @version: 1.0
 */
public class LoginService {
    private TblUserRecordMapper tblUserRecordMapper;

    @Autowired
    public TblUserRecord login(String username, String password){
        return tblUserRecordMapper.login(username,password);
    }
}
