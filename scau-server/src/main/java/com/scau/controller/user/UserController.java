package com.scau.controller.user;

import com.scau.constant.JwtClaimsConstant;
import com.scau.dto.UserLoginDTO;
import com.scau.dto.UserPageQueryDTO;
import com.scau.entity.User;
import com.scau.properties.JwtProperties;
import com.scau.result.PageResult;
import com.scau.result.Result;
import com.scau.service.UserService;
import com.scau.utils.JwtUtil;
import com.scau.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
