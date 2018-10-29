package com.qianxx.qztaxi.webService.adminuser;

import com.qianxx.qztaxi.dao.user.PatrolTypeDictionaryDao;
import com.qianxx.qztaxi.po.PatrolTypeDictionary;
import com.qianxx.qztaxi.po.UserInfo;
import com.qianxx.qztaxi.service.PatrolTypeDictionaryService;
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

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/10/29 14:19
 */
@Controller
@RequestMapping("admin/patrolTypeDictionary")
@ApiIgnore
public class PatrolTypeDictionaryController {

    @Autowired
    private PatrolTypeDictionaryService patrolTypeDictionaryService;
    @Autowired
    private PatrolTypeDictionaryDao patrolTypeDictionaryDao;


    @RequestMapping("index")
    public String getPatrolTypeDictionary(Model model) {
        model.addAttribute("patrolTypeDictionary", patrolTypeDictionaryService.getAll());
        return "patrol_type_dictionary/index";
    }

    @RequestMapping(value = "getDictionaryList", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponse<PatrolTypeDictionary> getDictionaryList(HttpServletRequest request) {
        DatatableRequest datatableRequest = BaseController.getDatatableRequest(request);
        DatatableResponse<PatrolTypeDictionary> response = new DatatableResponse<>();
        response.setData(patrolTypeDictionaryDao.getPage(datatableRequest.getSearchMap()));
        response.setRecordsTotal(patrolTypeDictionaryDao.countByMap(datatableRequest.getSearchMap()));
        response.setDraw(datatableRequest.getDraw());
        response.setRecordsFiltered(response.getRecordsTotal());
        return response;
    }
}
