package com.seig.backend.system.controller;

import com.seig.backend.common.Result;
import com.seig.backend.pojo.dto.system.LoginRequestDto;
import com.seig.backend.pojo.dto.system.LoginResponseDto;
import com.seig.backend.pojo.dto.system.RegisterRequestDto;
import com.seig.backend.system.entity.User;
import com.seig.backend.system.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册接口
     * 接收username和password，后端进行密码加密
     */
    @PostMapping("/register")
    public Result<String> register(@RequestBody RegisterRequestDto request) {
        userService.register(request.getUsername(), request.getPassword());
        return Result.success("注册成功","祝你生活愉快2026！ -- wsyzf");
    }

    /**
     * 用户登录接口
     * 接收username和password，验证后返回JWT令牌
     */
    @PostMapping("/login")
    public Result<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        LoginResponseDto response = userService.login(request.getUsername(), request.getPassword());
        return Result.success(response);
    }
}
