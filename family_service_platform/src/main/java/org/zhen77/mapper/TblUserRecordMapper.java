package org.zhen77.mapper;

import org.apache.ibatis.annotations.Param;
import org.zhen77.bean.TblUserRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户档案 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2021-02-26
 */
public interface TblUserRecordMapper extends BaseMapper<TblUserRecord> {
    public TblUserRecord login(@Param("username") String username, @Param("password") String password);
}
