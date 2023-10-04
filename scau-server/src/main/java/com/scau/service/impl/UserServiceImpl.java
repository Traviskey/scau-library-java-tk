package com.scau.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scau.constant.MessageConstant;
import com.scau.constant.StatusConstant;
import com.scau.dto.UserLoginDTO;
import com.scau.dto.UserPageQueryDTO;
import com.scau.entity.Books;
import com.scau.entity.User;
import com.scau.exception.AccountLockedException;
import com.scau.exception.AccountNotFoundException;
import com.scau.exception.PasswordErrorException;
import com.scau.mapper.UserMapper;
import com.scau.result.PageResult;
import com.scau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        User user = userMapper.getByUsername(username);

        if(user == null){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //密码比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(user.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (user.getStatus() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return user;
    }

    public User getUserData(User user){
        Long userid = user.getUserId();

        User user2 = userMapper.getByUserid(userid);
        return user2;
    }

    @Override
    public PageResult pageQuery(UserPageQueryDTO userPageQueryDTO) {
        String condition = userPageQueryDTO.getCondition();
        String query = userPageQueryDTO.getQuery();

        if(condition != null && query != null){

            if(condition.equals("book_name")){
                userPageQueryDTO.setBook_name("true");
            }
            else if(condition.equals("book_number")){
                userPageQueryDTO.setBook_number("true");
            }
            else if(condition.equals("book_type")){
                userPageQueryDTO.setBook_type("true");
            }
            else if (condition.equals("book_author")){
                userPageQueryDTO.setBook_author("true");
            }

        }
        PageHelper.startPage(userPageQueryDTO.getPageNum(),userPageQueryDTO.getPageSize());

        Page<Books> page = userMapper.pageQuery(userPageQueryDTO);

        long total = page.getTotal();
        List<Books> records = page.getResult();

        return new PageResult(total,records);



    }
}
