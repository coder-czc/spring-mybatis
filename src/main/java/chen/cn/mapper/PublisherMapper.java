package chen.cn.mapper;


import chen.cn.entity.Publisher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublisherMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(@Param("deleteids") String[] deleteids); //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Publisher record);

    int insertSelective(Publisher record);

    Publisher selectByPrimaryKey(Integer id);

    List<Publisher> selectAll();

    int updateByPrimaryKeySelective(Publisher record);

    int updateByPrimaryKey(Publisher record);
}