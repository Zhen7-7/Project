package org.zhen77.service.impl;

import org.zhen77.bean.TblTodo;
import org.zhen77.mapper.TblTodoMapper;
import org.zhen77.service.TblTodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 待办事项 服务实现类
 * </p>
 *
 * @author lian
 * @since 2021-02-26
 */
@Service
public class TblTodoServiceImpl extends ServiceImpl<TblTodoMapper, TblTodo> implements TblTodoService {

}
