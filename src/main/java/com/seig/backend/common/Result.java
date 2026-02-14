package com.seig.backend.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

//@Data
@JsonInclude(JsonInclude.Include.NON_NULL)  // null 值不输出，节省带宽
public class Result<T> {
    
    // 状态码
    private Integer code;
    
    // 提示消息
    private String message;
    
    // 返回数据
    private T data;
    
    // 时间戳
    private LocalDateTime timestamp;
    
    // 私有化构造器，强制使用静态方法创建
    private Result() {
        this.timestamp = LocalDateTime.now();
    }
    
    /**
     * 成功响应（无数据）
     */
    public static Result<Void> success() {
        Result<Void> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        return result;
    }
    /**
     * 快速构建带数据的成功响应
     */
    public static <T> Result<T> ok(T data) {
        return success("操作成功", data);
    }

    /**
     * 成功响应（带消息，无数据）
     */
    public static Result<Void> success(String message) {
        Result<Void> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        return result;
    }
    
    /**
     * 成功响应（带数据）
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }
    
    /**
     * 成功响应（带消息和数据）
     */
    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    
    /**
     * 失败响应
     */
    public static Result<Void> error(String message) {
        Result<Void> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }
    
    /**
     * 失败响应（自定义状态码）
     */
    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    
    /**
     * 失败响应（带数据，常用于返回详细的错误信息）
     */
    public static <T> Result<T> error(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    
    // ========== 链式调用支持（可选） ==========
    
    public Result<T> code(Integer code) {
        this.code = code;
        return this;
    }
    
    public Result<T> message(String message) {
        this.message = message;
        return this;
    }
    
    public Result<T> data(T data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}