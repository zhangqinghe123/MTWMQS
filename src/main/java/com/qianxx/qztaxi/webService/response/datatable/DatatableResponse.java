package com.qianxx.qztaxi.webService.response.datatable;


import java.util.ArrayList;
import java.util.List;

public class DatatableResponse<T> {

    private List<T> data = new ArrayList<T>();// 数据
    private int draw;// 请求的次数
    private long recordsTotal;// 未过滤时的总记录数
    private long recordsFiltered;// 过滤后的总记录数
    private String ext;// 表格以外的数据
    private Object rows;// 表格以外的数据-Object类
    private List<String> permissionKeys;// 权限key-name Map

    public Object getSbMap() {
        return sbMap;
    }

    public void setSbMap(Object sbMap) {
        this.sbMap = sbMap;
    }

    private Object sbMap;// 装地图信息专用

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public List<String> getPermissionKeys() {
        return permissionKeys;
    }

    public void setPermissionKeys(List<String> permissionKeys) {
        this.permissionKeys = permissionKeys;
    }

}
