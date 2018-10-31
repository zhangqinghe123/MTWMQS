package com.qianxx.qztaxi.webService.adminuser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

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
    @RequestMapping("index")
    public String getPatrolTypeDictionary(Model model) {
        return "patrolInfo/index";
    }
}
