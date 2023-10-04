package com.scau.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPageQueryDTO implements Serializable {

    private int pageNum = 1;

    private int pageSize = 3;

    private String query;

    private String condition;

    private String book_number = null;

    private String book_name = null;

    private String book_type = null;

    private String book_author = null;
}
