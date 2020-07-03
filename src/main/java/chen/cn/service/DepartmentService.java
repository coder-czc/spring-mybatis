package chen.cn.service;

import chen.cn.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentService {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(String[] iddeleteids);  //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    List<Department> selectAll();

    int checkDepartment(@Param("name") String name); //名称进行查询

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}
