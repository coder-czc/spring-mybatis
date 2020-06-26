package chen.cn.controller;

import chen.cn.common.ServerResponse;
import chen.cn.entity.JcWithBLOBs;
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

@RequestMapping("/jcW")
public class JcWithBLOBsController {
    @Resource(name="jcWithBLOBsServiceImpl")  //这个注解表示自动注入JcWithBLOBsSeerviceImpl业务实现类

    @Autowired  //表示紧跟后面的字段进行封装（即getter和setter）

    private chen.cn.service.JcWithBLOBsService jcWithBLOBsService;  //这是与上面注入的业务实现类的接口



    @RequestMapping("/delete")

    @ResponseBody

    public void deleteByPrimaryKey(Integer id){

        jcWithBLOBsService.deleteByPrimaryKey(id);

    }



    @RequestMapping("/insert")

    @ResponseBody

    public void insert(JcWithBLOBs record){

        JcWithBLOBs jcWithBLOBs=new JcWithBLOBs();
        jcWithBLOBs.setName("yuwen");
        jcWithBLOBs.setCompanyOption("hello");
        jcWithBLOBs.setDepartOpinion("jiaowuchu");
        jcWithBLOBs.setkOverview("555");
        jcWithBLOBs.setAuthor("lisi");
        jcWithBLOBs.setCategoryId(1);
        jcWithBLOBs.setClassseId(1);
        jcWithBLOBs.setCourseId(1);
        jcWithBLOBs.setClassseText("8888");
        jcWithBLOBs.setCourseName("yuwen");
        jcWithBLOBs.setIsbn("NNNNN");
        jcWithBLOBs.setLevelsId(1);
        jcWithBLOBs.setMajorText("666");
        jcWithBLOBs.setSdTeacher(1);
        jcWithBLOBs.setPublisherId(1);
        jcWithBLOBs.setYesorno(1);
        jcWithBLOBs.setPrice(100.00);
        jcWithBLOBs.setTeacherUse(1);
        jcWithBLOBsService.insert(jcWithBLOBs);
    }



    @RequestMapping("/insertSelective")

    @ResponseBody

    public void insertSelective(JcWithBLOBs record){}



    @RequestMapping("/list")

    @ResponseBody

    public JcWithBLOBs list(HttpServletRequest request, HttpServletResponse response){

        JcWithBLOBs JcWithBLOBs=jcWithBLOBsService.selectByPrimaryKey(1);

        System.out.println(JcWithBLOBs.getName());

        return JcWithBLOBs;

    }



    @RequestMapping("/listall")

    @ResponseBody

    public List<JcWithBLOBs> listall(HttpServletRequest request, HttpServletResponse response){

        List<JcWithBLOBs> jcWithBLOBsList=jcWithBLOBsService.selectAll();

        return jcWithBLOBsList;

    }

    @RequestMapping("/checkJcWithBLOBs")

    @ResponseBody

    public ServerResponse checkJcWithBLOBs(@Param("name") String name){

        if(jcWithBLOBsService.checkJcWithBLOBs(name)>0){

            return ServerResponse.createBySuccess("可以使用管理");

        }else{

            return ServerResponse.createByErrorMessage("管理员信息已经");

        }

    }


    @RequestMapping("/updateByPrimaryKeySelective")

    @ResponseBody

    public void updateByPrimaryKeySelective(JcWithBLOBs record){



    }



    @RequestMapping("/updateByPrimaryKey")

    @ResponseBody

    public void updateByPrimaryKey(JcWithBLOBs record){

        JcWithBLOBs jcWithBLOBs=new JcWithBLOBs();
        jcWithBLOBs.setId(1);
        jcWithBLOBs.setName("yuwen");
        jcWithBLOBs.setCompanyOption("hello");
        jcWithBLOBs.setDepartOpinion("jiaowuchu");
        jcWithBLOBs.setkOverview("555");
        jcWithBLOBs.setAuthor("lisi");
        jcWithBLOBs.setCategoryId(1);
        jcWithBLOBs.setClassseId(1);
        jcWithBLOBs.setCourseId(1);
        jcWithBLOBs.setClassseText("8888");
        jcWithBLOBs.setCourseName("yuwen");
        jcWithBLOBs.setIsbn("NNNNN");
        jcWithBLOBs.setLevelsId(1);
        jcWithBLOBs.setMajorText("666");
        jcWithBLOBs.setSdTeacher(1);
        jcWithBLOBs.setPublisherId(1);
        jcWithBLOBs.setYesorno(1);
        jcWithBLOBs.setPrice(100.00);
        jcWithBLOBs.setTeacherUse(1);
        jcWithBLOBsService.insert(jcWithBLOBs);

    }
}
