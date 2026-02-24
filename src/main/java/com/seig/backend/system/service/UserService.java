package com.seig.backend.system.service;

import com.seig.backend.pojo.dto.system.LoginResponseDto;
import com.seig.backend.system.entity.User;

public interface UserService {
    
    /**
     * 用户注册
     * @param username 用户名
     * @param password 明文密码（后端加密）
     */
    void register(String username, String password);
    
    /**
     * 用户登录
     * @param username 用户名
     * @param password 明文密码
     * @return 登录响应信息
     */
    LoginResponseDto login(String username, String password);
    
    /**
     * 根据用户ID获取用户信息
     */
    User getUserById(Long userId);
}
