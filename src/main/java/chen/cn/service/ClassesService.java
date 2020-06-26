package chen.cn.service;

import chen.cn.entity.Classes;
import chen.cn.entity.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesService {
    int deleteByPrimaryKey(Integer id);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer id);

    List<Classes> selectAll();

    int checkClasses(@Param("name") String name); //名称进行查询

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}
