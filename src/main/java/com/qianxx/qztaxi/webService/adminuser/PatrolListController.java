package com.qianxx.qztaxi.webService.adminuser;

import com.qianxx.qztaxi.po.PatrolRecord;
import com.qianxx.qztaxi.service.PatrolRecordsService;
import com.qianxx.qztaxi.webService.response.datatable.DatatableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/10/29 14:19
 */
@Controller
@RequestMapping("admin/patrolList")
@ApiIgnore
public class PatrolListController {
    @Autowired
    private PatrolRecordsService patrolRecordsService;

    @RequestMapping("index")
    public String getPatrolTypeDictionary(Model model) {
        return "patrolInfo/index";
    }

    @RequestMapping(value = "getPatrolRecords", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponse<PatrolRecord> getPatrolRecords(HttpServletRequest request) {
        return patrolRecordsService.getPageData(request);
    }

}
