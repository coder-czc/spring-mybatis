package chen.cn.service;

import chen.cn.entity.Major;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MajorService {
    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer id);

    List<Major> selectAll();

    int checkMajor(@Param("name") String name); //名称进行查询

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}
