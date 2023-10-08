package com.scau.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddBookDTO implements Serializable {
    private String bookName;

    private String bookAuthor;

    private Integer bookTypeNumber;

    private String bookDescription;

    private String bookType;

    private Integer bookNumber;
}
