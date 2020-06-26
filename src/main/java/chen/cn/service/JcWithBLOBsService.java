package chen.cn.service;

import chen.cn.entity.JcWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JcWithBLOBsService {
    int deleteByPrimaryKey(Integer id);

    int insert(JcWithBLOBs record);

    int insertSelective(JcWithBLOBs record);

    JcWithBLOBs selectByPrimaryKey(Integer id);

    List<JcWithBLOBs> selectAll();

    int checkJcWithBLOBs(@Param("name") String name); //名称进行查询

    int updateByPrimaryKeySelective(JcWithBLOBs record);

    int updateByPrimaryKey(JcWithBLOBs record);
}
