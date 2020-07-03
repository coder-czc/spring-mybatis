package chen.cn.service;

import chen.cn.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {

    int deleteByPrimaryKey(Integer id);

    int deleteByList(String[] iddeleteids);  //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    List<Admin> selectAll();

    int checkAdmin(@Param("name") String name); //名称进行查询



    int checkEmail(@Param("Email") String email); //邮箱进行查询



    int checkPhone(@Param("phone") String phone); //电话进行查询



    int checkPass(@Param("pass") String pass);  //密码进行查询



    boolean checkNameAndPass(String name, String pass);//用户和密码进行查询



    boolean checkEmailAndPass(String email, String pass);



    boolean checkPhoneAndPass(String phone, String pass);


    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

}
