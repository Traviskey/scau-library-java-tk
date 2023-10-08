package com.scau.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateBookDTO implements Serializable {
    private String bookName;

    private String bookAuthor;

    private String bookType;

    private String bookDescription;

    private Integer bookNumber;
}
