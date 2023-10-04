package com.scau.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录
 */
@Data
public class UserLoginDTO implements Serializable {

    private String username;

    private String password;

}
