package org.zhen77.mapper;

import org.springframework.stereotype.Component;
import org.zhen77.bean.TblCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author : zhen77
 * @date: 2021/2/26 - 02 - 26 - 13:01
 * @Description: org.zhen77.mapper
 * @version: 1.0
 */
@Component
public interface TblCompanyMapper extends BaseMapper<TblCompany> {

    public List<TblCompany> selectCompany();
}
