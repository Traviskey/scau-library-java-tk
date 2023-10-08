package com.scau.controller.user;

import com.scau.constant.JwtClaimsConstant;
import com.scau.dto.*;
import com.scau.entity.User;
import com.scau.properties.JwtProperties;
import com.scau.result.PageResult;
import com.scau.result.Result;
import com.scau.service.UserService;
import com.scau.utils.JwtUtil;
import com.scau.vo.CategoryVO;
import com.scau.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private UserService userService;

    /**
     * 用户登陆
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录：{}", userLoginDTO);

        User user = userService.login(userLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, user.getUserId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getUserId())

                .token(token)

                .build();

        return Result.success(userLoginVO);
    }

    /**
     * 获取个人信息
     * @param user
     * @return
     */
    @PostMapping("/getData")
    public Result<User> getUserData(@RequestBody User user){

        return Result.success(userService.getUserData(user));
    }

    @PostMapping("/search_book_page" )
    public Result<PageResult> page(@RequestBody UserPageQueryDTO userPageQueryDTO){
        PageResult pageResult = userService.pageQuery(userPageQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping("/cart_add")
    public Result addCart(@RequestBody CartAddDTO cartAddDTO){
        Integer flag = userService.addCart(cartAddDTO);
        if(flag == 1) return Result.success();
        else return Result.error("重复！");
    }

    /**
     * 时间不够，delete和add的dto可以通用，就不再写另一个CartDelete了
     * @return
     */
    @PostMapping("/cart_delete")
    public Result deleteCart(@RequestBody CartAddDTO cartAddDTO){
        userService.deleteCart(cartAddDTO);
        return Result.success();
    }

    @PostMapping("/collection_delete")
    public Result deleCollection(@RequestBody CollectionAddDTO collectionAddDTO){
        userService.deleCollection(collectionAddDTO);
        return Result.success();
    }

    @PostMapping("/search_cart_page")
    public Result<PageResult> cart(@RequestBody UserPageQueryDTO userPageQueryDTO){
        PageResult pageResult = userService.cartQuery(userPageQueryDTO);
        return Result.success(pageResult);
    }


    @PostMapping("/collection_add")
    public Result addCollection(@RequestBody CollectionAddDTO collectionAddDTO){
        Integer flag = userService.addCollection(collectionAddDTO);
        if(flag == 1) return Result.success();
        else return Result.error("重复！");
    }

    @PostMapping("/order_add")
    public Result addOrder(@RequestBody OrderAddDTO orderAddDTO){
        Integer flag = userService.addOrder(orderAddDTO);
        if(flag == 1) return Result.success();
        else return Result.error("重复！");
    }

    @PostMapping("/search_collection_page")
    public Result<PageResult> collection(@RequestBody UserPageQueryDTO userPageQueryDTO){
        PageResult pageResult = userService.collectionQuery(userPageQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping("/search_order_page")
    public Result<PageResult> order(@RequestBody OrderPageQueryDTO orderPageQueryDTO){
        PageResult pageResult = userService.orderQuery(orderPageQueryDTO);
        return Result.success(pageResult);
    }

    @GetMapping("/get_information/{userId}")
    public Result<User> information(@PathVariable("userId") Integer userId){

        User user = userService.getUserById(userId);
        return Result.success(user);
    }

    @PostMapping("/update_info")
    public Result updateInfo(@RequestBody User user){
        userService.updateInfo(user);
        return Result.success();
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        userService.register(user);
        return Result.success();
    }

    @GetMapping("/searchCategory")
    public Result<CategoryVO> searchCategory(){
        CategoryVO categoryVO = userService.getCategory();
        return Result.success(categoryVO);
    }




}
