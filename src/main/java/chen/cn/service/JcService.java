package chen.cn.service;

import chen.cn.entity.Jc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JcService {
    int deleteByPrimaryKey(Integer id);

    int insert(Jc record);

    int insertSelective(Jc record);

    Jc selectByPrimaryKey(Integer id);

    List<Jc> selectAll();

    int checkJc(@Param("name") String name); //名称进行查询

    int updateByPrimaryKeySelective(Jc record);

    int updateByPrimaryKey(Jc record);
}
