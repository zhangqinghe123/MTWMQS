package com.qianxx.qztaxi.webService.api.user;

import com.qianxx.qztaxi.service.UserService;
import com.qianxx.qztaxi.vo.User;
import com.qianxx.qztaxi.webService.response.AjaxList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/4 10:33
 */
@RestController
@RequestMapping(value = "api/user")
@Api(value = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "userLogin", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string", paramType = "query", required = true)})
    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "GET")
    public AjaxList userLogin(@RequestParam() String mobile, @RequestParam() String password) {
        User user = userService.getByMobile(mobile);
        if (user != null && user.getPassword().equals(password)) {
            return AjaxList.createSuccess("登录成功", null);
        }
        return AjaxList.createError("登录失败", null);
    }
}