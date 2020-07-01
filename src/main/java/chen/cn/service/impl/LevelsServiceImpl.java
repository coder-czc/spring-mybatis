package chen.cn.service.impl;

import chen.cn.entity.Levels;
import chen.cn.mapper.ClassesMapper;
import chen.cn.mapper.LevelsMapper;
import chen.cn.service.LevelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("levelsServiceImpl")
public class LevelsServiceImpl implements LevelsService {
    @Autowired
    private LevelsMapper levelsMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return levelsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Levels record) {
        return levelsMapper.insert(record);
    }

    @Override
    public int insertSelective(Levels record) {
        return 0;
    }

    @Override
    public Levels selectByPrimaryKey(Integer id) {
        return levelsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Levels> selectAll() {
        return levelsMapper.selectAll();
    }

    @Override
    public int checkLevels(String name) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Levels record) {
        return levelsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Levels record) {
        return levelsMapper.updateByPrimaryKey(record);
    }
}
