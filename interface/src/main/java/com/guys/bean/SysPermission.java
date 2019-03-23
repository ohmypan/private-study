package com.guys.bean;

public class SysPermission {
    private Long id;

    private Long parentId;

    private String resName;

    private String resType;

    private String permission;

    private String url;

    public SysPermission(Long id, Long parentId, String resName, String resType, String permission, String url) {
        this.id = id;
        this.parentId = parentId;
        this.resName = resName;
        this.resType = resType;
        this.permission = permission;
        this.url = url;
    }

    public SysPermission() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType == null ? null : resType.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}