package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller //这是控制器的的注解，代码当前类为一个控制器

@RequestMapping("/course")
public class CourseController {
    @Resource(name="courseServiceImpl")  //这个注解表示自动注入CourseSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private chen.cn.service.CourseService courseService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/delete")

    @ResponseBody

    public void deleteByPrimaryKey(Integer id){

        courseService.deleteByPrimaryKey(id);

    }



    @RequestMapping("/insert")

    @ResponseBody

    public void insert(Course record){

        Course course=new Course();
        course.setName("yuwen");
        course.setCode("1");
        course.setNature("jisuanji");
        course.setPeriod(1);
        courseService.insert(course);
    }



    @RequestMapping("/insertSelective")

    @ResponseBody

    public void insertSelective(Course record){}



    @RequestMapping("/list")

    @ResponseBody

    public Course list(HttpServletRequest request, HttpServletResponse response){

        Course Course=courseService.selectByPrimaryKey(1);

        System.out.println(Course.getName());

        return Course;

    }



    @RequestMapping("/listall")

    @ResponseBody

    public List<Course> listall(HttpServletRequest request, HttpServletResponse response){

        List<Course> courseList=courseService.selectAll();

        return courseList;

    }

    @RequestMapping("/checkCourse")

    @ResponseBody

    public ServerResponse checkCourse(@Param("name") String name){

        if(courseService.checkCourse(name)>0){

            return ServerResponse.createBySuccess("可以使用管理");

        }else{

            return ServerResponse.createByErrorMessage("管理员信息已经");

        }

    }


    @RequestMapping("/updateByPrimaryKeySelective")

    @ResponseBody

    public void updateByPrimaryKeySelective(Course record){



    }



    @RequestMapping("/updateByPrimaryKey")

    @ResponseBody

    public void updateByPrimaryKey(Course record){

        Course course=new Course();
        course.setId(1);
        course.setName("yuwen");
        course.setCode("1");
        course.setNature("jisuanji");
        course.setPeriod(1);
        courseService.insert(course);

    }
}
