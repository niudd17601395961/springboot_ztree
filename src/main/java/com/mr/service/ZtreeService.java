package com.mr.service;

import com.mr.model.Ztree;
import com.mr.model.ZtreeVO;

import java.util.List;
import java.util.Map;

/**
 * Created by niudd on 2018/11/17.
 */
public interface ZtreeService {
    List<ZtreeVO> listZtree();

    List<Ztree> listZtrees();

    void deleteZtreeById(int id);

    void updateZtreeById(Map<String, Object> map);

    Ztree saveZtreeNode(Ztree ztree);
}

