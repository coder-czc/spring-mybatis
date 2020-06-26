package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.Classes;
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

@RequestMapping("/classes")
public class ClassesController {
    @Resource(name="classesServiceImpl")  //这个注解表示自动注入ClassesSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private chen.cn.service.ClassesService classesService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/delete")

    @ResponseBody

    public void deleteByPrimaryKey(Integer id){

        classesService.deleteByPrimaryKey(id);

    }



    @RequestMapping("/insert")

    @ResponseBody

    public void insert(Classes record){

        Classes classes=new Classes();
        classes.setName("yuwen");
        classes.setMajorId(1);
        classes.setMajorName("jisuanji");
        classes.setStudentNumber(1);
        classesService.insert(classes);
    }



    @RequestMapping("/insertSelective")

    @ResponseBody

    public void insertSelective(Classes record){}



    @RequestMapping("/list")

    @ResponseBody

    public Classes list(HttpServletRequest request, HttpServletResponse response){

        Classes Classes=classesService.selectByPrimaryKey(1);

        System.out.println(Classes.getName());

        return Classes;

    }



    @RequestMapping("/listall")

    @ResponseBody

    public List<Classes> listall(HttpServletRequest request, HttpServletResponse response){

        List<Classes> classesList=classesService.selectAll();

        return classesList;

    }

    @RequestMapping("/checkClasses")

    @ResponseBody

    public ServerResponse checkClasses(@Param("name") String name){

        if(classesService.checkClasses(name)>0){

            return ServerResponse.createBySuccess("可以使用管理");

        }else{

            return ServerResponse.createByErrorMessage("管理员信息已经");

        }

    }


    @RequestMapping("/updateByPrimaryKeySelective")

    @ResponseBody

    public void updateByPrimaryKeySelective(Classes record){



    }



    @RequestMapping("/updateByPrimaryKey")

    @ResponseBody

    public void updateByPrimaryKey(Classes record){

        Classes classes=new Classes();
        classes.setId(1);
        classes.setName("yingyu");
        classes.setMajorId(1);
        classes.setMajorName("jisuanji");
        classes.setStudentNumber(1);
        classesService.insert(classes);

    }
}
