package com.qianxx.qztaxi.webService.adminuser;

import com.qianxx.qztaxi.dao.user.AppVersionDao;
import com.qianxx.qztaxi.po.AppVersion;
import com.qianxx.qztaxi.service.AppVersionService;
import com.qianxx.qztaxi.webService.response.AjaxList;
import com.qianxx.qztaxi.webService.response.datatable.DatatableRequest;
import com.qianxx.qztaxi.webService.response.datatable.DatatableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("admin/version")
@ApiIgnore
public class VersionController extends BaseController {

    @Autowired
    private AppVersionService appVersionService;

    @Autowired
    private AppVersionDao appVersionDao;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("menu", "versionUpdate");
        model.addAttribute("menu1", "versionUpdateSon1");
        return "version/index";
    }

    @RequestMapping(value = "getVersionList", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponse<AppVersion> getVersionList(HttpServletRequest request) {
        DatatableRequest datatableRequest = getRequest(request);
        DatatableResponse<AppVersion> response = new DatatableResponse<>();
        response.setData(appVersionDao.getPage(datatableRequest.getSearchMap()));
        response.setRecordsTotal(appVersionDao.countByMap(datatableRequest.getSearchMap()));
        response.setDraw(datatableRequest.getDraw());
        response.setRecordsFiltered(response.getRecordsTotal());
        return response;
    }

    @RequestMapping("add")
    public String add() {
        return "version/add";
    }

    @RequestMapping("doAdd")
    @ResponseBody
    public AjaxList doAdd(AppVersion appVersion) {
        if (!CollectionUtils.isEmpty(appVersionService.getByCodeInt(appVersion.getCodeInt()))) {
            return AjaxList.createError("版本号【" + appVersion.getVersionCode() + "】已存在，请重新输入", null);
        }
        appVersion.setCreateTime(new Date());
        appVersionService.doInsert(appVersion);
        return AjaxList.createSuccess("保存成功", null);
    }

    /**
     * 新增、编辑校验
     */

    @RequestMapping("doDelete")
    @ResponseBody
    public AjaxList doDelete(Integer versionId) {
        if (versionId == null || versionId < 1) {
            return AjaxList.createError("参数错误", null);
        }
        AppVersion appVersion = appVersionService.getById(versionId);
        if (appVersion == null) {
            return AjaxList.createError("您选择的记录不存在", null);
        }
        appVersionService.doDelete(versionId);
        return AjaxList.createSuccess("操作成功", null);
    }

}