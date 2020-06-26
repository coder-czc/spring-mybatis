package chen.cn.mapper;

import chen.cn.entity.Jc;
import chen.cn.entity.JcWithBLOBs;

import java.util.List;

public interface JcWithBLOBsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JcWithBLOBs record);

    int insertSelective(JcWithBLOBs record);

    JcWithBLOBs selectByPrimaryKey(Integer id);

    List<JcWithBLOBs> selectAll();

    int updateByPrimaryKeySelective(JcWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(JcWithBLOBs record);

    int updateByPrimaryKey(JcWithBLOBs record);
}
