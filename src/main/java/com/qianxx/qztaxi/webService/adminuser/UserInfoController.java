package com.qianxx.qztaxi.webService.adminuser;

import com.qianxx.qztaxi.common.util.Constants;
import com.qianxx.qztaxi.dao.user.UserInfoDao;
import com.qianxx.qztaxi.po.AppVersion;
import com.qianxx.qztaxi.po.UserInfo;
import com.qianxx.qztaxi.webService.response.AjaxList;
import com.qianxx.qztaxi.webService.response.datatable.DatatableRequest;
import com.qianxx.qztaxi.webService.response.datatable.DatatableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

}
