package com.mr.controller;

import com.mr.model.Ztree;
import com.mr.model.ZtreeVO;
import com.mr.service.ZtreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by niudd on 2018/11/17.
 */
@Controller
public class ZtreeController {

    @Autowired
    private ZtreeService ztreeService;

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

    @ResponseBody
    @RequestMapping("listZtree")
    public List<ZtreeVO> listZtree(){
        List<ZtreeVO> ztreeVOList= ztreeService.listZtree();
        return ztreeVOList;
    }

    /**
     * 通过ztree提供的ajax异步查询
     * 只需要将全部数据查询之后返回。
     * ztree会自动根据  id  pid将数据加载
     * @return
     */
    @ResponseBody
    @RequestMapping("listZtrees")
    public List<Ztree> listZtrees(){
        List<Ztree> list=ztreeService.listZtrees();
        return list;
    }

    @ResponseBody
    @PostMapping("deleteZtreeById/{id}")
    public void deleteZtreeById(@PathVariable("id") int id){
        ztreeService.deleteZtreeById(id);
    }

    @ResponseBody
    @RequestMapping("updateZtreeById/{id}/{newName}")
    public void updateZtreeById(@PathVariable("id") int id,
                                @PathVariable("newName") String newName
                                ){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("newName",newName);
        ztreeService.updateZtreeById(map);
    }

    @ResponseBody
    @PostMapping("saveZtreeNode")
    private Ztree saveZtreeNode(int pid, String name){
        Ztree ztree = new Ztree();
        ztree.setPid(pid);
        ztree.setName(name);
        ztreeService.saveZtreeNode(ztree);
        return ztree;
    }
}
