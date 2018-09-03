package com.qianxx.qztaxi.vo;

import java.util.List;

/**
 * <p>
 * 字段IDValueObject.
 * </p>
 */
public class RoleResouce {
    /**
     * 名称
     **/
    private String name;
    /**
     * 地址连接
     **/
    private String actionLink;
    private String iconClass;// 一级菜单图标class
    private String menuFlag;// 同步跳转标识
    private List<RoleResouce> sons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActionLink() {
        return actionLink;
    }

    public void setActionLink(String actionLink) {
        this.actionLink = actionLink;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getMenuFlag() {
        return menuFlag;
    }

    public void setMenuFlag(String menuFlag) {
        this.menuFlag = menuFlag;
    }

    public List<RoleResouce> getSons() {
        return sons;
    }

    public void setSons(List<RoleResouce> sons) {
        this.sons = sons;
    }
}