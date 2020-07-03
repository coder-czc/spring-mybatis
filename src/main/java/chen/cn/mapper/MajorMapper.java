package chen.cn.mapper;


import chen.cn.entity.Classes;
import chen.cn.entity.Major;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(@Param("deleteids") String[] deleteids); //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer id);

    List<Major> selectAll();

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}