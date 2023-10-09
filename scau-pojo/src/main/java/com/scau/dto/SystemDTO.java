package com.scau.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemDTO implements Serializable {
    private Integer tele;

    private Integer postcode;

    private Integer primetele;

    private Integer primepostcode;
}
