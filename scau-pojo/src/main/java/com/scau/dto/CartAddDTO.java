package com.scau.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartAddDTO implements Serializable {
    private String userId;

    private String bookNumber;

    private String bookName;
}
