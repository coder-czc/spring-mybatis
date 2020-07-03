package chen.cn.mapper;


import chen.cn.entity.Classes;
import chen.cn.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByList(@Param("deleteids") String[] deleteids); //批量删除数据，要删除数据存放在一个字符数组中

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    List<Course> selectAll();

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}