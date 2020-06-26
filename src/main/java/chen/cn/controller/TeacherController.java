package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Resource(name="teacherServiceImpl")  //这个注解表示自动注入TeacherSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private chen.cn.service.TeacherService teacherService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/delete")

    @ResponseBody

    public void deleteByPrimaryKey(Integer id){

        teacherService.deleteByPrimaryKey(id);

    }



    @RequestMapping("/insert")

    @ResponseBody

    public void insert(Teacher record){

        Teacher teacher=new Teacher();
        teacher.setAnswer("lisi");
        teacher.setDepartId(1);
        teacher.setDepartName("jiaowuchu");
        teacher.setEmail("1@qq.com");
        teacher.setName("zhangsan");
        teacher.setPass("666");
        teacher.setPhone("110");
        teacher.setQq("101");
        teacher.setQuestion("???");
        teacher.setUtype(1);
        teacherService.insert(teacher);
    }



    @RequestMapping("/insertSelective")

    @ResponseBody

    public void insertSelective(Teacher record){}



    @RequestMapping("/list")

    @ResponseBody

    public Teacher list(HttpServletRequest request, HttpServletResponse response){

        Teacher teacher=teacherService.selectByPrimaryKey(1);

        System.out.println(teacher.getName());

        return teacher;

    }



    @RequestMapping("/listall")

    @ResponseBody

    public List<Teacher> listall(HttpServletRequest request, HttpServletResponse response){

        List<Teacher> teacherList=teacherService.selectAll();

        return teacherList;

    }

    @RequestMapping("/checkTeacher")

    @ResponseBody

    public ServerResponse checkTeacher(@Param("name") String name){

        if(teacherService.checkTeacher(name)>0){

            return ServerResponse.createBySuccess("可以使用管理");

        }else{

            return ServerResponse.createByErrorMessage("管理员信息已经");

        }

    }


    @RequestMapping("/updateByPrimaryKeySelective")

    @ResponseBody

    public void updateByPrimaryKeySelective(Teacher record){



    }



    @RequestMapping("/updateByPrimaryKey")

    @ResponseBody

    public void updateByPrimaryKey(Teacher record){

        Teacher teacher=new Teacher();
        teacher.setId(1);
        teacher.setAnswer("lisi");
        teacher.setDepartId(1);
        teacher.setDepartName("jiaowuchu");
        teacher.setEmail("1@qq.com");
        teacher.setName("zhangsan");
        teacher.setPass("666");
        teacher.setPhone("110");
        teacher.setQq("101");
        teacher.setQuestion("???");
        teacher.setUtype(1);
        teacherService.updateByPrimaryKey(teacher);
    }
}
