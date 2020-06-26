package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.Jc;
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

@RequestMapping("/jc")
public class JcController {
    @Resource(name="jcServiceImpl")  //这个注解表示自动注入JcSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private chen.cn.service.JcService jcService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/delete")

    @ResponseBody

    public void deleteByPrimaryKey(Integer id){

        jcService.deleteByPrimaryKey(id);

    }



    @RequestMapping("/insert")

    @ResponseBody

    public void insert(Jc record){

        Jc jc=new Jc();
        jc.setName("yuwen");
        jc.setAuthor("lisi");
        jc.setCategoryId(1);
        jc.setClassseId(1);
        jc.setCourseId(1);
        jc.setCourseName("yuwen");
        jc.setIsbn("NNNNN");
        jc.setLevelsId(1);
        jc.setMajorText("666");
        jc.setSdTeacher(1);
        jc.setPublisherId(1);
        jc.setYesorno(1);
        jc.setPrice(100.00);
        jc.setTeacherUse(1);
        jcService.insert(jc);
    }



    @RequestMapping("/insertSelective")

    @ResponseBody

    public void insertSelective(Jc record){}



    @RequestMapping("/list")

    @ResponseBody

    public Jc list(HttpServletRequest request, HttpServletResponse response){

        Jc Jc=jcService.selectByPrimaryKey(1);

        System.out.println(Jc.getName());

        return Jc;

    }



    @RequestMapping("/listall")

    @ResponseBody

    public List<Jc> listall(HttpServletRequest request, HttpServletResponse response){

        List<Jc> jcList=jcService.selectAll();

        return jcList;

    }

    @RequestMapping("/checkJc")

    @ResponseBody

    public ServerResponse checkJc(@Param("name") String name){

        if(jcService.checkJc(name)>0){

            return ServerResponse.createBySuccess("可以使用管理");

        }else{

            return ServerResponse.createByErrorMessage("管理员信息已经");

        }

    }


    @RequestMapping("/updateByPrimaryKeySelective")

    @ResponseBody

    public void updateByPrimaryKeySelective(Jc record){



    }



    @RequestMapping("/updateByPrimaryKey")

    @ResponseBody

    public void updateByPrimaryKey(Jc record){

        Jc jc=new Jc();
        jc.setId(1);
        jc.setName("yuwen");
        jc.setAuthor("lisi");
        jc.setCategoryId(1);
        jc.setClassseId(1);
        jc.setCourseId(1);
        jc.setCourseName("yuwen");
        jc.setIsbn("NNNNN");
        jc.setLevelsId(1);
        jc.setMajorText("666");
        jc.setSdTeacher(1);
        jc.setPublisherId(1);
        jc.setYesorno(1);
        jc.setPrice(100.00);
        jc.setTeacherUse(1);
        jcService.insert(jc);

    }
}
