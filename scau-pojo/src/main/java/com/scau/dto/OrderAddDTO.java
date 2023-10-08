package com.scau.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class OrderAddDTO implements Serializable {
    private Integer orderNumber;

    private Integer userId;

    private String bookName;

    private String cardName;

    private String address;
}
