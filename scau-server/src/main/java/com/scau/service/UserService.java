package com.scau.service;

import com.scau.dto.*;
import com.scau.entity.User;
import com.scau.result.PageResult;
import com.scau.result.Result;
import com.scau.vo.CategoryVO;

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

    User getUserById(Integer userId);

    void updateInfo(User user);

    void register(User user);

    CategoryVO getCategory();

    void deleteCart(CartAddDTO cartAddDTO);

    Integer addOrder(OrderAddDTO orderAddDTO);

    PageResult orderQuery(OrderPageQueryDTO orderPageQueryDTO);

    void deleCollection(CollectionAddDTO collectionAddDTO);
}
