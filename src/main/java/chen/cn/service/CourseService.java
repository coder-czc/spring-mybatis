package chen.cn.service;

import chen.cn.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    List<Course> selectAll();

    int checkCourse(@Param("name") String name); //名称进行查询

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}
