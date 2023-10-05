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
public class CartBooks implements Serializable {
    private Integer bookId;


    private Long bookNumber;


    private String bookName;


    private String bookAuthor;



    private String bookType;


    private String bookDescription;



    private String createTime;


    private String updateTime;

    private String userId;


    private static final long serialVersionUID = 1L;
}
