package com.scau.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;


    //姓名
    private String username;

    //密码
    private String password;

    private String cardName;

    private String cardNumber;

    private String ruleNumber;

    private String createTime;

    private String updateTime;

    //状态
    private Integer status;

    //手机号
    private String mobile;

    //性别 0 女 1 男
    private String gender;

    //身份证号
    private String idNumber;

    //头像
    private String avatar;

    private String address;





}
