package com.poi.answer.bo;

/**
 * Created by Administrator on 2017/8/17.
 */
public class Permission {
    private int id;
    //权限名称
    private String permissionName;
    //权限描述
    private String descritpion;
    //授权链接
    private String url;
    //父节点id
    private int preId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPreId() {
        return preId;
    }

    public void setPreId(int preId) {
        this.preId = preId;
    }
}
