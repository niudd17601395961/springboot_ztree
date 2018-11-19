package com.mr.model;

import java.util.List;

/**
 * Created by niudd on 2018/11/17.
 */
public class ZtreeVO extends Ztree {
    private List<ZtreeVO> children;

    public List<ZtreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<ZtreeVO> children) {
        this.children = children;
    }
}
