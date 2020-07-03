package chen.cn.service;

import chen.cn.entity.Publisher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublisherService {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(String[] iddeleteids);  //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Publisher record);

    int insertSelective(Publisher record);

    Publisher selectByPrimaryKey(Integer id);

    List<Publisher> selectAll();

    int checkPublisher(@Param("name") String name); //名称进行查询

    int updateByPrimaryKeySelective(Publisher record);

    int updateByPrimaryKey(Publisher record);
}
