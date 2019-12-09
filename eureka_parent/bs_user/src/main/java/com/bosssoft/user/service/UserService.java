package com.bosssoft.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bosssoft.user.dto.UserDto;

import java.util.List;

public interface UserService extends IService<UserDto> {

    /**
     * 获取用户列表
     * @return
     */
    List<UserDto> getUserList();
}
