package com.bosssoft.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bosssoft.user.dto.UserDto;
import com.bosssoft.user.mapper.UserMapper;
import com.bosssoft.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDto> implements UserService {

    /**
     * 获取用户列表
     * @return
     */
    @Override
    public List<UserDto> getUserList() {
        return this.list();
    }
}
