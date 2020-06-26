package chen.cn.service.impl;

import chen.cn.entity.JcWithBLOBs;
import chen.cn.mapper.JcWithBLOBsMapper;
import chen.cn.service.JcWithBLOBsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jcWithBLOBsServiceImpl")
public class JcWithBLOBsServiceImpl implements JcWithBLOBsService {
    @Autowired
    private JcWithBLOBsMapper jcWithBLOBsMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return jcWithBLOBsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JcWithBLOBs record) {
        return jcWithBLOBsMapper.insert(record);
    }

    @Override
    public int insertSelective(JcWithBLOBs record) {
        return 0;
    }

    @Override
    public JcWithBLOBs selectByPrimaryKey(Integer id) {
        return jcWithBLOBsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<JcWithBLOBs> selectAll() {
        return jcWithBLOBsMapper.selectAll();
    }

    @Override
    public int checkJcWithBLOBs(String name) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(JcWithBLOBs record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(JcWithBLOBs record) {
        return jcWithBLOBsMapper.updateByPrimaryKey(record);
    }
}
