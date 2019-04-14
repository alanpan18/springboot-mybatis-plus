package com.alan.smpdemo.service.impl;

import com.alan.smpdemo.entity.User;
import com.alan.smpdemo.mapper.UserMapper;
import com.alan.smpdemo.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alan
 * @since 2019-04-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
