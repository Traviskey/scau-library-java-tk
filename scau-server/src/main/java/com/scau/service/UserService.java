package com.scau.service;

import com.scau.dto.CartAddDTO;
import com.scau.dto.CollectionAddDTO;
import com.scau.dto.UserLoginDTO;
import com.scau.dto.UserPageQueryDTO;
import com.scau.entity.User;
import com.scau.result.PageResult;
import com.scau.result.Result;

public interface UserService {
    /**
     * 用户登陆
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    User getUserData(User user);

    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);

    Integer addCart(CartAddDTO cartAddDTO);

    PageResult cartQuery(UserPageQueryDTO userPageQueryDTO);

    Integer addCollection(CollectionAddDTO collectionAddDTO);

    PageResult collectionQuery(UserPageQueryDTO userPageQueryDTO);
}
