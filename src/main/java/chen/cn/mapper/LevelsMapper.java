package chen.cn.mapper;

import chen.cn.entity.Classes;
import chen.cn.entity.Levels;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LevelsMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(@Param("deleteids") String[] deleteids); //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Levels record);

    int insertSelective(Levels record);

    Levels selectByPrimaryKey(Integer id);

    List<Levels> selectAll();

    int updateByPrimaryKeySelective(Levels record);

    int updateByPrimaryKey(Levels record);
}