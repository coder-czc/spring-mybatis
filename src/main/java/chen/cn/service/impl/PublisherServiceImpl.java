package chen.cn.service.impl;

import chen.cn.entity.Publisher;
import chen.cn.mapper.PublisherMapper;
import chen.cn.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("publisherServiceImpl")
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherMapper publisherMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return publisherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Publisher record) {
        return publisherMapper.insert(record);
    }

    @Override
    public int insertSelective(Publisher record) {
        return 0;
    }

    @Override
    public Publisher selectByPrimaryKey(Integer id) {
        return publisherMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Publisher> selectAll() {
        return publisherMapper.selectAll();
    }

    @Override
    public int checkPublisher(String name) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Publisher record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Publisher record) {
        return publisherMapper.updateByPrimaryKey(record);
    }
}
