package com.mr.model;

/**
 * Created by niudd on 2018/11/17.
 */
public class Ztree {
    private Integer id;
    private String name;
    private boolean open;
    private Integer pid;

    @Override
    public String toString() {
        return "Ztree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", open=" + open +
                ", pid=" + pid +
                '}';
    }

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

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
