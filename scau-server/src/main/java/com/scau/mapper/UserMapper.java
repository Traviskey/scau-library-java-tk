package com.scau.mapper;

import com.github.pagehelper.Page;
import com.scau.dto.CartAddDTO;
import com.scau.dto.CollectionAddDTO;
import com.scau.dto.UserPageQueryDTO;
import com.scau.entity.Books;
import com.scau.entity.CartBooks;
import com.scau.entity.CollectionBooks;
import com.scau.entity.User;
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
}
