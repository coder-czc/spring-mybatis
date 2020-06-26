package chen.cn.service.impl;

import chen.cn.entity.Classes;
import chen.cn.mapper.ClassesMapper;
import chen.cn.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("classesServiceImpl")
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Classes record) {
        return classesMapper.insert(record);
    }

    @Override
    public int insertSelective(Classes record) {
        return 0;
    }

    @Override
    public Classes selectByPrimaryKey(Integer id) {
        return classesMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Classes> selectAll() {
        return classesMapper.selectAll();
    }

    @Override
    public int checkClasses(String name) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Classes record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Classes record) {
        return classesMapper.updateByPrimaryKey(record);
    }
}
