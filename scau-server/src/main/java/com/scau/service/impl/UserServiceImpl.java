package com.scau.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scau.constant.MessageConstant;
import com.scau.constant.StatusConstant;
import com.scau.dto.*;
import com.scau.entity.*;
import com.scau.exception.AccountLockedException;
import com.scau.exception.AccountNotFoundException;
import com.scau.exception.PasswordErrorException;
import com.scau.mapper.UserMapper;
import com.scau.result.PageResult;
import com.scau.result.Result;
import com.scau.service.UserService;
import com.scau.vo.CategoryVO;
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
        CartAddDTO cartAddDTO = new CartAddDTO();
        cartAddDTO.setUserId(userPageQueryDTO.getUserId());
        Integer flag1 = userMapper.checkTableExists1(cartAddDTO);
        if(flag1 == 0) {
            userMapper.createTable1(cartAddDTO);
        }
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

    public Integer addOrder(OrderAddDTO orderAddDTO){
        OrderBooks orderBooks = new OrderBooks();
        Integer flag1 = userMapper.checkTableExists3(orderAddDTO);
        if(flag1 == 0) {
            userMapper.createTable5(orderAddDTO);
        }


        Integer flag2 = userMapper.checkBookExists3(orderAddDTO);

        Integer userId = orderAddDTO.getUserId();

        orderAddDTO.setAddress(userMapper.getAddress(userId));
        orderAddDTO.setCardName(userMapper.getCardName(userId));

        if(flag2 == 0) {
            userMapper.insertData3(orderAddDTO);
            OrderAddDTO orderAddDTO1 = userMapper.getinsertData3(orderAddDTO);
            userMapper.insertTotalData(orderAddDTO1);
            userMapper.deleteCartByBookName(orderAddDTO);
            return 1;
        }

        else return 0;
    }

    @Override
    public PageResult collectionQuery(UserPageQueryDTO userPageQueryDTO) {
        CollectionAddDTO collectionAddDTO = new CollectionAddDTO();
        collectionAddDTO.setUserId(userPageQueryDTO.getUserId());
        Integer flag1 = userMapper.checkTableExists2(collectionAddDTO);
        if(flag1 == 0) {
            userMapper.createTable2(collectionAddDTO);
        }
        PageHelper.startPage(userPageQueryDTO.getPageNum(),userPageQueryDTO.getPageSize());



        Page<CollectionBooks> page = userMapper.collectionQuery(userPageQueryDTO);

        long total = page.getTotal();

        List<CollectionBooks> records = page.getResult();

        return new PageResult(total,records);
    }

    public PageResult orderQuery(OrderPageQueryDTO orderPageQueryDTO){
        OrderAddDTO orderAddDTO = new OrderAddDTO();
        orderAddDTO.setUserId(orderPageQueryDTO.getUserId());
        Integer flag1 = userMapper.checkTableExists3(orderAddDTO);
        if(flag1 == 0) {
            userMapper.createTable5(orderAddDTO);
        }
        PageHelper.startPage(orderPageQueryDTO.getPageNum(),orderPageQueryDTO.getPageSize());



        Page<OrderInfo> page = userMapper.orderQuery(orderPageQueryDTO);

        long total = page.getTotal();

        List<OrderInfo> records = page.getResult();

        return new PageResult(total,records);
    }



    @Override
    public User getUserById(Integer userId) {
        long userid = userId;
        User user = userMapper.getByUserid(userid);
        return user;
    }

    @Override
    public void updateInfo(User user) {
        String password = user.getPassword();
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userMapper.updateInfo(user);
    }

    @Override
    public void register(User user) {
        String password = user.getPassword();
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userMapper.register(user);
        Integer userId = userMapper.getUserid(user.getUsername());
        userMapper.createTable3(userId);
        userMapper.createTable4(userId);
    }

    @Override
    public CategoryVO getCategory() {
        CategoryVO categoryVO = userMapper.getCategory();
        return categoryVO;
    }

    @Override
    public void deleteCart(CartAddDTO cartAddDTO) {
        userMapper.deleteCart(cartAddDTO);
    }

    @Override
    public void deleCollection(CollectionAddDTO collectionAddDTO) {
        userMapper.deleteCollection(collectionAddDTO);
    }
}
