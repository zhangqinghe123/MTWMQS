package com.qianxx.qztaxi.webService.adminuser;

import com.qianxx.qztaxi.dao.user.PatrolTypeDictionaryDao;
import com.qianxx.qztaxi.po.PatrolTypeDictionary;
import com.qianxx.qztaxi.service.PatrolTypeDictionaryService;
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

    @RequestMapping("update")
    public String update(Model model, Integer id) {
        model.addAttribute("info", patrolTypeDictionaryDao.getById(id));
        return "patrol_type_dictionary/update";
    }

    @RequestMapping("doUpdate")
    @ResponseBody
    public AjaxList doUpdate(PatrolTypeDictionary patrolTypeDictionary) {
        if (patrolTypeDictionary.getId() == null || patrolTypeDictionary.getId().compareTo(1) < 0) {
            return AjaxList.createError("参数错误", null);
        }
        patrolTypeDictionaryDao.update(patrolTypeDictionary);
        return AjaxList.createSuccess("编辑成功", null);
    }

    @RequestMapping("doDelete")
    @ResponseBody
    public AjaxList doDelete(Integer id) {
        if (id == null || id < 1) {
            return AjaxList.createError("参数错误", null);
        }
        PatrolTypeDictionary patrolTypeDictionary = patrolTypeDictionaryDao.getById(id);
        if (patrolTypeDictionary == null) {
            return AjaxList.createError("您选择的记录不存在", null);
        }
        patrolTypeDictionaryService.deleteByIds(String.valueOf(id));
        return AjaxList.createSuccess("操作成功", null);
    }

    @RequestMapping("add")
    public String add() {
        return "patrol_type_dictionary/add";
    }

    @RequestMapping("doAdd")
    @ResponseBody
    public AjaxList doAdd(PatrolTypeDictionary patrolTypeDictionary) {
        patrolTypeDictionaryService.save(patrolTypeDictionary);
        return AjaxList.createSuccess("保存成功", null);
    }
}
