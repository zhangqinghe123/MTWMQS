package com.qianxx.qztaxi.webService.api.user;

import com.qianxx.qztaxi.common.util.*;
import com.qianxx.qztaxi.log.factory.ApiLoggerFactory;
import com.qianxx.qztaxi.po.PatrolRecord;
import com.qianxx.qztaxi.po.PatrolTypeDictionary;
import com.qianxx.qztaxi.po.UserInfo;
import com.qianxx.qztaxi.service.PatrolRecordsService;
import com.qianxx.qztaxi.service.PatrolTypeDictionaryService;
import com.qianxx.qztaxi.service.UserService;
import com.qianxx.qztaxi.webService.response.AjaxList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
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
@Api(value = "【用户】用户管理")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PatrolRecordsService patrolRecordsService;
    @Autowired
    private PatrolTypeDictionaryService patrolTypeDictionaryService;

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
            return AjaxList.createSuccess("登录成功", users.get(0));
        }
        return AjaxList.createError("登录失败", null);
    }

    @RequestMapping(value = "getUserById", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "int", paramType = "query", required = true)})
    @ApiOperation(value = "根据用户ID查询用户信息", notes = "根据用户ID查询用户信息", httpMethod = "GET")
    public AjaxList getUserById(@RequestParam() Integer userId) {
        UserInfo user = userService.getById(userId);
        if (user != null) {
            return AjaxList.createSuccess("查询成功", user);
        }
        return AjaxList.createError("查询失败", null);
    }

    @ApiOperation(value = "用户上传巡查图片", notes = "用户上传巡查图片", httpMethod = "POST")
    @RequestMapping(value = "/uploadPatrolInfo")
    @ResponseBody
    public AjaxList uploadPatrolInfo(@RequestParam MultipartFile patrol, @RequestParam Integer userId, @RequestParam String explain, @RequestParam Double longitude, @RequestParam Double latitude, @RequestParam(required = false) Integer patrolTypeId) {
        if (null == patrol || patrol.isEmpty()) {
            return AjaxList.createError("请上传巡查图片", null);
        }
        if (userService.getById(userId) == null) {
            return AjaxList.createError("非法用户", null);
        }
        PatrolRecord patrolRecord = new PatrolRecord();
        if (!StringUtils.isEmpty(patrolTypeId)) {
            PatrolTypeDictionary patrolTypeDictionary = patrolTypeDictionaryService.getById(patrolTypeId);
            if (null == patrolTypeDictionary) {
                return AjaxList.createError("上传类型错误", null);
            }
            patrolRecord.setPatrolTypeName(patrolTypeDictionary.getName());
        }
        String fileName = FileUtils.uploadPatrol(patrol);
        if (StringUtils.isEmpty(fileName)) {
            AjaxList.createError("上传失败，请重试", null);
        }
        patrolRecord.setCreateTime(new Date());
        patrolRecord.setFilePath(fileName);
        patrolRecord.setUserId(userId);
        patrolRecord.setExplain(explain);
        patrolRecord.setLatitude(latitude);
        patrolRecord.setLongitude(longitude);
        patrolRecord.setPatrolTypeId(patrolTypeId);
        patrolRecordsService.save(patrolRecord);
        return AjaxList.createSuccess("保存成功", null);
    }

    @RequestMapping(value = "getContacts", method = RequestMethod.GET)
    @ApiOperation(value = "获取系统联系人", notes = "获取系统联系人", httpMethod = "GET")
    public AjaxList getContacts() {
        Map<String, Object> params = new HashMap<>();
        return AjaxList.createSuccess("获取成功", userService.getAll(params));
    }

    @RequestMapping(value = "getPatrolType", method = RequestMethod.GET)
    @ApiOperation(value = "获取系统联系人", notes = "获取系统联系人", httpMethod = "GET")
    public AjaxList getPatrolType() {
        return AjaxList.createSuccess("获取成功", patrolTypeDictionaryService.getAll());
    }

}
