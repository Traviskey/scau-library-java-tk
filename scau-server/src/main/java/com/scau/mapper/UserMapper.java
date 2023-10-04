package com.scau.mapper;

import com.github.pagehelper.Page;
import com.scau.dto.UserPageQueryDTO;
import com.scau.entity.Books;
import com.scau.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {


    
    @Select("select * from t_users where username = #{username}")
    User getByUsername(String username);


@Select("select * from t_users where user_id = #{userid}")
    User getByUserid(Long userid);

    Page<Books> pageQuery(UserPageQueryDTO userPageQueryDTO);
}
