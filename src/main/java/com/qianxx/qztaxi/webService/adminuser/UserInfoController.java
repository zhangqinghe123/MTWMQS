package com.qianxx.qztaxi.webService.adminuser;

import com.qianxx.qztaxi.po.AppVersion;
import com.qianxx.qztaxi.webService.response.datatable.DatatableRequest;
import com.qianxx.qztaxi.webService.response.datatable.DatatableResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("menu", "userInfo");
        model.addAttribute("menu1", "userInfoSon1");
        return "userInfo/index";
    }

    @RequestMapping(value = "getUserInfoList", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponse<AppVersion> getUserInfoList(HttpServletRequest request) {
        DatatableRequest datatableRequest = getRequest(request);
        datatableRequest.getSearchMap().put("terminal", request.getParameter("terminal"));
        DatatableResponse<AppVersion> response = new DatatableResponse<>();
        response.setData(appVersionDao.getPage(datatableRequest.getSearchMap()));
        response.setRecordsTotal(appVersionDao.countByMap(datatableRequest.getSearchMap()));
        response.setDraw(datatableRequest.getDraw());
        response.setRecordsFiltered(response.getRecordsTotal());
        return response;
    }

    private DatatableRequest getRequest(HttpServletRequest request) {
        return BaseController.getDatatableRequest(request);
    }


}
