package com.scau.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scau.constant.MessageConstant;
import com.scau.constant.StatusConstant;
import com.scau.dto.CartAddDTO;
import com.scau.dto.CollectionAddDTO;
import com.scau.dto.UserLoginDTO;
import com.scau.dto.UserPageQueryDTO;
import com.scau.entity.Books;
import com.scau.entity.CartBooks;
import com.scau.entity.CollectionBooks;
import com.scau.entity.User;
import com.scau.exception.AccountLockedException;
import com.scau.exception.AccountNotFoundException;
import com.scau.exception.PasswordErrorException;
import com.scau.mapper.UserMapper;
import com.scau.result.PageResult;
import com.scau.result.Result;
import com.scau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @Override
    public Integer addCart(CartAddDTO cartAddDTO) {
        CartBooks cartBooks = null;
        Integer flag1 = userMapper.checkTableExists1(cartAddDTO);
        if(flag1 == 0) {
            userMapper.createTable1(cartAddDTO);
        }


        Integer flag2 = userMapper.checkBookExists1(cartAddDTO);

        if(flag2 == 0) {
            cartBooks = userMapper.cateGet(cartAddDTO);
            cartBooks.setUserId(cartAddDTO.getUserId());
            userMapper.insertData1(cartBooks);
            return 1;
        }

        else return 0;

    }

    @Override
    public PageResult cartQuery(UserPageQueryDTO userPageQueryDTO) {
        PageHelper.startPage(userPageQueryDTO.getPageNum(),userPageQueryDTO.getPageSize());



        Page<CartBooks> page = userMapper.cartQuery(userPageQueryDTO);

        long total = page.getTotal();

        List<CartBooks> records = page.getResult();

        return new PageResult(total,records);
    }

    @Override
    public Integer addCollection(CollectionAddDTO collectionAddDTO) {
        CollectionBooks collectionBooks = null;
        Integer flag1 = userMapper.checkTableExists2(collectionAddDTO);
        if(flag1 == 0) {
            userMapper.createTable2(collectionAddDTO);
        }


        Integer flag2 = userMapper.checkBookExists2(collectionAddDTO);

        if(flag2 == 0) {
            collectionBooks = userMapper.collectionGet(collectionAddDTO);
            collectionBooks.setUserId(collectionAddDTO.getUserId());
            userMapper.insertData2(collectionBooks);
            return 1;
        }

        else return 0;
    }

    @Override
    public PageResult collectionQuery(UserPageQueryDTO userPageQueryDTO) {
        PageHelper.startPage(userPageQueryDTO.getPageNum(),userPageQueryDTO.getPageSize());



        Page<CollectionBooks> page = userMapper.collectionQuery(userPageQueryDTO);

        long total = page.getTotal();

        List<CollectionBooks> records = page.getResult();

        return new PageResult(total,records);
    }
}
