package com.scau.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo implements Serializable {
    private Integer orderNumber;

    private String bookName;

    private String cardName;

    private String address;

    private Integer orderStatus;
}
