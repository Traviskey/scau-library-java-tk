package com.scau.controller.admin;

import com.scau.constant.JwtClaimsConstant;
import com.scau.dto.*;
import com.scau.entity.Admin;
import com.scau.entity.Type;
import com.scau.entity.User;
import com.scau.properties.JwtProperties;
import com.scau.result.PageResult;
import com.scau.result.Result;
import com.scau.service.AdminService;
import com.scau.utils.JwtUtil;
import com.scau.vo.AdminLoginVO;
import com.scau.vo.SystemVO;
import com.scau.vo.TypeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result<AdminLoginVO> login(@RequestBody AdminLoginDTO adminLoginDTO){
        log.info("管理员登录：{}", adminLoginDTO);

        Admin admin = adminService.login(adminLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, admin.getAdminId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        AdminLoginVO adminLoginVO = AdminLoginVO.builder()
                .id(admin.getAdminId())

                .token(token)

                .build();

        return Result.success(adminLoginVO);
    }

    @PostMapping("/getData")
    public Result<Admin> getAdminData(@RequestBody Admin admin){
        Admin admin1 = adminService.getAdminData(admin);
        return Result.success(admin1);
    }

    @PostMapping("/add_book")
    public Result addBook(@RequestBody AddBookDTO addBookDTO){
        adminService.addBook(addBookDTO);
        return Result.success();
    }

    @GetMapping("get_type")
    public Result<List<TypeVO>> getType(){
        List<TypeVO> typeVo = adminService.getType();

        return Result.success(typeVo);
    }

    @PostMapping("/update_book")
    public Result updateBook(@RequestBody UpdateBookDTO updateBookDTO){
        adminService.updateBook(updateBookDTO);
        return Result.success();
    }

    @GetMapping("/delete_book/{bookId}")
    public Result deleteBook(@PathVariable("bookId") Integer bookId){
        adminService.deleteBook(bookId);
        return Result.success();
    }

    @PostMapping("/get_booktype_page")
    public Result<PageResult> getTypePage(@RequestBody TypePageDTO typePageDTO){
        PageResult pageResult = adminService.pageQuery(typePageDTO);
        return Result.success(pageResult);
    }

    @PostMapping("/add_booktype")
    public Result addBookType(@RequestBody Type type){
        adminService.addBookType(type);
        return Result.success();
    }

    @GetMapping("/delete_booktype/{typeId}")
    public Result deleteBookType(@PathVariable("typeId") Integer typeId){
        adminService.deleteBookType(typeId);
        return Result.success();
    }

    @PostMapping("/update_booktype")
    public Result updateType(@RequestBody Type type){
        adminService.updateType(type);
        return Result.success();
    }

    @GetMapping("/get_booktype/{id}")
    public Result getBookTypeById(@PathVariable("id") Integer typeId){
        Type type = adminService.getTypeById(typeId);
        return Result.success(type);
    }

    @PostMapping("/search_order_page")
    public Result<PageResult> order(@RequestBody AdminOrderPageQuery adminOrderPageQuery){
        PageResult pageResult = adminService.orderQuery(adminOrderPageQuery);
        return Result.success(pageResult);
    }

    @PostMapping("/setDeliver")
    public Result setStatus(@RequestBody SetStatusDTO setStatusDTO){
       if(adminService.setStatus(setStatusDTO) == 1) return Result.success();

       else return Result.error("请勿重复点击");
    }

    @PostMapping("/get_bookuserlist")
    public Result<PageResult> order(@RequestBody GetUserDTO getUserDTO){
        PageResult pageResult = adminService.getUser(getUserDTO);
        return Result.success(pageResult);
    }

    @GetMapping("/getsystem")
    public Result<SystemVO> getsystem(){
        SystemVO systemVO = adminService.getsystem();
        return Result.success(systemVO);
    }

    @PostMapping("/update_info")
    public Result updateInfo(@RequestBody SystemDTO systemDTO){
        adminService.updateInfo(systemDTO);
        return Result.success();
    }


}
