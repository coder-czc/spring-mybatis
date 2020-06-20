package chen.cn.service.impl;

import chen.cn.entity.Users;
import chen.cn.mapper.UsersMapper;
import chen.cn.service.UsersService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usersServiceImpl")
public class UsersServiceImpl implements UsersService {

    @Autowired  //表示紧跟它定义的变量会被自动的进行封装。

    private UsersMapper usersMapper; //即usersMapper变量不用进行get和set设置

//下面的方法用于向UsersMapper进行对数据表users进行操作。

    public int deleteByPrimaryKey(Integer id) {

        return usersMapper.deleteByPrimaryKey(id);

    }

    public int insert(Users users) {
usersMapper.insert(users);
        return 0;
    }

    public int insertSelective(Users record) {

        return 0;

    }

    public List<Users> selectAll() {
        return usersMapper.selectAll();
    }

    public Users selectByPrimaryKey(Integer id) {

        return usersMapper.selectByPrimaryKey(id);//根据users数据表的id进行查询

    }

    public int selectByNameAndPass(String name,String pass){
        return usersMapper.selectByNameAndPass(name,pass);
    }

    public int updateByPrimaryKeySelective(Users record) {

        return 0;

    }

    public int updateByPrimaryKey(Users users) {
        usersMapper.updateByPrimaryKey(users);
        return 0;

    }

}

