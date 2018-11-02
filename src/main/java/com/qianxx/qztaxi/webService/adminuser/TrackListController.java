package com.qianxx.qztaxi.webService.adminuser;

import com.qianxx.qztaxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("admin/trackList")
@ApiIgnore
public class TrackListController {
    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("userList", userService.getAll());
        return "trackMap/trackMap";
    }

}
