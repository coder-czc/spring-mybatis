package chen.cn.service.impl;

import chen.cn.entity.Major;
import chen.cn.mapper.ClassesMapper;
import chen.cn.mapper.MajorMapper;
import chen.cn.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("majorServiceImpl")
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return majorMapper.deleteByPrimaryKey(id);
    }


    @Override

    public int deleteByList(String[] ids) {  //注意方法参数是字符串的数组

        return majorMapper.deleteByList(ids);

    }

    @Override
    public int insert(Major record) {
        return majorMapper.insert(record);
    }

    @Override
    public int insertSelective(Major record) {
        return 0;
    }

    @Override
    public Major selectByPrimaryKey(Integer id) {
        return majorMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Major> selectAll() {
        return majorMapper.selectAll();
    }

    @Override
    public int checkMajor(String name) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Major record) {
        return majorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Major record) {
        return majorMapper.updateByPrimaryKey(record);
    }
}
