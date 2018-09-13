package com.qianxx.qztaxi.webService.api.user;

import com.qianxx.qztaxi.po.UserInfo;
import com.qianxx.qztaxi.service.UserService;
import com.qianxx.qztaxi.webService.response.AjaxList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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
            @ApiImplicitParam(name = "account", value = "账号", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string", paramType = "query", required = true)})
    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "GET")
    public AjaxList userLogin(@RequestParam() String account, @RequestParam() String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("account", account);
        List<UserInfo> users = userService.getAll(params);
        if (!CollectionUtils.isEmpty(users) && users.get(0).getPassword().equals(password)) {
            return AjaxList.createSuccess("登录成功", null);
        }
        return AjaxList.createError("登录失败", null);
    }
}
