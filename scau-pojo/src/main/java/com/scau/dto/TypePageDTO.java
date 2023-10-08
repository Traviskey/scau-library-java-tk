package com.scau.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypePageDTO implements Serializable {
    private Integer pageNum;

    private Integer pageSize;
}
