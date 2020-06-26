package chen.cn.mapper;


import chen.cn.entity.Publisher;

import java.util.List;

public interface PublisherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Publisher record);

    int insertSelective(Publisher record);

    Publisher selectByPrimaryKey(Integer id);

    List<Publisher> selectAll();

    int updateByPrimaryKeySelective(Publisher record);

    int updateByPrimaryKey(Publisher record);
}