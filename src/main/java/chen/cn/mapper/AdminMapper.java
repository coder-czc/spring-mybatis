package chen.cn.mapper;

import chen.cn.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    List<Admin> selectAll();

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int checkAdmin(@Param("name") String name); //名称进行查询



    int checkEmail(@Param("Email") String email); //邮箱进行查询



    int checkPhone(@Param("phone") String phone); //电话进行查询



    int checkPass(@Param("pass") String pass);  //密码进行查询


}