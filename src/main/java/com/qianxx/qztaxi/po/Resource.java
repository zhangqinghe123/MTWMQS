package com.qianxx.qztaxi.po;

public class Resource {
    private Integer id;
    private String name;
    private String iconClass;
    private String actionLink;
    private Integer fatherId;
    private String menuFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getActionLink() {
        return actionLink;
    }

    public void setActionLink(String actionLink) {
        this.actionLink = actionLink;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public String getMenuFlag() {
        return menuFlag;
    }

    public void setMenuFlag(String menuFlag) {
        this.menuFlag = menuFlag;
    }
}