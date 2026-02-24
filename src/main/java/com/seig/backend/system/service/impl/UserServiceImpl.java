package com.seig.backend.system.service.impl;

import com.seig.backend.common.Result;
import com.seig.backend.pojo.dto.system.LoginResponseDto;
import com.seig.backend.system.entity.User;
import com.seig.backend.system.mapper.UserMapper;
import com.seig.backend.system.service.UserService;
import com.seig.backend.utils.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    
    @Override
    public void register(String username, String password) {
        // 检查用户名是否已存在
        User existingUser = userMapper.selectByUsername(username);
        if (existingUser != null) {
            throw new RuntimeException("用户名已存在");
        }
        
        // 使用BCrypt加密密码
        String encodedPassword = passwordEncoder.encode(password);
        
        // 创建用户
        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(encodedPassword);
        user.setAccountStatus("活跃"); // 默认激活状态
        
        userMapper.insert(user);
    }
    
    @Override
    public LoginResponseDto login(String username, String password) {
        User user = userMapper.selectByUsername(username);

//        有没有username
        if (user == null) {
            throw new RuntimeException("用户名或密码错误");
        }
        
//         验证密码，密码对不对。
        if (!passwordEncoder.matches(password, user.getPasswordHash())) {
            throw new RuntimeException("用户名或密码错误");
        }
        
//         更新最后登录时间
        user.setLastLoginAt(java.time.LocalDateTime.now());
        userMapper.updateById(user);

//        token
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("username", user.getUsername());
        claims.put("role", user.getRole());
        
//         创建登录响应
        LoginResponseDto response = new LoginResponseDto();
        response.setUserId(user.getId());
        response.setUsername(user.getUsername());
        response.setAccountStatus(user.getAccountStatus());
        response.setRole(user.getRole());
        response.setToken(jwtUtil.generateToken(user.getUsername(), claims));
        return response;
    }
    
    @Override
    public User getUserById(Long userId) {
        return userMapper.selectById(userId);
    }
}
