package com.seig.backend.system.mapper;

import com.seig.backend.system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    
    /**
     * 根据用户名查询用户
     */
    User selectByUsername(@Param("username") String username);
    
    /**
     * 插入新用户
     */
    int insert(User user);
    
    /**
     * 根据ID更新用户
     */
    int updateById(User user);
    
    /**
     * 根据ID查询用户
     */
    User selectById(@Param("id") Long id);
}
