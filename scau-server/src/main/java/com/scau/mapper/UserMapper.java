package com.scau.mapper;

import com.github.pagehelper.Page;
import com.scau.dto.*;
import com.scau.entity.*;
import com.scau.vo.CategoryVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {


    
    @Select("select * from t_users where username = #{username}")
    User getByUsername(String username);


@Select("select * from t_users where user_id = #{userid}")
    User getByUserid(Long userid);

    Page<Books> pageQuery(UserPageQueryDTO userPageQueryDTO);

    Integer checkTableExists1(CartAddDTO cartAddDTO);
    Integer checkTableExists2(CollectionAddDTO collectionAddDTO);

    void createTable1(CartAddDTO cartAddDTO);
    void createTable2(CollectionAddDTO collectionAddDTO);

    //@Insert("insert into t_${userId}_cart (book_number, book_name) values (#{bookNumber})")
    void insertData1(CartBooks cartBooks);
    void insertData2(CollectionBooks collectionBooks);


    Integer checkBookExists1(CartAddDTO cartAddDTO);
    Integer checkBookExists2(CollectionAddDTO collectionAddDTO);





    CartBooks cateGet(CartAddDTO cartAddDTO);
    CollectionBooks collectionGet(CollectionAddDTO collectionAddDTO);

    Page<CartBooks> cartQuery(UserPageQueryDTO userPageQueryDTO);

    Page<CollectionBooks> collectionQuery(UserPageQueryDTO userPageQueryDTO);

    void updateInfo(User user);

    void register(User user);

    void createTable3(Integer userId);

    void createTable4(Integer userId);

    Integer getUserid(String username);


    CategoryVO getCategory();

    void deleteCart(CartAddDTO cartAddDTO);

    Integer checkTableExists3(OrderAddDTO orderAddDTO);

    void createTable5(OrderAddDTO orderAddDTO);

    Integer checkBookExists3(OrderAddDTO orderAddDTO);

    void insertData3(OrderAddDTO orderAddDTO);

    String getAddress(Integer userId);

    String getCardName(Integer userId);

    void deleteCartByBookName(OrderAddDTO orderAddDTO);

    Page<OrderInfo> orderQuery(OrderPageQueryDTO orderPageQueryDTO);

    void deleteCollection(CollectionAddDTO collectionAddDTO);

    void insertTotalData(OrderAddDTO orderAddDTO);

    OrderAddDTO getinsertData3(OrderAddDTO orderAddDTO);
}
