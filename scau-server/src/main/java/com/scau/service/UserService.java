package com.scau.service;

import com.scau.dto.UserLoginDTO;
import com.scau.dto.UserPageQueryDTO;
import com.scau.entity.User;
import com.scau.result.PageResult;

public interface UserService {
    /**
     * 用户登陆
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    User getUserData(User user);

    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);
}
