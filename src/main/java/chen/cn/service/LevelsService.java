package chen.cn.service;

import chen.cn.entity.Levels;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LevelsService {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(String[] iddeleteids);  //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Levels record);

    int insertSelective(Levels record);

    Levels selectByPrimaryKey(Integer id);

    List<Levels> selectAll();

    int checkLevels(@Param("name") String name); //名称进行查询

    int updateByPrimaryKeySelective(Levels record);

    int updateByPrimaryKey(Levels record);
}
