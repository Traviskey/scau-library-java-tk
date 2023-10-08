package com.scau.service;

import com.scau.dto.*;
import com.scau.entity.Admin;
import com.scau.entity.Type;
import com.scau.result.PageResult;
import com.scau.vo.SystemVO;
import com.scau.vo.TypeVO;

import java.util.List;

public interface AdminService {
    Admin login(AdminLoginDTO adminLoginDTO);

    Admin getAdminData(Admin admin);

    void addBook(AddBookDTO addBookDTO);


    List<TypeVO> getType();

    void updateBook(UpdateBookDTO updateBookDTO);

    void deleteBook(Integer bookId);

    PageResult pageQuery(TypePageDTO typePageDTO);

    void addBookType(Type type);

    void deleteBookType(Integer typeId);



    Type getTypeById(Integer typeId);

    void updateType(Type type);

    PageResult orderQuery(AdminOrderPageQuery adminOrderPageQuery);

    Integer setStatus(SetStatusDTO setStatusDTO);

    PageResult getUser(GetUserDTO getUserDTO);


    SystemVO getsystem();

    void updateInfo(SystemDTO systemDTO);

    void setBookType(String bookType);
}
