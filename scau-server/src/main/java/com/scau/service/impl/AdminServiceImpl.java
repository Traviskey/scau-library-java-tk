package com.scau.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scau.constant.MessageConstant;
import com.scau.constant.StatusConstant;
import com.scau.dto.*;
import com.scau.entity.Admin;
import com.scau.entity.OrderInfo;
import com.scau.entity.Type;
import com.scau.entity.User;
import com.scau.exception.AccountLockedException;
import com.scau.exception.AccountNotFoundException;
import com.scau.exception.PasswordErrorException;
import com.scau.mapper.AdminMapper;
import com.scau.result.PageResult;
import com.scau.service.AdminService;
import com.scau.vo.SystemVO;
import com.scau.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Random;

@Service
public class AdminServiceImpl implements AdminService {
   @Autowired
   private AdminMapper adminMapper;
    @Override
    public Admin login(AdminLoginDTO adminLoginDTO) {
        String username = adminLoginDTO.getUsername();

        String password = adminLoginDTO.getPassword();

        Admin admin = adminMapper.getByUsername(username);

        if(admin == null){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //密码比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(admin.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (admin.getStatus() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return admin;
    }

    @Override
    public Admin getAdminData(Admin admin) {
        Long adminid = admin.getAdminId();

        Admin admin2 = adminMapper.getByAdminid(adminid);

        return admin2;
    }

    @Override
    public void addBook(AddBookDTO addBookDTO) {
        Random random = new Random();
        Integer number = random.nextInt(1000);
        addBookDTO.setBookNumber(number);
     //   String bookType = adminMapper.getBookType(addBookDTO.getBookTypeNumber());
      //  addBookDTO.setBookType(bookType);
        adminMapper.addBook(addBookDTO);
    }

    @Override
    public List<TypeVO> getType() {
        return adminMapper.getType();
    }

    @Override
    public void updateBook(UpdateBookDTO updateBookDTO) {
        adminMapper.updateBook(updateBookDTO);
    }

    @Override
    public void deleteBook(Integer bookId) {
        adminMapper.deleteBook(bookId);
    }

    @Override
    public PageResult pageQuery(TypePageDTO typePageDTO) {
        PageHelper.startPage(typePageDTO.getPageNum(),typePageDTO.getPageSize());



        Page<Type> page = adminMapper.typeQuery(typePageDTO);

        long total = page.getTotal();

        List<Type> records = page.getResult();

        return new PageResult(total,records);

    }

    @Override
    public void addBookType(Type type) {
        adminMapper.addBookType(type);
    }

    @Override
    public void deleteBookType(Integer typeId) {
        adminMapper.dekleteBookType(typeId);
    }




    @Override
    public Type getTypeById(Integer typeId) {
       return adminMapper.getTypeById(typeId);

    }

    @Override
    public void updateType(Type type) {
        adminMapper.updateType(type);
    }

    @Override
    public PageResult orderQuery(AdminOrderPageQuery adminOrderPageQuery) {
        PageHelper.startPage(adminOrderPageQuery.getPageNum(),adminOrderPageQuery.getPageSize());



        Page<OrderInfo> page = adminMapper.adminorderQuery(adminOrderPageQuery);

        long total = page.getTotal();

        List<OrderInfo> records = page.getResult();

        return new PageResult(total,records);
    }

    @Override
    public Integer setStatus(SetStatusDTO setStatusDTO) {
        setStatusDTO.setUserId(adminMapper.getUserId(setStatusDTO.getCardName()));
        if(adminMapper.getOrderStatus(setStatusDTO) == 1) return 0;
        adminMapper.setadminorderStatus(setStatusDTO);

        adminMapper.setuserorderStatus(setStatusDTO);
        return 1;
    }

    @Override
    public PageResult getUser(GetUserDTO getUserDTO) {
        PageHelper.startPage(getUserDTO.getPageNum(),getUserDTO.getPageSize());



        Page<User> page = adminMapper.getUser(getUserDTO);

        long total = page.getTotal();

        List<User> records = page.getResult();

        return new PageResult(total,records);
    }

    @Override
    public SystemVO getsystem() {
        return adminMapper.getsystem();
    }

    @Override
    public void updateInfo(SystemDTO systemDTO) {
        SystemVO systemVO = adminMapper.getsystem();
        systemDTO.setPrimetele(systemVO.getTele());
        systemDTO.setPrimepostcode(systemVO.getPostcode());
        adminMapper.updateInfo(systemDTO);
    }

    @Override
    public void setBookType(String bookType) {
        adminMapper.setBookType(bookType);
    }


}
