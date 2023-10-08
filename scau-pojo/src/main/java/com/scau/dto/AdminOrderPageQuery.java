package com.scau.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminOrderPageQuery implements Serializable {
    private int pageNum = 1;

    private int pageSize = 3;
}
