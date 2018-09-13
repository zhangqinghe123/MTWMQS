package com.qianxx.qztaxi.common;

import com.qianxx.qztaxi.po.AdminUser;
import com.qianxx.qztaxi.po.RoleResouce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/3 15:44
 */
public class CommonDataInit {
    public static Map<String,AdminUser> ADMIN_USER_MAP = new HashMap<>();
    public static List<RoleResouce> MENU_LIST = new ArrayList<>();
    static {

        // 系统首页
        RoleResouce sysIndex = new RoleResouce();
        sysIndex.setName("系统首页");
        sysIndex.setIconClass("icon-home");
        sysIndex.setActionLink("admin/index");
        MENU_LIST.add(sysIndex);

        // 软件更新页面
        RoleResouce appUpdateMenuSon1 = new RoleResouce();
        appUpdateMenuSon1.setName("软件更新");
        appUpdateMenuSon1.setActionLink("admin/version");
        appUpdateMenuSon1.setMenuFlag("versionUpdateSon1");
        List<RoleResouce> appUpdateMenuSonList = new ArrayList<>();
        appUpdateMenuSonList.add(appUpdateMenuSon1);
        RoleResouce appUpdateMenu = new RoleResouce();
        appUpdateMenu.setName("软件更新");
        appUpdateMenu.setIconClass("icon-center");
        appUpdateMenu.setMenuFlag("versionUpdate");
        appUpdateMenu.setSons(appUpdateMenuSonList);
        MENU_LIST.add(appUpdateMenu);

    }
}
