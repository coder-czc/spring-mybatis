package chen.cn.mapper;

import chen.cn.entity.Classes;
import chen.cn.entity.Levels;

import java.util.List;

public interface LevelsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Levels record);

    int insertSelective(Levels record);

    Levels selectByPrimaryKey(Integer id);

    List<Levels> selectAll();

    int updateByPrimaryKeySelective(Levels record);

    int updateByPrimaryKey(Levels record);
}