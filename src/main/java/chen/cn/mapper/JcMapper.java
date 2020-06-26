package chen.cn.mapper;


import chen.cn.entity.Jc;
import chen.cn.entity.JcWithBLOBs;

import java.util.List;

public interface JcMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jc record);

    int insertSelective(Jc record);

    Jc selectByPrimaryKey(Integer id);

    List<Jc> selectAll();

    int updateByPrimaryKeySelective(Jc record);

    int updateByPrimaryKeyWithBLOBs(Jc record);

    int updateByPrimaryKey(Jc record);
}