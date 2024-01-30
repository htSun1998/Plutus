package com.plutus.backend.controller;

import com.plutus.backend.entity.Response;
import com.plutus.backend.entity.User;
import com.plutus.backend.service.UserService;
import com.plutus.backend.utils.JWTUtil;
import com.plutus.backend.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/register")
    public Response<Object> register(@RequestBody User user) {
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty()) {
            return Response.error("请输入完整的信息");
        }
        User u = userService.findByUsername(user.getUsername());
        if (u == null) {
            userService.register(user);
            return Response.success();
        }
        return Response.error("用户名已被占用");
    }

    @PostMapping("/login")
    public Response<Object> login(@RequestBody User user) {
        User loginUser = userService.findByUsername(user.getUsername());
        if (loginUser == null) {
            return Response.error("用户名错误");
        }
        if (!user.getPassword().equals(loginUser.getPassword())) {
            return Response.error("密码错误");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", loginUser.getId());
        claims.put("username", loginUser.getUsername());
        String token = JWTUtil.getToken(claims);
        return Response.success(token);
    }

    @GetMapping("/userInfo")
    public Response<Object> userInfo() {
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUsername(username);
        return Response.success(user);
    }

    @PutMapping("/update")
    public Response<Object> update(@RequestBody User user) {
        userService.update(user);
        return Response.success();
    }

    @PatchMapping("/updateAvatar")
    public Response<Object> updateAvatar(@RequestParam String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Response.success();
    }

    @PatchMapping("/updatePwd")
    public Response<Object> updatePwd(@RequestBody Map<String, String> params) {
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return Response.error("缺少必要的参数");
        }
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUsername(username);
        if (!loginUser.getPassword().equals(oldPwd)) {
            return Response.error("原密码填写不正确");
        }
        if (!rePwd.equals(newPwd)){
            return Response.error("两次填写的新密码不一样");
        }
        userService.updatePwd(newPwd);
        return Response.success();
    }
}
