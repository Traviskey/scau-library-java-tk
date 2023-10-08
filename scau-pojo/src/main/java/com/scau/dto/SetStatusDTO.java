package com.scau.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SetStatusDTO implements Serializable {
    private Integer userId;
    private Integer orderNumber;

    private String cardName;
}
