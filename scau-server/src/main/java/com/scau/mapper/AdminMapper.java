package com.scau.mapper;

import com.github.pagehelper.Page;
import com.scau.dto.*;
import com.scau.entity.*;
import com.scau.vo.SystemVO;
import com.scau.vo.TypeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select * from t_admins where username = #{username}")
    Admin getByUsername(String username);

    @Select("select * from t_admins where admin_id = #{adminid}")
    Admin getByAdminid(Long adminid);
    @Select("select book_type from t_type where  book_type_number = #{bookTypeNumber}")
    String getBookType(Integer bookTypeNumber);


    void addBook(AddBookDTO addBookDTO);

    @Select("select book_type_number,book_type from t_type")
    List<TypeVO> getType();

    void updateBook(UpdateBookDTO updateBookDTO);

    void deleteBook(Integer bookId);

    Page<Type> typeQuery(TypePageDTO typePageDTO);

    void addBookType(Type type);

    void dekleteBookType(Integer typeId);


    Type getTypeById(Integer typeId);

    void updateType(Type type);

    Page<OrderInfo> adminorderQuery(AdminOrderPageQuery adminOrderPageQuery);

    Integer getUserId(String cardName);

    void setadminorderStatus(SetStatusDTO setStatusDTO);

    void setuserorderStatus(SetStatusDTO setStatusDTO);


    int getOrderStatus(SetStatusDTO setStatusDTO);

    Page<User> getUser(GetUserDTO getUserDTO);


    SystemVO getsystem();

    void updateInfo(SystemDTO systemDTO);
}
