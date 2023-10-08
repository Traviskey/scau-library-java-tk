package com.scau.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private static final long serialVersionUID = 1L;

    private Long adminId;



    private String username;

    //密码
    private String password;

    private String adminName;



    private String createTime;

    private String updateTime;

    //状态
    private Integer status;


}
