package com.mr.mapper;

import com.mr.model.Ztree;
import com.mr.model.ZtreeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by niudd on 2018/11/17.
 */
public interface ZtreeMapper {

    List<ZtreeVO> listZtree(@Param("pid") int pid);

    List<Ztree> listZtrees();

    void deleteZtreeById(@Param("id") int id);

    void updateZtreeById(Map<String, Object> map);

    void saveZtreeNode(Ztree ztree);
}
