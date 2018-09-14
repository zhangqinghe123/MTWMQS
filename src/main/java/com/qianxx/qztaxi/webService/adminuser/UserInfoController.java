package com.qianxx.qztaxi.webService.adminuser;

import com.qianxx.qztaxi.common.yingyan.TrackHandler;
import com.qianxx.qztaxi.common.yingyan.api.track.GetTrackRequest;
import com.qianxx.qztaxi.dao.user.UserInfoDao;
import com.qianxx.qztaxi.po.UserInfo;
import com.qianxx.qztaxi.service.UserService;
import com.qianxx.qztaxi.webService.response.AjaxList;
import com.qianxx.qztaxi.webService.response.datatable.DatatableRequest;
import com.qianxx.qztaxi.webService.response.datatable.DatatableResponse;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/13 14:18
 */
@Controller
@RequestMapping("admin/userInfo")
@ApiIgnore
public class UserInfoController {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("menu", "userInfo");
        model.addAttribute("menu1", "userInfoSon1");
        return "userInfo/index";
    }

    @RequestMapping(value = "getUserInfoList", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponse<UserInfo> getUserInfoList(HttpServletRequest request) {
        DatatableRequest datatableRequest = BaseController.getDatatableRequest(request);
        datatableRequest.getSearchMap().put("mobile", request.getParameter("mobile"));
        DatatableResponse<UserInfo> response = new DatatableResponse<>();
        response.setData(userInfoDao.getPage(datatableRequest.getSearchMap()));
        response.setRecordsTotal(userInfoDao.countByMap(datatableRequest.getSearchMap()));
        response.setDraw(datatableRequest.getDraw());
        response.setRecordsFiltered(response.getRecordsTotal());
        return response;
    }

    @RequestMapping("update")
    public String update(Model model, Integer id) {
        model.addAttribute("userInfo", userInfoDao.getById(id));
        return "userInfo/update";
    }

    @RequestMapping("doUpdate")
    @ResponseBody
    public AjaxList doUpdate(UserInfo userInfo) {
        if (userInfo.getId() == null || userInfo.getId().compareTo(1) < 0) {
            return AjaxList.createError("参数错误", null);
        }
        UserInfo oldUserInfo = userInfoDao.getById(userInfo.getId());
        if (oldUserInfo == null) {
            return AjaxList.createError("参数错误", null);
        }
        if (!oldUserInfo.getAccount().equals(userInfo.getAccount())) {
            Map<String, Object> param = new HashMap<>();
            param.put("account", userInfo.getAccount());
            long count = userInfoDao.countByMap(param);
            if (count > 0) {
                return AjaxList.createError("账号【" + userInfo.getAccount() + "】已存在，请重新输入", null);
            }
        }
        userInfoDao.update(userInfo);
        return AjaxList.createSuccess("编辑成功", null);
    }

    @RequestMapping("doDelete")
    @ResponseBody
    public AjaxList doDelete(Integer id) {
        if (id == null || id < 1) {
            return AjaxList.createError("参数错误", null);
        }
        UserInfo userInfo = userService.getById(id);
        if (userInfo == null) {
            return AjaxList.createError("您选择的记录不存在", null);
        }
        userService.deleteByIds(String.valueOf(id));
        return AjaxList.createSuccess("操作成功", null);
    }

    @RequestMapping("add")
    public String add() {
        return "userInfo/add";
    }

    @RequestMapping("doAdd")
    @ResponseBody
    public AjaxList doAdd(UserInfo userInfo) {
        Map<String, Object> param = new HashMap<>();
        param.put("account", userInfo.getAccount());
        long count = userInfoDao.countByMap(param);
        if (count > 0) {
            return AjaxList.createError("账号【" + userInfo.getAccount() + "】已存在，请重新输入", null);
        }
        userService.save(userInfo);
        return AjaxList.createSuccess("保存成功", null);
    }

    /**
     * 进入行程地图页面
     */
    @RequestMapping(value = "/getTrack/{id}")
    public String getOrderMap(@PathVariable Integer id, Model model) {
        model.addAttribute("userId", id);
        return "/userInfo/trackMap";
    }

    /**
     * 查询行程信息
     */
    @RequestMapping(value = "/findMapPoint")
    public @ResponseBody
    AjaxList findMapPoint(@RequestParam Integer userId, @RequestParam String startTime, @RequestParam String endTime) {
        if (null == userId) {
            return AjaxList.createError("用户ID不能为空", null);
        }
        UserInfo userInfo = userInfoDao.getById(userId);
        if (null == userInfo) {
            return AjaxList.createError("无该用户信息", null);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        GetTrackRequest getTrackRequest = new GetTrackRequest();
        getTrackRequest.setEntityName(userInfo.getAccount());
        try {
            getTrackRequest.setEndTime(sdf.parse(endTime).getTime()/1000);
            getTrackRequest.setStartTime(sdf.parse(startTime).getTime()/1000);
        }catch (Exception e){
            return AjaxList.createError("起止时间格式不正确", null);
        }
        List<Map<String, String>> pointList = TrackHandler.getTrack(getTrackRequest);
        if (CollectionUtils.isEmpty(pointList)) {
            return AjaxList.createError("无轨迹数据", null);
        }
        Map<String, Object> sumap = new HashMap<>();
//        sumap.put("orderList", pointList);
        return AjaxList.createSuccess("成功", sumap);
    }
}
