package chen.cn.mapper;

import chen.cn.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UsersMapper {

    int deleteByPrimaryKey(@Param(value = "id") Integer id);

    int insert(Users record);

    int insertSelective(Users users);

    Users selectByPrimaryKey(Integer id);

    int selectByNameAndPass(@Param(value = "name") String name,@Param(value = "pass") String pass);

    List<Users> selectAll();

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users users);

}

