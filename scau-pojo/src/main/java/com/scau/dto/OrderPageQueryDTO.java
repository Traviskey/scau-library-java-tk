package com.scau.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderPageQueryDTO implements Serializable {
    private int pageNum = 1;

    private int pageSize = 3;

    private Integer userId;
}
