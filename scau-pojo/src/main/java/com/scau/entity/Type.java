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
public class Type implements Serializable {
    private Integer bookTypeNumber;

    private String bookType;

    private String bookTypeDescription;
}
