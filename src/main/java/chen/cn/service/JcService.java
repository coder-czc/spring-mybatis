package chen.cn.service;

import chen.cn.entity.Jc;
import chen.cn.entity.JcWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JcService {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(String[] iddeleteids);  //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Jc record);

    int insertSelective(Jc record);

    JcWithBLOBs selectByPrimaryKey(Integer id);

    List<JcWithBLOBs> selectAll();

    int checkJc(@Param("name") String name); //名称进行查询

    int updateByPrimaryKeySelective(Jc record);

    int updateByPrimaryKey(Jc record);
}
