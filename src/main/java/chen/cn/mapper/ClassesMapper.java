package chen.cn.mapper;


import chen.cn.entity.Classes;

import java.util.List;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer id);

    List<Classes> selectAll();

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}