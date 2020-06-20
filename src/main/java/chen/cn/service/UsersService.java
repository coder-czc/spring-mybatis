package chen.cn.service;

import chen.cn.entity.Users;

import java.util.List;

public interface UsersService {

    int deleteByPrimaryKey(Integer id);

    int insert(Users users);

    int insertSelective(Users record);

    List<Users> selectAll();

    Users selectByPrimaryKey(Integer id);

    int selectByNameAndPass(String name,String pass);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users users);

}