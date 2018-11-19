package com.mr.service.impl;

import com.mr.mapper.ZtreeMapper;
import com.mr.model.Ztree;
import com.mr.model.ZtreeVO;
import com.mr.service.ZtreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by niudd on 2018/11/17.
 */
@Service
public class ZtreeServiceImpl implements ZtreeService{
    @Autowired
    private ZtreeMapper ztreeMapper;


    @Override
    public List<ZtreeVO> listZtree() {
        //通过pid进行查询
         List<ZtreeVO> list=ztreeMapper.listZtree(0);
         //查询子节点
        for (int i = 0; i < list.size(); i++) {
            //将当前的id作为pid去查询
            ZtreeVO ztreeVO = list.get(i);
            List<ZtreeVO> childrens = ztreeMapper.listZtree(ztreeVO.getId());
            ztreeVO.setChildren(childrens);
        }
         
        return list;
    }

    @Override
    public List<Ztree> listZtrees() {
        return ztreeMapper.listZtrees();
    }

    @Override
    public void deleteZtreeById(int id) {
        ztreeMapper.deleteZtreeById(id);
    }

    @Override
    public void updateZtreeById(Map<String, Object> map) {
        ztreeMapper.updateZtreeById(map);
    }

    @Override
    public Ztree saveZtreeNode(Ztree ztree) {
        ztreeMapper.saveZtreeNode(ztree);
        return ztree;
    }
}
