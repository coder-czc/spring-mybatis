package chen.cn.mapper;


import chen.cn.entity.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(@Param("deleteids") String[] deleteids); //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer id);

    List<Classes> selectAll();

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}