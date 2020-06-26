package chen.cn.service.impl;

import chen.cn.entity.Jc;
import chen.cn.mapper.JcMapper;
import chen.cn.service.JcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("jcServiceImpl")
public class JcServiceImpl implements JcService {
    @Autowired
    private JcMapper jcMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return jcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Jc record) {
        return jcMapper.insert(record);
    }

    @Override
    public int insertSelective(Jc record) {
        return 0;
    }

    @Override
    public Jc selectByPrimaryKey(Integer id) {
        return jcMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Jc> selectAll() {
        return jcMapper.selectAll();
    }

    @Override
    public int checkJc(String name) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Jc record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Jc record) {
        return jcMapper.updateByPrimaryKey(record);
    }
}
