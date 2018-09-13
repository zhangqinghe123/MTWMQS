package com.qianxx.qztaxi.webService.adminuser;

import com.qianxx.qztaxi.common.Code;
import com.qianxx.qztaxi.common.CommonDataInit;
import com.qianxx.qztaxi.common.ErrCodeConstants;
import com.qianxx.qztaxi.common.util.Constants;
import com.qianxx.qztaxi.po.AdminUser;
import com.qianxx.qztaxi.service.AdminUserService;
import com.qianxx.qztaxi.webService.response.AjaxList;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ApiIgnore
public class LoginController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("/login")
    public String login(Model model) {
        return "login/login";
    }

    /**
     * 获得验证码
     */
    @RequestMapping("/login/code")
    public void code(HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        try {
            String code = Code.generateVerifyCode(4);
            request.getSession().setAttribute("code", code);
            Code.outputImage(200, 80, response.getOutputStream(), code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/login/ajaxLogin")
    @ResponseBody
    public AjaxList ajaxLogin(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password,
                              @RequestParam(value = "code") String code, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String c = (String) session.getAttribute("code");
        if (StringUtils.isBlank(code) || StringUtils.isBlank(c)) {
            return AjaxList.createJsonDate(Constants.API_STATUS_SUCCESS, ErrCodeConstants.ERR_2002_WRONG_PASSWORD, "验证码错误", null);
        } else if (!code.toUpperCase().equals(c.toUpperCase())) {
            return AjaxList.createJsonDate(Constants.API_STATUS_SUCCESS, ErrCodeConstants.ERR_2002_WRONG_PASSWORD, "验证码错误", null);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("account", username);
        List<AdminUser> adminUserList = adminUserService.getAll(params);
        if (!CollectionUtils.isEmpty(adminUserList)) {
            AdminUser adminUser = adminUserList.get(0);
            if ( password.equals(adminUser.getPassword())){
                session.setAttribute("userId", adminUser.getId());
                Map<String, Object> map1 = new HashMap<>();
                map1.put("userId", adminUser.getId());
                session.setAttribute("name", adminUser.getAccount());
                // 菜单设置,目前写法只支持二级菜单
                session.setAttribute("roleResouces", CommonDataInit.MENU_LIST);
                // 菜单设置结束
                return AjaxList.createSuccess("登录成功", adminUser);
            }
        }
        return AjaxList.createJsonDate(Constants.API_STATUS_SUCCESS, ErrCodeConstants.ERR_2002_WRONG_PASSWORD, "账号或密码错误", null);
    }

    @RequestMapping(value = "/admin/index")
    public String denied(Model model) {
        return "/login/index";
    }

    @RequestMapping(value = "/admin/logout")
    @ResponseBody
    public AjaxList logout(Model model) {
        return AjaxList.createSuccess("成功", null);
    }

}